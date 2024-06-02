package my.mood;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    JButton deposit1, deposit2, deposit3,
            deposit4, deposit5, deposit6, cancel;
    String pinNumber;

    public FastCash(String pinNumber){

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


        JLabel text = new JLabel("Please select withdrawl amount");
        text.setFont(new Font("Arial", Font.BOLD, 18));
        text.setBounds(200,230,400,20);
        text.setForeground(Color.white);
        image.add(text);

        deposit1 = new JButton("Rs 100");
        deposit1.setBounds(170,325,150,20);
        deposit1.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit1.setForeground(Color.black);
        deposit1.addActionListener(this);
        image.add(deposit1);

        deposit2 = new JButton("Rs 200");
        deposit2.setBounds(350,325,150,20);
        deposit2.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit2.setForeground(Color.black);
        deposit2.addActionListener(this);
        image.add(deposit2);

        deposit3 = new JButton("Rs 500");
        deposit3.setBounds(170,350,150,20);
        deposit3.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit3.setForeground(Color.black);
        deposit3.addActionListener(this);
        image.add(deposit3);

        deposit4 = new JButton("Rs 1000");
        deposit4.setBounds(350,350,150,20);
        deposit4.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit4.setForeground(Color.black);
        deposit4.addActionListener(this);
        image.add(deposit4);

        deposit5 = new JButton("Rs 2000");
        deposit5.setBounds(170,375,150,20);
        deposit5.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit5.setForeground(Color.black);
        deposit5.addActionListener(this);
        image.add(deposit5);

        deposit6 = new JButton("Rs 5000");
        deposit6.setBounds(350,375,150,20);
        deposit6.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit6.setForeground(Color.black);
        deposit6.addActionListener(this);
        image.add(deposit6);

        cancel = new JButton("Cancel");
        cancel.setBounds(350,400,150,20);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setForeground(Color.black);
        cancel.addActionListener(this);
        image.add(cancel);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancel){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else{
            try{
                String amountS = ((JButton)ae.getSource()).getText().substring(3);
                int amount = Integer.parseInt(amountS);
                DBConnection DBC = new DBConnection();
                String query6 = "select * from bank where pin = '"+pinNumber+"'";

                ResultSet rs = DBC.s.executeQuery(query6);
                int balance = 0;

                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+= Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance-= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(balance < amount){
                    JOptionPane.showMessageDialog(null, "Insufficient balance");
                }
                else{
                    Date date = new Date();
                    String query7 = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amountS+"')";
                    DBC.s.executeUpdate(query7);

                    JOptionPane.showMessageDialog(null, "Rs " + amountS + " Withdrawed successfully");

                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.println("Error is : " + e);
            }
        }
    }
    public static void main(String [] args){

        new FastCash("");
    }
}

