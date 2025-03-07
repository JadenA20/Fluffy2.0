package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RegisterUI extends JFrame{
    private JButton register, cancel;
    private JPanel actionPanel, contentPanel;
    private JTextField username, password, confirm_pass;
    private JLabel user_type;
    private JComboBox<String> role;

    public RegisterUI(LoginUI login){
        setTitle("Register Baker");

        Font ver1 = new Font("Courier New", Font.BOLD, 30);
        Font ver2 = new Font("Courier New", Font.BOLD, 20);

        contentPanel.add(new JLabel("Username:"));
        username = new JTextField(40);
        contentPanel.add(username);

        contentPanel.add(new JLabel("Password:"));
        password = new JTextField(40);
        contentPanel.add(password);

        contentPanel.add(new JLabel("Confirm Password:"));
        confirm_pass = new JTextField(40);
        contentPanel.add(confirm_pass);

        cancel = new JButton("Exit");
        cancel.setBounds(170, 260, 100, 50);
        cancel.setBackground(new Color(100,67, 59));
        cancel.setForeground(new Color(255, 255, 255));
        cancel.setSize(new Dimension(100, 35));
        cancel.setFont(ver1);

        register = new JButton("Register Baker");
        register.setBounds(20, 370, 100, 50);
        register.setBackground(new Color(100,67, 59));
        register.setForeground(new Color(255, 255, 255));
        register.setSize(new Dimension(100, 35));
        register.setFont(ver1);

        setVisible(true);
    }

    private boolean passwordValid(String confirmedpass, String pass){ // Goes in register controller
        boolean validity = false;

        if (pass.equals(confirmedpass)){
            validity = true;
        }
        else{
            JOptionPane.showMessageDialog(RegisterUI.this, "Passwords do not match. Please re-enter the password", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return validity;
    }

    private class Register implements ActionListener{
        public void actionPerformed(ActionEvent e){}
    }

}
