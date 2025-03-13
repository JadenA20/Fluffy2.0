package GUI;

import javax.swing.*;

import Security.OrderController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateOrderUI extends JFrame{
    private JButton addOrder, cancelOrder;
    private JPanel entryPanel, buttonPanel, mainPanel;
    private JLabel title;
    private JTextField fname, lname, phone, address, event, flavour;
    private JTextArea desc;
    private JComboBox<String> paystat;
    private String[] paymentStat= {"Pending","Deposited","Completed"};
    private Color bgColor = new Color(100, 67, 59);

    public CreateOrderUI(){

        Font ver1 = new Font("Courier New", Font.BOLD, 30);
        Font ver3 = new Font("Bradley Hand ITC", Font.BOLD, 30);

        setTitle("Create Order Form");
        mainPanel = new JPanel();
        entryPanel = new JPanel();
        buttonPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(3,1));
        entryPanel.setLayout(new GridLayout(5,3));
        buttonPanel.setLayout(new FlowLayout());


        title = new JLabel("ORDER CREATION FORM");
        title.setFont(ver3);
        title.setBounds(30, 50, 300, 50);
        title.setForeground(bgColor);

        fname = new JTextField("First Name:",50);
        fname.setFont(ver3);
        fname.setForeground(bgColor);
        entryPanel.add(fname);

        lname = new JTextField("Last Name:",50);
        lname.setFont(ver3);
        lname.setForeground(bgColor);
        entryPanel.add(lname);




        addOrder = new JButton("Add Order");
        addOrder.setBackground(bgColor);
        addOrder.setForeground(new Color(255,255,255,0));
        addOrder.setFont(ver1);

        cancelOrder = new JButton("Cancel");
        cancelOrder.setBackground(bgColor);
        cancelOrder.setForeground(new Color(255,255,255,0));
        cancelOrder.setFont(ver1);

        mainPanel.add(title);
        mainPanel.add(entryPanel);
        mainPanel.add(buttonPanel);

        buttonPanel.add(addOrder);
        buttonPanel.add(cancelOrder);

    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == addOrder){
                OrderController Controls = new OrderController();

            }

            else{
                setVisible(false);
            }
        }
    }

}