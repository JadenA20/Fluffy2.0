package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Security.*;


public class LoginUI extends JFrame {

    private JButton login, exit, register;
    private JLabel title, usernameLabel, passwordLabel, registerLabel;
    private JTextField usernameField;
    private JPasswordField pwordField;
    private JPanel mainPanel, optionPanel;

    public LoginUI() {

        //Setting a title for the pop-up screen
        setTitle("Login Screen");

        //Fonts
        Font ver1 = new Font("Courier New", Font.BOLD, 30);
        Font ver2 = new Font("Courier New", Font.BOLD, 20);


        //Instantiation of Labels
        title = new JLabel("FLUFFY'S SWEET TREATS");
        title.setForeground(new Color(100, 67, 59));
        title.setFont(ver1);
        title.setBounds(100, 50, 300, 50);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(new Color(100, 67, 59));
        usernameLabel.setFont(ver1);
        usernameLabel.setBounds(20, 100, 300, 50);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(100, 67, 59));
        passwordLabel.setFont(ver1);
        passwordLabel.setBounds(20, 170, 300, 50);

        registerLabel = new JLabel("Register a New Baker here!");
        registerLabel.setForeground(new Color(100, 67, 59));
        registerLabel.setFont(ver2);
        registerLabel.setBounds(20, 330, 300, 50);



        //Instantiation of Buttons
        login = new JButton("Login");
        login.setBounds(20, 260, 100, 50);
        login.setBackground(new Color(100,67, 59));
        login.setForeground(new Color(255, 255, 255));
        login.setSize(new Dimension(100, 35));
        login.setFont(ver1);

        exit = new JButton("Exit");
        exit.setBounds(170, 260, 100, 50);
        exit.setBackground(new Color(100,67, 59));
        exit.setForeground(new Color(255, 255, 255));
        exit.setSize(new Dimension(100, 35));
        exit.setFont(ver1);

        register = new JButton("Register Baker");
        register.setBounds(20, 370, 100, 50);
        register.setBackground(new Color(100,67, 59));
        register.setForeground(new Color(255, 255, 255));
        register.setSize(new Dimension(100, 35));
        register.setFont(ver1);


        //Instantiation of TextField
        usernameField = new JTextField(20);
        usernameField.setBounds(20, 140, 200, 30);
        usernameField.setBackground(new Color(244, 235, 220));

        //Instantiation of PasswordField

        pwordField = new JPasswordField(20);
        pwordField.setBounds(20, 210, 200, 30);
        pwordField.setBackground(new Color(244, 235, 220));
        pwordField.setEchoChar('*');
        
       
        


        //Instantiation of Panels
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255,255, 255, 180));
        mainPanel.setBounds(0, 0, 500, 60);
        mainPanel.add(title);


        optionPanel = new JPanel();
        optionPanel.setSize(200, 250);
        optionPanel.setBackground(new Color(255, 255, 255, 180));
        optionPanel.setBounds(100, 85, 300, 370);
        optionPanel.setLayout(null);

        //Add to Option Panel
        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(pwordField);
        mainPanel.add(registerLabel);
        mainPanel.add(login);
        mainPanel.add(register);
        mainPanel.add(exit);


        //Action Listeners 
        login.addActionListener(new ButtonListener());
        
       // Create Screen
       mainPanel.add(optionPanel);
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
                String password = new String(pwordField.getPassword());

                if((username.equals("")) || (password.equals(""))){
                    /// Error message
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
            
            else if(e.getSource() == register){
                new RegisterUI(LoginUI.this);
                
            }

                    }
    }


}
