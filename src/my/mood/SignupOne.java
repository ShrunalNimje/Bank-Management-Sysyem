package my.mood;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    Random r;
    JTextField nameTF, fnameTF, emailTF, addressTF, cityTF, codeTF;
    JDateChooser dc;
    JRadioButton male, female, other, married, unmarried, others;
    JButton next, cancel;
    JLabel form, personalDetails, name, fatherName, dob, gender,
            emailAddress, maritalStatus, address, city, pinCode;
    int random;

    public SignupOne(){

        setSize(900,700);
        setVisible(true);
        setLocation(350,100);

        getContentPane().setBackground(Color.white);
        setLayout(null);

        r = new Random();
        random = Math.abs(r.nextInt() % 10000);

        form = new JLabel("APPLICATION FORM NO. " + random);
        form.setBounds(150, 20, 800, 40);
        form.setFont(new Font("Arial", Font.BOLD, 36));
        add(form);

        personalDetails = new JLabel("Page 1 : Personal Details ");
        personalDetails.setBounds(250, 70, 400, 40);
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 24));
        add(personalDetails);

        name = new JLabel("Name :");
        name.setBounds(80, 130, 80, 20);
        name.setFont(new Font("Raleway", Font.BOLD, 16));
        add(name);

        nameTF = new JTextField();
        nameTF.setBounds(250,130,400,20);
        nameTF.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(nameTF);

        fatherName = new JLabel("Father Name :");
        fatherName.setBounds(80, 170, 120, 20);
        fatherName.setFont(new Font("Raleway", Font.BOLD, 16));
        add(fatherName);

        fnameTF = new JTextField();
        fnameTF.setBounds(250,170,400,20);
        fnameTF.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(fnameTF);

        dob = new JLabel("Date Of Birth :");
        dob.setBounds(80, 210, 120, 20);
        dob.setFont(new Font("Raleway", Font.BOLD, 16));
        add(dob);

        JDateChooser dc = new JDateChooser();
        dc.setBounds(250, 210, 400, 20);
        dc.setForeground(Color.BLACK);
        add(dc);


        gender = new JLabel("Gender :");
        gender.setBounds(80, 250, 120, 20);
        gender.setFont(new Font("Raleway", Font.BOLD, 16));
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(250, 250, 100, 20);
        male.setFont(new Font("Raleway", Font.PLAIN, 14));
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 250, 100, 20);
        female.setFont(new Font("Raleway", Font.PLAIN, 14));
        female.setBackground(Color.white);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(550, 250, 100, 20);
        other.setFont(new Font("Raleway", Font.PLAIN, 14));
        other.setBackground(Color.white);
        add(other);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);

        emailAddress = new JLabel("Email Address :");
        emailAddress.setBounds(80, 290, 120, 20);
        emailAddress.setFont(new Font("Raleway", Font.BOLD, 16));
        add(emailAddress);

        emailTF = new JTextField();
        emailTF.setBounds(250,290,400,20);
        emailTF.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(emailTF);

        maritalStatus = new JLabel("Marital Status :");
        maritalStatus.setBounds(80, 330, 120, 20);
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 16));
        add(maritalStatus);

        married = new JRadioButton("Married");
        married.setBounds(250, 330, 100, 20);
        married.setFont(new Font("Raleway", Font.PLAIN, 14));
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 330, 100, 20);
        unmarried.setFont(new Font("Raleway", Font.PLAIN, 14));
        unmarried.setBackground(Color.white);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setBounds(550, 330, 100, 20);
        others.setFont(new Font("Raleway", Font.PLAIN, 14));
        others.setBackground(Color.white);
        add(others);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(others);

        address = new JLabel("Address :");
        address.setBounds(80, 370, 120, 20);
        address.setFont(new Font("Raleway", Font.BOLD, 16));
        add(address);

        addressTF = new JTextField();
        addressTF.setBounds(250,370,400,20);
        addressTF.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(addressTF);

        city = new JLabel("City :");
        city.setBounds(80, 410, 120, 20);
        city.setFont(new Font("Raleway", Font.BOLD, 16));
        add(city);

        cityTF = new JTextField();
        cityTF.setBounds(250,410,400,20);
        cityTF.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(cityTF);

        pinCode = new JLabel("Pin Code :");
        pinCode.setBounds(80, 450, 120, 20);
        pinCode.setFont(new Font("Raleway", Font.BOLD, 16));
        add(pinCode);

        codeTF = new JTextField();
        codeTF.setBounds(250,450,400,20);
        codeTF.setFont(new Font("Raleway", Font.PLAIN, 14));
        add(codeTF);


        next = new JButton("NEXT");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setBounds(530, 500, 120, 30);
        next.addActionListener(this);
        add(next);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 20));
        cancel.setBounds(250, 500, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent ae){

        String formNo = " "+ random;
        String name = nameTF.getText();
        String fname = fnameTF.getText();
        String email = emailTF.getText();
        String address = addressTF.getText();
        String city = cityTF.getText();
        String pinCode = codeTF.getText();

        if(ae.getSource() == cancel){
            nameTF.setText("");
            fnameTF.setText("");
            emailTF.setText("");
            addressTF.setText("");
            cityTF.setText("");
            codeTF.setText("");

        }
        else{
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }
            else if(female.isSelected()){
                gender = "Female";
            }
            else if(other.isSelected()) {
                gender = "Other";
            }

            String marital_status = null;
            if(married.isSelected()){
                marital_status = "Married";
            }
            else if(unmarried.isSelected()){
                marital_status = "Unmarried";
            }
            else if(others.isSelected()){
                marital_status = "Others";
            }

            try{
                if(nameTF.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Name is Required");
                }
                else if(fnameTF.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Father name is Required");
                }
                else if(emailTF.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Email address is Required");
                }
                else if(addressTF.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Address is Required");
                }
                else if(cityTF.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"City is Required");
                }
                else if(codeTF.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Pin code is Required");
                }
                else if(gender == null){
                    JOptionPane.showMessageDialog(null,"Gender is Required");
                }
                else if(marital_status == null){
                    JOptionPane.showMessageDialog(null,"Marital status is Required");
                }
                else{
                    DBConnection dbc = new DBConnection();
                    String query1 = "insert into signupOne value('"+formNo+"', '"+name+"', '"+fname+"', '"+gender+"', '"+email+"', '"+marital_status+"', '"+address+"','"+city+"', '"+pinCode+"')";
                    dbc.s.executeUpdate(query1);
                    setVisible(false);
                    new SignupTwo(formNo).setVisible(true);
                }
            }
            catch(Exception e){
                System.out.print(e);
            }
        }
    }

    public static void main(String [] args){

        new SignupOne();
    }
}

