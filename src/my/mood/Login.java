package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    // define globaly
    JLabel title, cardNo, pin;
    JTextField text;
    JPasswordField password;
    JButton signIn, cancel, signUp;

    public Login(){

        // Title of frame
        setTitle("Automated Teller machine");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/skyBlue.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel j1 = new JLabel(ii3);
        j1.setBounds(100,20,100,80);
        image.add(j1);
        setLayout(null);

        title = new JLabel("Automated Teller Machine");
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setBounds(250, 20, 500, 80);
        image.add(title);

        cardNo = new JLabel("Card No. : ");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 24));
        cardNo.setBounds(120, 150, 150, 30);
        image.add(cardNo);

        text = new JTextField();
        text.setFont(new Font("Raleway", Font.PLAIN, 18));
        text.setBounds(300, 150, 270, 30);
        image.add(text);

        pin = new JLabel("Pin : ");
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        pin.setBounds(120, 210, 200, 30);
        image.add(pin);

        password = new JPasswordField();
        password.setFont(new Font("Raleway", Font.PLAIN, 18));
        password.setBounds(300, 210, 270, 30);
        image.add(password);

        signIn = new JButton("SIGN IN");
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.setFont(new Font("Raleway", Font.BOLD, 18));
        signIn.setBounds(300, 280, 120, 30);
        signIn.addActionListener(this);
        image.add(signIn);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 18));
        cancel.setBounds(450, 280, 120, 30);
        cancel.addActionListener(this);
        image.add(cancel);

        signUp = new JButton("SIGN UP");
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.setFont(new Font("Raleway", Font.BOLD, 18));
        signUp.setBounds(300, 330, 270, 30);
        signUp.addActionListener(this);
        image.add(signUp);

        setSize(900,700);
        setVisible(true);
        setLocation(350,100);



    }

    @Override
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == signIn){
            String cardS = text.getText();
            String pinS = password.getText();

            try{
                if(cardS.equals("") || pinS.equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill Card number or Pin");
                }
                else{
                    DBConnection DBc = new DBConnection();
                    String query4 = "select * from login where Card_Number = '"+cardS+"' and Pin_Number = '"+pinS+"'";
                    ResultSet rs = DBc.s.executeQuery(query4);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pinS).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                    }
                }
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == cancel){
            text.setText("");
            password.setText("");
        }
        else if(ae.getSource() == signUp){
            setVisible(false);
            new SignupOne().setVisible(true);
        }

    }
    public static void main(String [] args){
        new Login();

    }
}

