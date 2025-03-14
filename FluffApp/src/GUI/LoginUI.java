package GUI;

import Security.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LoginUI extends JFrame {

    private JButton login, exit;
    private JLabel title, usernameLabel, passwordLabel;
    private JTextField usernameField, passwordField;
    private JPanel mainPanel, breakPanel;
    private LoginUI LoginUI;


    public LoginUI() {

        this.LoginUI = this;

        //Setting a title for the pop-up screen
        setTitle("Login Screen");

        //Fonts
        Font ver1 = new Font("Courier New", Font.BOLD, 30);
        Font ver2 = new Font("Courier New", Font.BOLD, 20);
        Font ver3 = new Font("Bradley Hand ITC", Font.BOLD, 30);

        //Instantiation of MainPanel
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255,255, 255, 180));
        mainPanel.setBounds(0, 0, 600, 100);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();


        //Instantiation and Addition of MainPanel Components
        title = new JLabel("FLUFFY'S SWEET TREATS");                      //Panel Title
        title.setForeground(new Color(100, 67, 59));
        title.setFont(ver3);
        title.setBounds(30, 50, 300, 50);
        con.gridwidth = con.REMAINDER;
        con.gridx = 0;
        con.gridy = 0;
        con.ipady = 40;
        mainPanel.add(title, con);


        usernameLabel = new JLabel("Username:");                         //Username Label
        usernameLabel.setForeground(new Color(100, 67, 59));
        usernameLabel.setFont(ver1);
        usernameLabel.setBounds(20, 170, 300, 50);
        con.gridwidth = 1;
        con.gridx = 0;
        con.gridy = 1;
        con.ipady = 0;
        mainPanel.add(usernameLabel, con);


        usernameField = new JTextField(20);                           //Username Textfield
        usernameField.setBounds(20, 210, 200, 30);
        usernameField.setBackground(new Color(244, 235, 220));
        con.gridx = 1;
        con.gridy = 1;
        mainPanel.add(usernameField, con);

 
        passwordLabel = new JLabel("Password:");                         //Password Label
        passwordLabel.setForeground(new Color(100, 67, 59));
        passwordLabel.setFont(ver1);
        passwordLabel.setBounds(20, 170, 300, 50);
        con.gridwidth = 1;
        con.gridx = 0;
        con.gridy = 2;
        mainPanel.add(passwordLabel, con);


        passwordField = new JTextField(20);                            //Password Textfield
        passwordField.setBounds(20, 210, 200, 30);
        passwordField.setBackground(new Color(244, 235, 220));
        con.gridx = 1;
        con.gridy = 2;
        mainPanel.add(passwordField, con);


        login = new JButton("Login");                                      //Login Button
        login.setBounds(20, 260, 100, 50);
        login.setBackground(new Color(100,67, 59));
        login.setForeground(new Color(255, 255, 255));
        login.setSize(new Dimension(100, 35));
        login.setFont(ver1);
        con.gridx = 0;
        con.gridy = 3;
        mainPanel.add(login, con);
        

        exit = new JButton("Exit");                                         //Exit Button
        exit.setBounds(170, 460, 100, 50);
        exit.setBackground(new Color(100,67, 59));
        exit.setForeground(new Color(255, 255, 255));
        exit.setSize(new Dimension(100, 35));
        exit.setFont(ver1);
        con.gridx = 1;
        con.gridy = 3;
        mainPanel.add(exit, con);


        breakPanel = new JPanel();
        breakPanel.setSize(200, 250);
        breakPanel.setBackground(new Color(255, 255, 255, 180));
        breakPanel.setBounds(20, 100, 300, 370);
        breakPanel.setLayout(null);
        con.gridx = 0;
        con.gridy = 4;
        con.ipady = 60;
        mainPanel.add(breakPanel, con);
       
        

        //Action Listeners 
        login.addActionListener(new ButtonListener());
        exit.addActionListener(new ButtonListener());
            
        //Create Screen
        add(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(500, 500));
    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           
            if(e.getSource() == login){
                //Get username and password
                String username = usernameField.getText();
                String password = passwordField.getText();

                if((username.equals("")) || (password.equals(""))){
                    //Error message
                    JOptionPane.showMessageDialog(LoginUI.this, "Empty field detected. Please recheck login information entered.", "Error", JOptionPane.ERROR_MESSAGE);
                }

                else{

                    LoginController conn = new LoginController();
                    if(conn.login(username, password) == true){
                        HomeUI home = new HomeUI(LoginUI.this);
                        setVisible(false);
                    }

                    else{
                        
                        JOptionPane.showMessageDialog(LoginUI.this, "User not found. Please recheck login information entered.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }     

            }
            
        
            else if (e.getSource() == exit){
                System.exit(0);
                
            }

        }

    }

}
