package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{

    JTextField textField;
    JButton deposit, cancel;
    String pinNumber;

    public Deposit(String pinNumber){

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

        JLabel text = new JLabel("Enter the amount you want to deposit");
        text.setFont(new Font("Arial", Font.BOLD, 18));
        text.setBounds(170,230,400,20);
        text.setForeground(Color.white);
        image.add(text);

        textField= new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setBounds(200,270,260,25);
        image.add(textField);

        deposit = new JButton("Deposit");
        deposit.setBounds(370,375,120,20);
        deposit.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        image.add(deposit);

        cancel = new JButton("Cancel");
        cancel.setBounds(370,400,120,20);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        image.add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent ae){

        String amountS = textField.getText();

        if(ae.getSource() == cancel){
            textField.setText("");
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == deposit){
            if(amountS.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a valid amount");
            }
            else{
                Date date = new Date();
                try{
                    DBConnection DBC = new DBConnection();
                    String query5 = "insert into bank values('"+pinNumber+"','"+date+"', 'Deposit', '"+amountS+"')";
                    DBC.s.executeUpdate(query5);

                    JOptionPane.showMessageDialog(null, "Rs " + amountS + " deposited successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    public static void main(String [] args){

        new Deposit("");

    }
}

