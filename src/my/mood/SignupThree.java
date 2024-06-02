package my.mood;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupThree extends JFrame implements ActionListener{

    JButton next;
    JRadioButton accountTypeRB, accountTypeRB1,
            accountTypeRB2, accountTypeRB3;
    JLabel accountDetails, accountTypeL,
            cardNumberL, cardNumberL1,
            cardNumberL2, pinNumberL,
            pinNumberL1, pinNumberL2,
            servicesL;
    JCheckBox servicesCB, servicesCB1, servicesCB2, servicesCB3, servicesCB4, servicesCB5, servicesCB6;
    String formNo;

    public SignupThree(String formNo){

        this.formNo = formNo;
        setSize(900, 700);
        setLocation(350,100);
        setVisible(true);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        accountDetails = new JLabel("Page 3 : Account Details");
        accountDetails.setFont(new Font("Arial", Font.BOLD, 24));
        accountDetails.setBounds(250, 70, 400, 40);
        add(accountDetails);

        accountTypeL = new JLabel("Account Type :");
        accountTypeL.setFont(new Font("Raleway", Font.BOLD, 16));
        accountTypeL.setBounds(100, 130, 200, 20);
        add(accountTypeL);

        accountTypeRB = new JRadioButton("Saving Account");
        accountTypeRB.setBackground(Color.white);
        accountTypeRB.setForeground(Color.black);
        accountTypeRB.setBounds(300, 130, 200, 20);
        accountTypeRB.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(accountTypeRB);

        accountTypeRB1 = new JRadioButton("Current Account");
        accountTypeRB1.setBackground(Color.white);
        accountTypeRB1.setForeground(Color.black);
        accountTypeRB1.setBounds(550, 130, 200, 20);
        accountTypeRB1.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(accountTypeRB1);

        accountTypeRB2 = new JRadioButton("Fixed Deposit Account");
        accountTypeRB2.setBackground(Color.white);
        accountTypeRB2.setForeground(Color.black);
        accountTypeRB2.setBounds(300, 160, 200, 20);
        accountTypeRB2.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(accountTypeRB2);

        accountTypeRB3 = new JRadioButton("Reccuring Deposit Account");
        accountTypeRB3.setBackground(Color.white);
        accountTypeRB3.setForeground(Color.black);
        accountTypeRB3.setBounds(550, 160, 250, 20);
        accountTypeRB3.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(accountTypeRB3);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(accountTypeRB);
        accountGroup.add(accountTypeRB1);
        accountGroup.add(accountTypeRB2);
        accountGroup.add(accountTypeRB3);

        cardNumberL = new JLabel("Card Number :");
        cardNumberL.setFont(new Font("Raleway", Font.BOLD, 16));
        cardNumberL.setBounds(100, 210, 200, 20);
        add(cardNumberL);

        cardNumberL2 = new JLabel("Your 16 digit card number");
        cardNumberL2.setFont(new Font("Raleway", Font.PLAIN, 12));
        cardNumberL2.setBounds(100, 230, 200, 15);
        add(cardNumberL2);

        cardNumberL1 = new JLabel("XXXX-XXXX-XXXX-1234");
        cardNumberL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        cardNumberL1.setBounds(300, 210, 200, 20);
        add(cardNumberL1);


        pinNumberL = new JLabel("Pin Number :");
        pinNumberL.setFont(new Font("Raleway", Font.BOLD, 16));
        pinNumberL.setBounds(100, 280, 200, 20);
        add(pinNumberL);

        pinNumberL2 = new JLabel("Your 4 digit pin number");
        pinNumberL2.setFont(new Font("Raleway", Font.PLAIN, 12));
        pinNumberL2.setBounds(100, 300, 200, 15);
        add(pinNumberL2);

        pinNumberL1 = new JLabel("1234");
        pinNumberL1.setFont(new Font("Raleway", Font.PLAIN, 16));
        pinNumberL1.setBounds(300, 280, 200, 20);
        add(pinNumberL1);

        servicesL = new JLabel("Services :");
        servicesL.setFont(new Font("Raleway", Font.BOLD, 16));
        servicesL.setBounds(100, 350, 200, 20);
        add(servicesL);

        servicesCB = new JCheckBox("mobile banking");
        servicesCB.setFont(new Font("Raleway", Font.PLAIN, 16));
        servicesCB.setBounds(300, 350, 150, 20);
        servicesCB.setBackground(Color.white);
        add(servicesCB);

        servicesCB1 = new JCheckBox("NEFT");
        servicesCB1.setFont(new Font("Raleway", Font.PLAIN, 16));
        servicesCB1.setBounds(550, 350, 150, 20);
        servicesCB1.setBackground(Color.white);
        add(servicesCB1);

        servicesCB2 = new JCheckBox("RTGS");
        servicesCB2.setFont(new Font("Raleway", Font.PLAIN, 16));
        servicesCB2.setBounds(300, 380, 150, 20);
        servicesCB2.setBackground(Color.white);
        add(servicesCB2);

        servicesCB3 = new JCheckBox("IMPS");
        servicesCB3.setFont(new Font("Raleway", Font.PLAIN, 16));
        servicesCB3.setBounds(550, 380, 150, 20);
        servicesCB3.setBackground(Color.white);
        add(servicesCB3);

        servicesCB4 = new JCheckBox("debit/credit cards");
        servicesCB4.setFont(new Font("Raleway", Font.PLAIN, 16));
        servicesCB4.setBounds(300, 410, 150, 20);
        servicesCB4.setBackground(Color.white);
        add(servicesCB4);

        servicesCB5 = new JCheckBox("net banking");
        servicesCB5.setFont(new Font("Raleway", Font.PLAIN, 16));
        servicesCB5.setBackground(Color.white);
        servicesCB5.setBounds(550, 410, 150, 20);
        add(servicesCB5);

        servicesCB6 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge");
        servicesCB6.setFont(new Font("Raleway", Font.PLAIN, 16));
        servicesCB6.setBackground(Color.white);
        servicesCB6.setBounds(100, 460, 700, 20);
        add(servicesCB6);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(500, 500, 150, 30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

    }

    @Override
    public void actionPerformed(ActionEvent ae){

        String accountS = null;
        if(accountTypeRB.isSelected()){
            accountS = "Saving Account";
        }
        else if(accountTypeRB1.isSelected()){
            accountS = "Current Account";
        }
        else if(accountTypeRB2.isSelected()){
            accountS = "Fixed Deposit Account";
        }
        else if(accountTypeRB3.isSelected()){
            accountS = "Reccuring Deposit Account";
        }

        Random random = new Random();
        long num = Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        String cardS ="" + num;

        long num1 = Math.abs((random.nextLong() % 9000L) + 1000L);
        String pinS = "" + num1;

        String servicesS = "";
        if(servicesCB.isSelected()){
            servicesS = servicesS + " Mobile Banking";
        }
        if(servicesCB1.isSelected()){
            servicesS = servicesS + " \nNEFT";
        }
        if(servicesCB2.isSelected()){
            servicesS = servicesS + " \nRTGS";
        }
        if(servicesCB3.isSelected()){
            servicesS = servicesS + " \nIMPS";
        }
        if(servicesCB4.isSelected()){
            servicesS = servicesS + " \nDebit/Credit Cards";
        }
        if(servicesCB5.isSelected()){
            servicesS = servicesS + " \nNet Banking";
        }

        try{
            if(accountS == null){
                JOptionPane.showMessageDialog(null, "Please fill account type field");
            }
            else if(servicesS.equals("")){
                JOptionPane.showMessageDialog(null, "Please fill at least one service field");
            }
            else if(!servicesCB6.isSelected()){
                JOptionPane.showMessageDialog(null, "Please select the below check box");
            }
            else{
                DBConnection DBc = new DBConnection();
                String query2 = "insert into signupThree values('"+formNo+"', '"+accountS+"', '"+cardS+"', '"+pinS+"', '"+servicesS+"')";
                String query3 = "insert into login values('"+formNo+"', '"+cardS+"', '"+pinS+"')";
                DBc.s.executeUpdate(query2);
                DBc.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Please note down the card number and pin");
                JOptionPane.showMessageDialog(null, "Card Number : " + cardS + " \nPin : " + pinS);

                setVisible(false);
                new Login().setVisible(true);
            }
        }
        catch(Exception e){
            System.out.print(e);
        }
    }

    public static void main(String [] args){

        new SignupThree("");
    }
}

