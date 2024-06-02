package my.mood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    JTextField panTF, aadharTF;
    JRadioButton seniorYes, seniorNo, accountYes, accountNo;
    JButton next, cancel;
    JLabel additionalDetails, religionL, categoryL, incomeL,
            educationalL, qualificationL, occupationL,
            panL, aadharL, seniorL, accountL;
    JComboBox religionCB, categoryCB, incomeCB, qualificationCB, occupationCB;
    ButtonGroup seniorGroup, accountGroup;
    String form;

    public SignupTwo(String formNo){
        this.form= formNo;
        setSize(900,700);
        setVisible(true);
        setLocation(350,100);

        getContentPane().setBackground(Color.white);
        setLayout(null);

        additionalDetails = new JLabel("Page 2 : Additional Details ");
        additionalDetails.setBounds(250, 70, 400, 40);
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 24));
        add(additionalDetails);

        religionL = new JLabel("Religion :");
        religionL.setBounds(80, 130, 80, 20);
        religionL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(religionL);

        String [] religionArr = {"Hindu", "Muslim", "Sikh", "Cristian", "Others"};
        religionCB = new JComboBox(religionArr);
        religionCB.setBackground(Color.white);
        religionCB.setBounds(250,130,400,20);
        religionCB.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(religionCB);

        categoryL = new JLabel("Category :");
        categoryL.setBounds(80, 170, 120, 20);
        categoryL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(categoryL);

        String [] categoryArr = {"General", "OBC", "SC/ST", "VJ/NT/SBC", "Others"};
        categoryCB = new JComboBox(categoryArr);
        categoryCB.setBackground(Color.white);
        categoryCB.setBounds(250,170,400,20);
        categoryCB.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(categoryCB);

        incomeL = new JLabel("Income :");
        incomeL.setBounds(80, 210, 120, 20);
        incomeL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(incomeL);

        String [] incomeArr = {"Null", "less than 100000", "in between 100000 and 250000", "more than 500000"};
        incomeCB = new JComboBox(incomeArr);
        incomeCB.setBackground(Color.white);
        incomeCB.setBounds(250, 210, 400, 20);
        incomeCB.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(incomeCB);


        educationalL = new JLabel("Educational");
        educationalL.setBounds(80, 250, 120, 20);
        educationalL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(educationalL);

        qualificationL = new JLabel("Qualification :");
        qualificationL.setBounds(80, 270, 120, 20);
        qualificationL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(qualificationL);

        String [] qualificationArr = {"Null", "10th", "12th ", "Graduation", "Post-graduation"};
        qualificationCB = new JComboBox(qualificationArr);
        qualificationCB.setBackground(Color.white);
        qualificationCB.setBounds(250,260,400,30);
        qualificationCB.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(qualificationCB);

        occupationL = new JLabel("Occupation :");
        occupationL.setBounds(80, 330, 120, 20);
        occupationL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(occupationL);

        String [] occupationArr = {"Null", "student", "self-employed ", "business", "others"};
        occupationCB = new JComboBox(occupationArr);
        occupationCB.setBackground(Color.white);
        occupationCB.setBounds(250,330,400,20);
        occupationCB.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(occupationCB);

        panL = new JLabel("Pan Number :");
        panL.setBounds(80, 370, 120, 20);
        panL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(panL);

        panTF = new JTextField();
        panTF.setBounds(250,370,400,20);
        panTF.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(panTF);

        aadharL = new JLabel("Aadhar No. :");
        aadharL.setBounds(80, 410, 120, 20);
        aadharL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(aadharL);

        aadharTF = new JTextField();
        aadharTF.setBounds(250,410,400,20);
        aadharTF.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(aadharTF);

        seniorL = new JLabel("Senior Citizen :");
        seniorL.setBounds(80, 450, 120, 20);
        seniorL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(seniorL);

        seniorYes = new JRadioButton("Yes");
        seniorYes.setBounds(280,450,100,20);
        seniorYes.setBackground(Color.white);
        seniorYes.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(seniorYes);

        seniorNo = new JRadioButton("No");
        seniorNo.setBounds(460,450,100,20);
        seniorNo.setBackground(Color.white);
        seniorNo.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(seniorNo);

        seniorGroup = new ButtonGroup();
        seniorGroup.add(seniorYes);
        seniorGroup.add(seniorNo);

        accountL = new JLabel("Existing Acc. :");
        accountL.setBounds(80, 490, 120, 20);
        accountL.setFont(new Font("Raleway", Font.BOLD, 16));
        add(accountL);

        accountYes = new JRadioButton("Yes");
        accountYes.setBounds(280,490,100,20);
        accountYes.setBackground(Color.white);
        accountYes.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(accountYes);

        accountNo = new JRadioButton("No");
        accountNo.setBounds(460,490,100,20);
        accountNo.setBackground(Color.white);
        accountNo.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(accountNo);

        accountGroup = new ButtonGroup();
        accountGroup.add(accountYes);
        accountGroup.add(accountNo);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 20));
        cancel.setBounds(250, 530, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(530, 530, 120, 30);
        next.addActionListener(this);
        add(next);

    }

    @Override
    public void actionPerformed(ActionEvent ae){

        String formNo = form;
        String religionS = (String) religionCB.getSelectedItem();
        String categoryS = (String) categoryCB.getSelectedItem();
        String incomeS = (String) incomeCB.getSelectedItem();
        String qualificationS = (String) qualificationCB.getSelectedItem();
        String occupationS = (String) occupationCB.getSelectedItem();
        String panS = panTF.getText();
        String aadharS = aadharTF.getText();

        String seniorS = null;
        if(seniorYes.isSelected()){
            seniorS = "Yes";
        }
        else if(seniorNo.isSelected()){
            seniorS = "NO";
        }

        String accountS = null;
        if(accountYes.isSelected()){
            accountS = "Yes";
        }
        else if(accountNo.isSelected()){
            accountS = "NO";
        }

        if(ae.getSource() == cancel){
            panTF.setText("");
            aadharTF.setText("");
        }
        else{
            try{
                if(panTF.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Pan Number is Required");
                }
                else if(aadharTF.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Aadhar Number is Required");
                }
                else if(seniorS == null){
                    JOptionPane.showMessageDialog(null,"Please check Senior Citizen field");
                }
                else if(accountS == null){
                    JOptionPane.showMessageDialog(null,"Please check Existing Account field");
                }
                else{
                    DBConnection dbc = new DBConnection();
                    String query2 = "insert into signupTwo value('"+formNo+"', '"+religionS+"', '"+categoryS+"', '"+incomeS+"', '"+qualificationS+"', '"+occupationS+"', '"+panS+"','"+aadharS+"', '"+seniorS+"', '"+accountS+"')";
                    dbc.s.executeUpdate(query2);

                    setVisible(false);
                    new SignupThree(formNo).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.print(e);
            }
        }
    }

    public static void main(String [] args){

        new SignupTwo("");
    }
}

