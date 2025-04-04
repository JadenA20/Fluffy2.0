package GUI;

import Security.Authorization;
import Security.Baker;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class HomeUI extends JFrame {

    private JLabel title;
    private JButton register, orders, inventory, exit, customers;
    private JPanel jPanel;
    private HomeUI HomeUI;
    private LoginUI Login;


    public HomeUI(LoginUI LoginUI){

        this.HomeUI = this;
        this.Login = LoginUI;
        //LoginUI = LoginUI;
       
       //Set Panel Title
       
       setTitle("Home Screen");
        
       //Set Fonts
       Font ver1 = new Font("Courier New", Font.BOLD, 14);
       Font ver2 = new Font("Courier New", Font.BOLD, 34);
       Font ver3 = new Font("Bradley Hand ITC", Font.BOLD, 30);

        

        title = new JLabel("Welcome, " + LoginUI.getCurrentUser().getFName() + "!");                               
        title.setForeground(new Color(100, 67, 59));
        title.setFont(ver2);


        register = new JButton("Register Baker");
        register.setBackground(new Color(100,67, 59));
        register.setForeground(new Color(255, 255, 255));
        register.setFont(ver1);
        register.addActionListener(new ButtonListener());
        
        

        orders = new JButton("Orders");
        orders.setBackground(new Color(100,67, 59));
        orders.setForeground(new Color(255, 255, 255));
        orders.setFont(ver1);
        orders.setPreferredSize(new Dimension(106, 23));
        orders.addActionListener(new ButtonListener());
    
        customers = new JButton("Customers");
        customers.setBackground(new Color(100,67, 59));
        customers.setForeground(new Color(255, 255, 255));
        customers.setFont(ver1);
        customers.addActionListener(new ButtonListener());

        inventory = new JButton("Inventory");
        inventory.setBackground(new Color(100,67, 59));
        inventory.setForeground(new Color(255, 255, 255));
        inventory.setFont(new Font("Courier New", Font.BOLD, 10));
        inventory.addActionListener(new ButtonListener());
    
        exit = new JButton("Exit");
    
        exit.setBackground(new Color(100,67, 59));
        exit.setForeground(new Color(255, 255, 255));
        exit.setFont(ver1);
        exit.addActionListener(new ButtonListener());

        jPanel = new JPanel();
        GroupLayout jPanel1Layout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(register, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(orders, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(customers)
                .addGap(33, 33, 33)
                .addComponent(inventory, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(exit, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(title)
                .addGap(186, 186, 186)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(register, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addComponent(orders, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addComponent(customers, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventory, GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );


       
        
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));        
        
    }


    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
          
            if (e.getSource() == register){

              //Ensuring baker is authorized 
                Baker current_baker = Login.getCurrentUser();
                boolean authorized = new Authorization().authorizeBaker(current_baker);

                if (authorized == true){
                    setVisible(false);
                    RegisterUI registerUI = new RegisterUI(HomeUI.this, Login);
    
                }
                else {

                    JOptionPane.showMessageDialog(HomeUI.this, "You are not authorized to complete this task.");
                }
            
                
            }

            if(e.getSource() == orders){
                setVisible(false);
                ViewOrdersUI view = new ViewOrdersUI(HomeUI.this, Login);
                view.setVisible(true);
            }

            if(e.getSource() == customers){
                setVisible(false);
                ViewCustomersUI customersUI = new ViewCustomersUI(HomeUI);
                
            }

            if(e.getSource() == inventory){
                ViewInventoryUI inventoryUI = new ViewInventoryUI(HomeUI.this, Login);
                HomeUI.setVisible(false);
            }

            if(e.getSource() == exit){
                System.exit(0);
            }
        
        }

    }

}
