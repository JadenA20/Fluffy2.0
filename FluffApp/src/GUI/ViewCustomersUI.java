package GUI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.Comparator.CustomerIDSort;
import BusinessLogic.Comparator.FirstNameSort;
import BusinessLogic.Comparator.LastNameSort;
import BusinessLogic.Order.Customer;
import BusinessLogic.Order.Order;
import BusinessLogic.Order.OrderController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ViewCustomersUI extends JFrame {
    private JLabel title;
    private JButton sortByID, sortByFName, sortByLName, exit;
    private JScrollPane scrollPane;
    private JTable table;
    private HomeUI homeUI;

    public ViewCustomersUI(HomeUI homeUI){
        this.homeUI = homeUI;

        // Instantiate Elements
        title = new JLabel("Customers");
        title.setFont(new Font("Courier New", 1, 36)); 
        title.setForeground(new Color(100, 67, 59));

        sortByID = new JButton("Sort-By-ID");
        sortByID.setBackground(new Color(100, 67, 59));
        sortByID.setFont(new Font("Courier New", 1, 14)); 
        sortByID.setForeground(new Color(255, 255, 255));
        sortByID.addActionListener(new ButtonListener());

        sortByFName = new JButton("Sort-By-First-Name");
        sortByFName.setBackground(new Color(100, 67, 59));
        sortByFName.setFont(new Font("Courier New", 1, 13));
        sortByFName.setForeground(new Color(255, 255, 255));
        sortByFName.addActionListener(new ButtonListener());

        sortByLName = new JButton("Sort-By-Last-Name");
        sortByLName.setBackground(new Color(100, 67, 59));
        sortByLName.setFont(new Font("Courier New", 1, 14)); 
        sortByLName.setForeground(new Color(255, 255, 255));
        sortByLName.addActionListener(new ButtonListener());

        exit = new JButton("Exit");
        exit.setBackground(new Color(100, 67, 59));
        exit.setFont(new Font("Courier New", 1, 14)); 
        exit.setForeground(new Color(255, 255, 255));
        exit.addActionListener(new ButtonListener());

        scrollPane = new JScrollPane();

        table = new JTable();
        table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.lightGray, null, null));
        table.setFont(new Font("Courier New", 1, 12)); // NOI18N
        table.setForeground(new Color(100, 67, 59));
        table.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "Telephone", "Contact Method"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(230, 230, 230));
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        scrollPane.setViewportView(table);


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(sortByID)
                .addGap(42, 42, 42)
                .addComponent(sortByFName )
                .addGap(47, 47, 47)
                .addComponent(sortByLName)
                .addGap(61, 61, 61)
                .addComponent(exit, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(338, 338, 338))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 729, GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(title)
                .addGap(30, 30, 30)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sortByLName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortByFName, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortByID, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        addToTable();


        
        setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);










    
}

public void addToTable(){
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);
    ArrayList<Customer> customers = new ArrayList<Customer>();
    customers = new OrderController().viewCustomers();
    Object rowData[] = new Object[5];
    for(Customer c: customers){
            rowData[0] = c.getID();
            rowData[1] = c.getFname();
            rowData[2] = c.getLname();
            rowData[3] = c.getPhone();
            rowData[4] = c.getMethod();
            model.addRow(rowData);
        }

}


public void addToTable(ArrayList<Customer> sortedCustomers){
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);
    Object rowData[] = new Object[5];
    for(Customer c: sortedCustomers){
            rowData[0] = c.getID();
            rowData[1] = c.getFname();
            rowData[2] = c.getLname();
            rowData[3] = c.getPhone();
            rowData[4] = c.getMethod();
            model.addRow(rowData);
        }

    
}


private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == sortByID){
            ArrayList<Customer> customers = new ArrayList<Customer>();
            customers = new OrderController().viewCustomers();
            Collections.sort(customers, new CustomerIDSort());
            addToTable(customers);

        }

        if(e.getSource() == sortByFName){
            ArrayList<Customer> customers = new ArrayList<Customer>();
            customers = new OrderController().viewCustomers();
            Collections.sort(customers, new FirstNameSort());
            addToTable(customers);


        }


        if(e.getSource() == sortByLName){
            ArrayList<Customer> customers = new ArrayList<Customer>();
            customers = new OrderController().viewCustomers();
            Collections.sort(customers, new LastNameSort());
            addToTable(customers);


        }

        if(e.getSource() == exit){
            setVisible(false);
            homeUI.setVisible(true);

        }

    }
}
}
