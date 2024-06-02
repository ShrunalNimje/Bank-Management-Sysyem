package my.mood;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    String pinNumber;
    JButton exit;

    public MiniStatement(String pinNumber){

        this.pinNumber = pinNumber;

        setSize(550, 700);
        setLocation(350, 100);
        setVisible(true);

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Bandhoo Bank");
        text.setFont(new Font("Arial", Font.BOLD, 24));
        text.setBounds(175,30,200,20);
        text.setForeground(Color.black);
        add(text);

        JLabel cardL = new JLabel();
        cardL.setFont(new Font("Raleway", Font.PLAIN, 16));
        cardL.setBounds(50,80,400,30);
        cardL.setForeground(Color.black);
        add(cardL);

        JLabel miniStatement = new JLabel();
        miniStatement.setFont(new Font("Raleway", Font.PLAIN, 16));
        miniStatement.setBounds(50,140,400,500);
        miniStatement.setForeground(Color.black);
        add(miniStatement);

        exit = new JButton("Exit");
        exit.setBounds(380,600,100,25);
        exit.setFont(new Font("Raleway", Font.BOLD, 14));
        exit.setForeground(Color.white);
        exit.setBackground(Color.black);
        exit.addActionListener(this);
        add(exit);

        DBConnection c = new DBConnection();

        try{
            String query = "select * from bank where pin = '"+pinNumber+"'";
            ResultSet rs = c.s.executeQuery(query);

            while(rs.next()){
                miniStatement.setText(miniStatement.getText() +
                        "<html>"+
                        rs.getString("date")+
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("type") +
                        "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("amount") +
                        "<br><br><html>");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            String query1 = "select * from login where Pin_Number = '"+pinNumber+"'";
            ResultSet rs1 = c.s.executeQuery(query1);

            while(rs1.next()){
                cardL.setText("Card Number :     " + rs1.getString("Card_Number").substring(0,4) +
                        "-XXXX-XXXX-" +
                        rs1.getString("Card_Number").substring(12));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }

    public static void main(String [] args){

        new MiniStatement("");

    }
}

