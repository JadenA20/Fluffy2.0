package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class HomeUI extends JFrame {

    private JLabel title, registerLabel;
    private JButton register;
    private JPanel mainPanel, displayPanel;
    private HomeUI HomeUI;
    private LoginUI login;

    public HomeUI(LoginUI LoginUI){

        this.HomeUI = this;
        login = LoginUI;
       
       //Set Panel Title
       setTitle("Home Screen");
        
       //Set Fonts
       Font ver1 = new Font("Courier New", Font.BOLD, 30);
       Font ver3 = new Font("Bradley Hand ITC", Font.BOLD, 30);

        //Creation of Panels
        mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255,255, 255, 180));
        mainPanel.setBounds(0, 0, 600, 100);
        mainPanel.setLayout(new BoxLayout(mainPanel, 1));


        displayPanel = new JPanel();
        displayPanel.setBackground(new Color(255,255, 255, 180));
        displayPanel.setBounds(0, 0, 600, 100);
        

        title = new JLabel("HOME SCREEN");                               
        title.setForeground(new Color(100, 67, 59));
        title.setFont(ver3);
        title.setBounds(30, 50, 300, 50);
        mainPanel.add(title);
       

        //Registration Label and Button
        registerLabel = new JLabel("Register a New Baker here!");
        registerLabel.setForeground(new Color(100, 67, 59));
        registerLabel.setFont(ver1);
        registerLabel.setBounds(20, 330, 300, 50);
        displayPanel.add(registerLabel);


        register = new JButton("Register Baker");
        register.setBounds(20, 370, 100, 50);
        register.setBackground(new Color(100,67, 59));
        register.setForeground(new Color(255, 255, 255));
        register.setSize(new Dimension(100, 35));
        register.setFont(ver1);
        displayPanel.add(register);
       
       
        add(mainPanel);
        mainPanel.add(displayPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /// CHANGE THIS 
        setSize(new Dimension(600, 400));

        register.addActionListener(new ButtonListener());
        
    }

    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
          
            if (e.getSource() == register){

              //Need to check baker account type first
            

                setVisible(false);
                RegisterUI registerUI = new RegisterUI(HomeUI.this, login);
    
            }
        
        }

    }

}
