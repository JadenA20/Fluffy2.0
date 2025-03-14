package GUI;

import Security.RegisterController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterUI extends JFrame{
    private JButton register, back;
    private JPanel breakPanel, contentPanel;
    private JTextField fname, lname, username, password, confirm_pass;
    private JLabel title, fnameLabel, lnameLabel, userLabel, passLabel, confirmLabel, roleLabel;
    private JComboBox<String> role;
    private String[] roles = {"Admin", "Normal"};
    private LoginUI LoginUI;
    private HomeUI HomeUI;

    public RegisterUI(HomeUI HomeUI, LoginUI LoginUI){

        //Set Panel Title
        setTitle("Register Baker");
        
        //Set Fonts
        Font ver1 = new Font("Courier New", Font.BOLD, 30);
        Font ver3 = new Font("Bradley Hand ITC", Font.BOLD, 30);

    
        //Creation of Main Panel
        contentPanel = new JPanel();
        contentPanel.setBackground(new Color(255,255, 255, 180));
        contentPanel.setBounds(0, 0, 600, 100);
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();


        //Instantiation and Addition of MainPanel Components
        title = new JLabel("REGISTER BAKER");                      //Panel Title
        title.setForeground(new Color(100, 67, 59));
        title.setFont(ver3);
        title.setBounds(30, 50, 300, 50);
        con.gridwidth = con.REMAINDER;
        con.gridx = 0;
        con.gridy = 0;
        con.ipady = 40;
        contentPanel.add(title, con);


        fnameLabel = new JLabel("First Name:");                     //First Name Label
        fnameLabel.setForeground(new Color(100, 67, 59));
        fnameLabel.setFont(ver1);
        fnameLabel.setBounds(20, 170, 300, 50);
        con.gridwidth = 1;
        con.gridx = 0;
        con.gridy = 1;
        con.ipady = 0;
        contentPanel.add(fnameLabel, con);


        fname = new JTextField(20);                              //First Name TextField
        fname.setForeground(new Color(100, 67, 59));
        fname.setFont(ver1);
        fname.setBounds(20, 170, 300, 50);
        con.gridx = 1;
        con.gridy = 1;
        contentPanel.add(fname, con);


        lnameLabel = new JLabel("Last Name:");                      //Last Name Field
        lnameLabel.setForeground(new Color(100, 67, 59));
        lnameLabel.setFont(ver1);
        lnameLabel.setBounds(20, 170, 300, 50);
        con.gridx = 0;
        con.gridy = 2;
        contentPanel.add(lnameLabel, con);


        lname = new JTextField(20);                              //Last Name Text Field
        lname.setForeground(new Color(100, 67, 59));
        lname.setFont(ver1);
        lname.setBounds(20, 170, 300, 50);
        con.gridx = 1;
        con.gridy = 2;
        contentPanel.add(lname, con);


        userLabel = new JLabel("Username:");                         //Username Label
        userLabel.setForeground(new Color(100, 67, 59));
        userLabel.setFont(ver1);
        userLabel.setBounds(20, 170, 300, 50);
        con.gridx = 0;
        con.gridy = 3;
        contentPanel.add(userLabel, con);


        username = new JTextField(20);                            //Username TextField
        username.setForeground(new Color(100, 67, 59));
        username.setFont(ver1);
        username.setBounds(20, 170, 300, 50);
        con.gridx = 1;
        con.gridy = 3;
        contentPanel.add(username, con);


        passLabel = new JLabel("Password:");                         //Password Label
        passLabel.setForeground(new Color(100, 67, 59));
        passLabel.setFont(ver1);
        passLabel.setBounds(20, 170, 300, 50);
        con.gridx = 0;
        con.gridy = 4;
        contentPanel.add(passLabel, con);


        password = new JTextField(20);                            //Password TextField
        password.setForeground(new Color(100, 67, 59));
        password.setFont(ver1);
        password.setBounds(20, 170, 300, 50);
        con.gridx = 1;
        con.gridy = 4;
        contentPanel.add(password, con);
      

        confirmLabel = new JLabel("Confirm Password:");              //Confirm Password Label
        confirmLabel.setForeground(new Color(100, 67, 59));
        confirmLabel.setFont(ver1);
        confirmLabel.setBounds(20, 170, 300, 50);
        con.gridx = 0;
        con.gridy = 5;
        contentPanel.add(confirmLabel, con);


        confirm_pass = new JTextField(20);                         //Confirm Password TextField
        confirm_pass.setForeground(new Color(100, 67, 59));
        confirm_pass.setFont(ver1);
        confirm_pass.setBounds(20, 170, 300, 50);
        con.gridx = 1;
        con.gridy = 5;
        contentPanel.add(confirm_pass, con);

        roleLabel = new JLabel("Select Account Type:");               //Select Role Label
        roleLabel.setForeground(new Color(100, 67, 59));
        roleLabel.setFont(ver1);
        roleLabel.setBounds(20, 170, 300, 50);
        con.gridx = 0;
        con.gridy = 6;
        contentPanel.add(roleLabel, con);

        role = new JComboBox<>(roles);                                     //Role Dropdown
        role.setFont(ver1);
        role.setBounds(150,50,130,15);
        con.gridx = 1;
        con.gridy = 6;
        contentPanel.add(role, con);


        //Creation of BreakPanel
        breakPanel = new JPanel();                                    
        breakPanel.setSize(200, 250);
        breakPanel.setBackground(new Color(255, 255, 255, 180));
        breakPanel.setBounds(20, 100, 300, 370);
        breakPanel.setLayout(null);
        con.gridx = 0;
        con.gridy = 7;
        con.ipady = 40;
        contentPanel.add(breakPanel, con);


        back = new JButton("Back");                                 //Cancel Button
        back.setBounds(170, 260, 100, 50);
        back.setBackground(new Color(100,67, 59));
        back.setForeground(new Color(255, 255, 255));
        back.setSize(new Dimension(100, 35));
        back.setFont(ver1);
        con.gridx = 0;
        con.gridy = 8;
        con.ipady = 0;
        contentPanel.add(back, con);


        register = new JButton("Register Baker");                     //Register Button
        register.setBounds(20, 370, 100, 50);
        register.setBackground(new Color(100,67, 59));
        register.setForeground(new Color(255, 255, 255));
        register.setSize(new Dimension(100, 35));
        register.setFont(ver1);
        con.gridx = 1;
        con.gridy = 8;
        contentPanel.add(register, con);

        
        //Action Listeners 
        register.addActionListener(new ButtonListener());
        back.addActionListener(new ButtonListener());

        //Create Screen
        add(contentPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 500));        
    }

    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            
            if(e.getSource() == register){
                //Get baker details
                String first = fname.getText();
                String last = lname.getText();
                String user = username.getText();
                String pass = password.getText();
                String confirmed = confirm_pass.getText();
                String type = (String) role.getSelectedItem();
                RegisterController rgCon = new RegisterController();
                
                boolean check = rgCon.passwordValid(pass, confirmed);

                if((first.equals("")) || (last.equals("") || (user.equals("")) || (pass.equals("")) || (confirmed.equals("")))){
                    //Error message
                    JOptionPane.showMessageDialog(RegisterUI.this, "Empty field detected. Please recheck registration information entered.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                else {

                    if(check == true){

                        if (type.equals("Normal")){

                            RegisterController conn = new RegisterController();
                            conn.registerBaker(first, last, user, pass);
                            JOptionPane.showMessageDialog(RegisterUI.this, "Registration Successful", "Success", JOptionPane.NO_OPTION);
    
                        }
                        else {

                            RegisterController conn = new RegisterController();
                            conn.registerAdmin(first, last, user, pass);
                            JOptionPane.showMessageDialog(RegisterUI.this, "Registration Successful", "Success", JOptionPane.NO_OPTION);

                        }
                        
                        
                    }
                    else {
                        JOptionPane.showMessageDialog(RegisterUI.this, "Password are not a match.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }  

            }

            else if(e.getSource() == back){
                HomeUI home = new HomeUI(LoginUI);
                setVisible(false);
            }      

        }

    }

}


