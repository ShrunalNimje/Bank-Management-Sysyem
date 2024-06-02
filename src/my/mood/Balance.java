package my.mood;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener{

    String pinNumber;
    JButton exit;

    public Balance(String pinNumber){

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

        JLabel text = new JLabel();
        text.setFont(new Font("Arial", Font.BOLD, 18));
        text.setBounds(220,250,400,20);
        text.setForeground(Color.white);
        image.add(text);

        exit = new JButton("Exit");
        exit.setBounds(390,405,100,20);
        exit.setFont(new Font("Raleway", Font.BOLD, 14));
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        image.add(exit);

        int balance = 0;

        try{
            DBConnection DBC = new DBConnection();
            String query6 = "select * from bank where pin = '"+pinNumber+"'";

            ResultSet rs = DBC.s.executeQuery(query6);

            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+= Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-= Integer.parseInt(rs.getString("amount"));
                }
            }

            text.setText("Your Balance is Rs. " + balance + " ");
        }
        catch(NumberFormatException | SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String [] args){

        new Balance("");

    }
}

