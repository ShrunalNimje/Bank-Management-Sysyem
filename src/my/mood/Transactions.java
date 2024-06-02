package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{

    JButton deposit, withdrawl, changePin,
            statement, exit, fastCash, balance;
    String pinNumber;

    public Transactions(String pinNumber){

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


        JLabel text = new JLabel("Please select your transaction");
        text.setFont(new Font("Arial", Font.BOLD, 18));
        text.setBounds(200,230,400,20);
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,325,150,20);
        deposit.setFont(new Font("Raleway", Font.BOLD, 14));
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(350,325,150,20);
        withdrawl.setFont(new Font("Raleway", Font.BOLD, 14));
        withdrawl.setForeground(Color.black);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,350,150,20);
        fastCash.setFont(new Font("Raleway", Font.BOLD, 14));
        fastCash.setForeground(Color.black);
        fastCash.addActionListener(this);
        image.add(fastCash);

        changePin = new JButton("Change Pin");
        changePin.setBounds(350,350,150,20);
        changePin.setFont(new Font("Raleway", Font.BOLD, 14));
        changePin.setForeground(Color.black);
        changePin.addActionListener(this);
        image.add(changePin);

        statement = new JButton("Mini Statement");
        statement.setBounds(170,375,150,20);
        statement.setFont(new Font("Raleway", Font.BOLD, 14));
        statement.setForeground(Color.black);
        statement.addActionListener(this);
        image.add(statement);

        balance = new JButton("Balance");
        balance.setBounds(350,375,150,20);
        balance.setFont(new Font("Raleway", Font.BOLD, 14));
        balance.setForeground(Color.black);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(350,400,150,20);
        exit.setFont(new Font("Raleway", Font.BOLD, 14));
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        image.add(exit);

    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            System.exit(0);
        }
        else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == fastCash){
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == changePin){
            setVisible(false);
            new ChangePin(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == statement){
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == balance){
            setVisible(false);
            new Balance(pinNumber).setVisible(true);
        }
    }
    public static void main(String [] args){

        new Transactions("");
    }
}
