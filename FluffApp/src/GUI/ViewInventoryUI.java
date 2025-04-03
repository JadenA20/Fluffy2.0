package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.Comparator.InventoryIDSort;
import BusinessLogic.Comparator.InventoryStatusSort;
import BusinessLogic.Comparator.InventoryTypeSort;
import BusinessLogic.Comparator.QuantitySort;
import BusinessLogic.Inventory.*;
import BusinessLogic.Order.Order;
import BusinessLogic.Order.OrderController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ViewInventoryUI extends JFrame {
    private JLabel title, iD, name, desc, type, priority, quantity;
    private JTextField idField, itemField, quantityField, descField; 
    private JButton search, create, edit, delete, sortByID, sortByPriority, sortByStatus, sortByQuantity, exit;
    private JComboBox statusBox, typeBox;
    private JTable table;
    private JPanel panel;
    private JScrollPane scrollPane;
    private HomeUI homeUI;


    public ViewInventoryUI(HomeUI homeUI){

        this.homeUI = homeUI;

        // Instantiate JLabels

        title = new JLabel("Inventory");
        title.setFont(new Font("Courier New", 1, 36)); 
        title.setForeground(new Color(100, 67, 59));

        iD = new JLabel("ID: ");
        iD.setFont(new Font("Courier New", 1, 14)); // NOI18N
        iD.setForeground(new Color(100, 67, 59));
    
        priority = new JLabel("Priority");
        priority.setFont(new Font("Courier New", 1, 14)); // NOI18N
        priority.setForeground(new Color(100, 67, 59));

        type = new JLabel("Type: ");
        type.setFont(new Font("Courier New", 1, 14)); // NOI18N
        type.setForeground(new Color(100, 67, 59));

        quantity = new JLabel("Quantity");
        quantity.setFont(new Font("Courier New", 1, 14)); // NOI18N
        quantity.setForeground(new Color(100, 67, 59));
        
        name = new JLabel("Item");
        name.setFont(new Font("Courier New", 1, 14)); // NOI18N
        name.setForeground(new Color(100, 67, 59));

        desc = new JLabel("Description");
        desc.setFont(new Font("Courier New", 1, 14)); // NOI18N
        desc.setForeground(new Color(100, 67, 59));

        // Instantiate JButtons
        
        search = new JButton("Search");
        search.setBackground(new java.awt.Color(100, 67, 59));
        search.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        search.setForeground(new java.awt.Color(255, 255, 255));
        search.addActionListener(new ButtonListener());
        
        create = new JButton("New Item");
        create.setBackground(new Color(100, 67, 59));
        create.setFont(new Font("Courier New", 1, 14)); // NOI18N
        create.setForeground(new Color(255, 255, 255));
        create.addActionListener(new ButtonListener());
        
        edit = new JButton("Edit Item");
        edit.setBackground(new Color(100, 67, 59));
        edit.setFont(new Font("Courier New", 1, 14)); // NOI18N
        edit.setForeground(new Color(255, 255, 255));
        edit.addActionListener(new ButtonListener());
       
        delete = new JButton("Delete Item");
        delete.setBackground(new Color(100, 67, 59));
        delete.setFont(new Font("Courier New", 1, 14)); // NOI18N
        delete.setForeground(new Color(255, 255, 255));
        delete.addActionListener(new ButtonListener());
       

        sortByID = new JButton("Sort-By-ID");
        sortByID.setBackground(new Color(100, 67, 59));
        sortByID.setFont(new Font("Courier New", 1, 14)); // NOI18N
        sortByID.setForeground(new Color(255, 255, 255));
        sortByID.addActionListener(new SortListener());


        sortByPriority = new JButton("Sort-By-Priority");
        sortByPriority.setBackground(new Color(100, 67, 59));
        sortByPriority.setFont(new Font("Courier New", 1, 14)); // NOI18N
        sortByPriority.setForeground(new Color(255, 255, 255));
        sortByPriority.addActionListener(new SortListener());
        

        sortByStatus = new JButton("Sort-By-Status");
        sortByStatus.setBackground(new Color(100, 67, 59));
        sortByStatus.setFont(new Font("Courier New", 1, 14)); // NOI18N
        sortByStatus.setForeground(new Color(255, 255, 255));
        sortByStatus.addActionListener(new SortListener());
        
        sortByQuantity = new JButton("Sort-By-Quantity");
        sortByQuantity.setBackground(new Color(100, 67, 59));
        sortByQuantity.setFont(new Font("Courier New", 1, 14)); // NOI18N
        sortByQuantity.setForeground(new Color(255, 255, 255));
        sortByQuantity.addActionListener(new SortListener());
       
        

        exit = new JButton("Exit");
        exit.setBackground(new Color(100, 67, 59));
        exit.setFont(new Font("Courier New", 1, 14)); // NOI18N
        exit.setForeground(new Color(255, 255, 255));
        exit.addActionListener(new ButtonListener());
       

       

        // Set JComboBox
        statusBox = new JComboBox<String>();
        statusBox.setFont(new Font("Courier New", 1, 14)); // NOI18N
        statusBox.setForeground(new Color(100, 67, 59));
        statusBox.setModel(new DefaultComboBoxModel<>(new String[] {"Low-Priority", "Medium-Priority", "High-Priority"}));

        
        typeBox = new JComboBox<String>();
        typeBox.setFont(new Font("Courier New", 1, 14)); // NOI18N
        typeBox.setForeground(new Color(100, 67, 59));
        typeBox.setModel(new DefaultComboBoxModel<>(new String[] { "Perishable", "Non-Perishable"}));

        //Instantiate TextFields        
        quantityField = new JTextField();
        quantityField.setFont(new Font("Courier New", 0, 14)); // NOI18N
        quantityField.setForeground(new Color(100, 67, 59));
        
        idField = new JTextField();
        idField.setFont(new Font("Courier New", 0, 14)); // NOI18N
        idField.setForeground(new Color(100, 67, 59));
        
        

        itemField = new JTextField();
        itemField.setFont(new Font("Courier New", 0, 14)); // NOI18N
        itemField.setForeground(new Color(100, 67, 59));

       
        descField = new JTextField();
        descField.setFont(new Font("Courier New", 0, 14)); // NOI18N
        descField.setForeground(new Color(100, 67, 59));

        panel = new JPanel();
        table = new JTable();
        scrollPane = new JScrollPane();


        GroupLayout jPanel1Layout = new GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        table.setFont(new Font("Courier New", 1, 12)); // NOI18N
        table.setForeground(new Color(100, 67, 59));
        table.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Item", "Description", "Type", "Status", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setShowGrid(true);
        scrollPane.setViewportView(table);


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(title, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(iD, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(idField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(search, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230)
                .addComponent(priority, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(statusBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(itemField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                    .addComponent(name, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
                .addGap(220, 220, 220)
                .addComponent(type, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(typeBox, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(descField, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                    .addComponent(desc))
                .addGap(210, 210, 210)
                .addComponent(quantity, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(quantityField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(create)
                .addGap(172, 172, 172)
                .addComponent(edit)
                .addGap(183, 183, 183)
                .addComponent(delete))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 850, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(sortByID)
                .addGap(45, 45, 45)
                .addComponent(sortByPriority)
                .addGap(44, 44, 44)
                .addComponent(sortByStatus)
                .addGap(41, 41, 41)
                .addComponent(sortByQuantity)
                .addGap(34, 34, 34)
                .addComponent(exit))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(title)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(priority)
                    .addComponent(statusBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(iD, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                            .addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(search))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(itemField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(name)))
                    .addComponent(type)
                    .addComponent(typeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(descField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(desc)
                    .addComponent(quantity)
                    .addComponent(quantityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(create)
                    .addComponent(edit)
                    .addComponent(delete))
                .addGap(16, 16, 16)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sortByID)
                    .addComponent(sortByPriority)
                    .addComponent(sortByStatus)
                    .addComponent(sortByQuantity)
                    .addComponent(exit))
                .addGap(16, 16, 16)
                .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        addToTable();

        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }


    public void addToTable(){

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<Inventory> itemList = new ArrayList<Inventory>();
        itemList = new InventoryController().viewRecords();
        Object rowData[] = new Object[10];
        for(Inventory i: itemList){
            rowData[0] = i.getID();
            rowData[1] = i.getName();
            rowData[2] = i.getDesc();
            rowData[3] = i.getType();
            rowData[4] = i.getStatus();
            rowData[5] = i.getQuantity();
            model.addRow(rowData);
        }

    }

    public void addToTable(ArrayList<Inventory> itemList){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[10];
        for(Inventory i: itemList){
            rowData[0] = i.getID();
            rowData[1] = i.getName();
            rowData[2] = i.getDesc();
            rowData[3] = i.getType();
            rowData[4] = i.getStatus();
            rowData[5] = i.getQuantity();
            model.addRow(rowData);
        }
        
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == create){
                
            }

            if(e.getSource() == edit){
                
            }


            if(e.getSource() == delete){
                
            }

            if(e.getSource() == search){
                ArrayList<Inventory> itemList = new ArrayList<Inventory>();
                itemList = new InventoryController().viewRecords();
                Inventory i  = new Inventory();
                Boolean exists = false;

                if(idField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ViewInventoryUI.this,"Please enter an ID number" );

                }

                else{
                    int iD = Integer.parseInt(idField.getText());
                    for(Inventory inventory: itemList){
                        if(inventory.getID() == iD){
                            i = inventory;
                            exists = true;
                        }

                    }

                    if(exists){
                        itemField.setText(i.getName());
                        descField.setText(i.getDesc());
                        quantityField.setText(String.valueOf(i.getQuantity()));
                        typeBox.setSelectedItem(i.getType());
                        statusBox.setSelectedItem(i.getStatus());



                        
                    }

                    else{

                        JOptionPane.showMessageDialog(ViewInventoryUI.this,"Order Does Not Exist" );

                    }
                    

                }

                
                
    

                
            }

            if(e.getSource() == exit){
                setVisible(false);
                homeUI.setVisible(true);
                
            }
        }
    
        
    }
    
    private class SortListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == sortByID){
                ArrayList<Inventory> itemList = new ArrayList<Inventory>();
                itemList = new InventoryController().viewRecords();
                Collections.sort(itemList, new InventoryIDSort());
                addToTable(itemList);

            }

            if(e.getSource() == sortByPriority){
                ArrayList<Inventory> itemList = new ArrayList<Inventory>();
                itemList = new InventoryController().viewRecords();
                Collections.sort(itemList, new InventoryTypeSort());
                addToTable(itemList);


            }

            if(e.getSource() == sortByStatus){
                ArrayList<Inventory> itemList = new ArrayList<Inventory>();
                itemList = new InventoryController().viewRecords();
                Collections.sort(itemList, new InventoryStatusSort());
                addToTable(itemList);



            }

            if(e.getSource() == sortByQuantity){
                ArrayList<Inventory> itemList = new ArrayList<Inventory>();
                itemList = new InventoryController().viewRecords();
                Collections.sort(itemList, new QuantitySort());
                addToTable(itemList);



            }
        }

       
    }





}
