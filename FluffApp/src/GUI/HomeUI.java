package GUI;

import java.awt.Dimension;

import javax.swing.JFrame;

public class HomeUI extends JFrame {
    public HomeUI(LoginUI login){
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /// CHANGE THIS 
        setSize(new Dimension(600, 400));
        
    }

}
