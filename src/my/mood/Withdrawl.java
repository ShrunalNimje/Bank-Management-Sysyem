package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{

    String pinNumber;
    JTextField textField;
    JButton withdraw, cancel;

    public Withdrawl(String pinNumber){

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

        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setFont(new Font("Arial", Font.BOLD, 18));
        text.setBounds(160,230,400,20);
        text.setForeground(Color.white);
        image.add(text);

        textField= new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setBounds(200,270,260,25);
        image.add(textField);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(370,375,120,20);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 14));
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        else if(ae.getSource() == withdraw){
            if(amountS.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter a valid amount");
            }

            else{
                Date date = new Date();
                try{
                    DBConnection DBC = new DBConnection();
                    String query6 = "select * from bank where pin = '"+pinNumber+"'";

                    int amount = Integer.parseInt(amountS);
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
                        JOptionPane.showMessageDialog(null, "Insufficient balance to Withdraw");
                    }
                    else{
                        String query = "insert into bank values('"+pinNumber+"','"+date+"', 'Withdraw', '"+amountS+"')";
                        DBC.s.executeUpdate(query);

                        JOptionPane.showMessageDialog(null, "Rs. " + amountS + " withdraw successfully");

                        setVisible(false);
                        new Transactions(pinNumber).setVisible(true);
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String [] args){

        new Withdrawl("");
    }
}

