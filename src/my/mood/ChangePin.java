package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChangePin extends JFrame implements ActionListener{
    String pinNumber;
    JTextField oldTF, pinTF;
    JButton cancel, change;
    JPasswordField rePinTF;

    public ChangePin(String pinNumber){

        this.pinNumber = pinNumber;

        setSize(900, 700);
        setLocation(350, 100);
        setVisible(true);

        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        JLabel text = new JLabel("Change your Pin");
        text.setFont(new Font("Arial", Font.BOLD, 18));
        text.setBounds(260,230,400,20);
        text.setForeground(Color.white);
        image.add(text);

        JLabel oldPin = new JLabel("Old Pin :");
        oldPin.setFont(new Font("Arial", Font.BOLD, 18));
        oldPin.setBounds(220,280,120,20);
        oldPin.setForeground(Color.white);
        image.add(oldPin);

        JLabel pin = new JLabel("New Pin :");
        pin.setFont(new Font("Arial", Font.BOLD, 18));
        pin.setBounds(220,310,120,20);
        pin.setForeground(Color.white);
        image.add(pin);

        JLabel rePin = new JLabel("Re-enter new Pin :");
        rePin.setFont(new Font("Arial", Font.BOLD, 18));
        rePin.setBounds(180,340,180,20);
        rePin.setForeground(Color.white);
        image.add(rePin);

        oldTF= new JTextField();
        oldTF.setFont(new Font("Arial", Font.PLAIN, 16));
        oldTF.setBounds(360,280,120,20);
        image.add(oldTF);

        pinTF= new JTextField();
        pinTF.setFont(new Font("Arial", Font.PLAIN, 16));
        pinTF.setBounds(360,310,120,20);
        image.add(pinTF);

        rePinTF= new JPasswordField();
        rePinTF.setFont(new Font("Arial", Font.PLAIN, 16));
        rePinTF.setBounds(360,340,120,20);
        image.add(rePinTF);

        change = new JButton("Change");
        change.setBounds(390,400,100,25);
        change.setFont(new Font("Raleway", Font.BOLD, 14));
        change.setForeground(Color.black);
        change.addActionListener(this);
        image.add(change);

        cancel = new JButton("Cancel");
        cancel.setBounds(170,400,100,25);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        image.add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent ae){

        String pinS = pinTF.getText();
        String rePinS = rePinTF.getText();

        if(ae.getSource() == cancel){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == change){
            try{
                if(pinS.equals("") || rePinS.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new pin or Re-enter new pin");
                }
                else if(!rePinS.equals(pinS)){
                    JOptionPane.showMessageDialog(null, "New Pin and Re-enter new pin should be same");
                }
                else{
                    DBConnection c = new DBConnection();
                    String query9 = "update bank set pin = '"+rePinS+"' where pin = '"+pinNumber+"'";
                    String query10 = "update login set Pin_Number = '"+rePinS+"' where Pin_Number = '"+pinNumber+"'";
                    String query11 = "update signupThree set Pin_Number = '"+rePinS+"' where Pin_Number = '"+pinNumber+"'";
                    c.s.executeUpdate(query9);
                    c.s.executeUpdate(query10);
                    c.s.executeUpdate(query11);

                    JOptionPane.showMessageDialog(null, "Pin changed successfully");

                    setVisible(false);
                    new Transactions(rePinS).setVisible(true);

                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String [] args){

        new ChangePin("");

    }
}

