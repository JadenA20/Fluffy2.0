package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.Comparator.DeadlineSort;
import BusinessLogic.Comparator.OrderIDSort;
import BusinessLogic.Comparator.StatusSort;
import BusinessLogic.Order.Order;
import BusinessLogic.Order.OrderController;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Pattern;

public class ViewOrdersUI extends JFrame{

    private JLabel title, notes, description, orderID, deadline, price, paymentStatus, status, address;
    private JTextField iDField,  deadlineField, priceField;
    private JTextArea descArea, noteArea, addressArea;
    private JComboBox payBox, statusBox;
    private JScrollPane scrollPane1, scrollPane2, scrollPane3, scrollPane4;
    private JButton createOrder, editOrder, deleteOrder, sortByDeadline, search, sortByID, sortByStatus, viewCompleted, exit, submit;
    private JTable ordersTable;
    private JPanel panel;
    private HomeUI home;
    private LoginUI login;
    private ArrayList<Order> currentOrders;

    public ViewOrdersUI(HomeUI Home, LoginUI Login)
    {

        currentOrders = new OrderController().viewCurrentOrders();

        this.home = Home;
        this.login = Login;

        //Instantiate Labels
        title = new JLabel("Orders"); //JLabel 1
        title.setFont(new Font("Courier New", 1, 24)); // NOI18N
        title.setForeground(new Color(100, 67, 59));


        notes = new JLabel("Notes: "); //JLabel 2
        notes.setFont(new Font("Courier New", 1, 14)); // NOI18N
        notes.setForeground(new Color(100, 67, 59));


        description = new JLabel("Description"); //JLabel 3
        description.setFont(new Font("Courier New", 1, 14)); // NOI18N
        description.setForeground(new Color(100, 67, 59));
    

        orderID = new JLabel("Order ID: "); //JLabel 4
        orderID.setFont(new Font("Courier New", 1, 12)); // NOI18N
        orderID.setForeground(new Color(100, 67, 59));
        
        deadline = new JLabel("Deadline: "); //JLabel 5
        deadline.setFont(new Font("Courier New", 1, 14)); // NOI18N
        deadline.setForeground(new Color(100, 67, 59));

        address = new JLabel("Address");
        address.setFont(new Font("Courier New", 1, 14)); // NOI18N
        address.setForeground(new Color(100, 67, 59));

        
        price = new JLabel("Price: "); //JLabel 6
        price.setFont(new Font("Courier New", 1, 14)); // NOI18N
        price.setForeground(new Color(100, 67, 59));
    

        paymentStatus = new JLabel("Payment Status: "); //JLabel 7
        paymentStatus.setFont(new Font("Courier New", 1, 13)); // NOI18N
        paymentStatus.setForeground(new Color(100, 67, 59));
        paymentStatus.setPreferredSize(new Dimension(200, 30)); // Adjust width as needed

    

        status = new JLabel("Status: "); //JLabel 8
        status.setFont(new Font("Courier New", 1, 14)); // NOI18N
        status.setForeground(new Color(100, 67, 59));


        //Instantiate textfeilds
        iDField = new JTextField(10); //1
        deadlineField = new JTextField(10); //3
        priceField = new JTextField(10); //5

        //Instantiate TextArea
        descArea = new JTextArea(); //1
        descArea.setColumns(20);
        descArea.setForeground(new Color(100, 67, 59));
        descArea.setRows(5);

        noteArea = new JTextArea(); //2
        noteArea.setColumns(20);
        noteArea.setForeground(new Color(100, 67, 59));
        noteArea.setRows(5);

        addressArea =  new JTextArea();
        addressArea.setColumns(20);
        addressArea.setForeground(new Color(100, 67, 59));
        addressArea.setRows(5);


       

        //Instantiate ComboBox
        payBox = new JComboBox(); //1
        payBox.setForeground(new Color(100, 67, 59));
        payBox.setFont(new Font("Courier New", 1, 14));
        payBox.setModel(new DefaultComboBoxModel<>(new String[] { "Pending", "Deposited", "Completed"}));

        statusBox = new JComboBox<>(); //3
        statusBox.setForeground(new Color(100, 67, 59));
        statusBox.setFont(new Font("Courier New", 1, 14));
        statusBox.setModel(new DefaultComboBoxModel<>(new String[] { "Open", "Complete"}));


        //Instantiate scroll panel
        scrollPane1 = new JScrollPane(); //1
        scrollPane1.setViewportView(descArea);

        scrollPane2 = new JScrollPane(); //2
        scrollPane2.setViewportView(noteArea);

        scrollPane3 = new JScrollPane(); //3

        scrollPane4 = new JScrollPane();
        scrollPane4.setViewportView(addressArea);
       
        //Instantiate buttons
        createOrder = new JButton("Create Order"); //1
        createOrder.setBackground(new Color(100, 67, 59));
        createOrder.setFont(new Font("Courier New", 1, 14)); // NOI18N
        createOrder.setForeground(new Color(255, 255, 255));
        createOrder.addActionListener(new ButtonListener());
    

        editOrder = new JButton("Edit Order"); //2
        editOrder.setBackground(new Color(100, 67, 59));
        editOrder.setFont(new Font("Courier New", 1, 14)); // NOI18N
        editOrder.setForeground(new Color(255, 255, 255));
        editOrder.addActionListener(new ButtonListener());
        

        deleteOrder = new JButton("Cancel Order"); //3
        deleteOrder.setBackground(new Color(100, 67, 59));
        deleteOrder.setFont(new Font("Courier New", 1, 14)); // NOI18N
        deleteOrder.setForeground(new Color(255, 255, 255));
        deleteOrder.addActionListener(new ButtonListener());

        sortByDeadline = new JButton("Sort-by-Deadline"); //4
        sortByDeadline.setBackground(new Color(100, 67, 59));
        sortByDeadline.setFont(new Font("Courier New", 1, 12)); // NOI18N
        sortByDeadline.setForeground(new Color(255, 255, 255));
        sortByDeadline.addActionListener(new SortListener());
       

        search = new JButton("Search"); //5
        search.setBackground(new Color(100, 67, 59));
        search.setFont(new Font("Courier New", 1, 10)); // NOI18N
        search.setForeground(new Color(255, 255, 255));
        search.addActionListener(new ButtonListener());

        sortByID = new JButton("Sort-by-ID"); //6
        sortByID.setBackground(new Color(100, 67, 59));
        sortByID.setFont(new Font("Courier New", 1, 12)); // NOI18N
        sortByID.setForeground(new Color(255, 255, 255));
        sortByID.addActionListener(new SortListener());
       

        sortByStatus = new JButton("Sort-by-Status"); //7
        sortByStatus.setBackground(new Color(100, 67, 59));
        sortByStatus.setFont(new Font("Courier New", 1, 12)); // NOI18N
        sortByStatus.setForeground(new Color(255, 255, 255));
        sortByStatus.addActionListener(new SortListener());


        viewCompleted = new JButton("View Completed"); //8
        viewCompleted.setBackground(new Color(100, 67, 59));
        viewCompleted.setFont(new Font("Courier New", 1, 14)); // NOI18N
        viewCompleted.setForeground(new Color(255, 255, 255));
        viewCompleted.addActionListener(new ButtonListener());
        

        exit = new JButton("Exit"); //9
        exit.setBackground(new Color(100, 67, 59));
        exit.setFont(new Font("Courier New", 1, 14)); // NOI18N
        exit.setForeground(new Color(255, 255, 255));
        exit.addActionListener(new ButtonListener());

        submit = new JButton("Submit"); //10
        submit.setBackground(new Color(100, 67, 59));
        submit.setFont(new Font("Courier New", 1, 10)); // NOI18N
        submit.setForeground(new Color(255, 255, 255));
        submit.addActionListener(new ButtonListener());;
        
       

        //Instantiate table
        ordersTable = new JTable();

        ordersTable.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, Color.white, Color.black, Color.white, Color.white));
        ordersTable.setFont(new Font("Courier New", 1, 12)); // NOI18N
        ordersTable.setForeground(new Color(100, 67, 59));
        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
          },
            new String [] {
                "ID", "Customer", "Event", "Flavour", "Description", "Address", "Notes", "Price", "PayStat", "Deadline"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ordersTable.setFocusable(false);
        ordersTable.setGridColor(new Color(230, 230, 230));
        ordersTable.setShowGrid(true);
        scrollPane3.setViewportView(ordersTable);

        //Instantite panel
        panel = new JPanel();

        GroupLayout jPanel1Layout = new GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );


        // Set Layout
        GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 791, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(16, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(notes, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(description, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(price, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(deadline, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(address, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(title, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deadlineField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(orderID, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(iDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(search, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(status, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(statusBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(submit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(paymentStatus, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(payBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(createOrder, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(editOrder, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(deleteOrder, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(viewCompleted, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(sortByDeadline, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(sortByID, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(sortByStatus, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit)
                        .addGap(55, 55, 55))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(title)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(description)
                            .addComponent(price)
                            .addComponent(orderID))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(notes)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(priceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(deadline)
                                            .addComponent(status))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(deadlineField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(statusBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(submit)))
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(search)
                                        .addComponent(iDField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addComponent(address)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(paymentStatus)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(payBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(createOrder)
                            .addComponent(editOrder)
                            .addComponent(deleteOrder)
                            .addComponent(viewCompleted))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane3, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(sortByDeadline)
                            .addComponent(sortByID)
                            .addComponent(sortByStatus)
                            .addComponent(exit))
                        .addGap(73, 73, 73))
                );
        

        addToTable();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        //setSize(new Dimension(900, 900));
        pack();
        

        




    }

    public void addToTable(){
        DefaultTableModel model = (DefaultTableModel) ordersTable.getModel();
        model.setRowCount(0);
        ArrayList<Order> orders = new ArrayList<Order>();
        orders = new OrderController().viewCurrentOrders();
        Object rowData[] = new Object[10];
        for(Order o: orders){
            rowData[0] = o.getID();
            rowData[1] = o.getCustomer().getName();
            rowData[2] = o.getEvent();
            rowData[3] = o.getFlavour();
            rowData[4] = o.getDescription();
            rowData[5] = o.getDeliveryAddress();
            rowData[6] = o.getNotes();
            rowData[7] = o.getPrice();
            rowData[8] = o.getPayStat();
            rowData[9] = o.getDeadline();
            model.addRow(rowData);
        }

    }

    public void addToTable(ArrayList<Order> sortedOrders){
        DefaultTableModel model = (DefaultTableModel) ordersTable.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[10];
        for(Order o: sortedOrders){
            rowData[0] = o.getID();
            rowData[1] = o.getCustomer().getName();
            rowData[2] = o.getEvent();
            rowData[3] = o.getFlavour();
            rowData[4] = o.getDescription();
            rowData[5] = o.getDeliveryAddress();
            rowData[6] = o.getNotes();
            rowData[7] = o.getPrice();
            rowData[8] = o.getPayStat();
            rowData[9] = o.getDeadline();
            model.addRow(rowData);
        }

    }

    public Boolean isInteger(String str){
        if(str == null  || str.isEmpty()){
            return false;
        }

        try {
            Integer.parseInt(str);
            return true;
            
        } catch (Exception e) {
            return false;

            // TODO: handle exception
        }
    }

    private class  ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == createOrder){
                CreateOrderUI create = new CreateOrderUI(ViewOrdersUI.this);
                ViewOrdersUI.this.setVisible(false);

            }

            if(e.getSource() == search){
                Boolean exists = false;

               

                if(!(iDField.getText().isEmpty())){
                    String ID = iDField.getText().strip();

                    if(!isInteger(ID)){
                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error: ID Must Be An Integer.");
                        iDField.setText(" ");
                        priceField.setText(" ");
                        deadlineField.setText(" ");
                        descArea.setText(" ");
                        noteArea.setText(" ");
                        addressArea.setText(" ");
                        return;
                    }
                    Order order = new Order();
                    int iD = Integer.parseInt(iDField.getText().strip());

                    for(Order o: currentOrders){
                        if (o.getID() == iD){
                            order = o;
                            exists = true;
                        }
                        
                    }

                    if (exists == false){
                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;

                    }

                    // Add code to check if order exists

                    iDField.setText(String.valueOf(iD));
                    priceField.setText(String.valueOf(order.getPrice()));
                    deadlineField.setText(order.getDeadline());
                    descArea.setText(order.getDescription());
                    noteArea.setText(order.getNotes());
                    addressArea.setText(order.getDeliveryAddress());
                    payBox.setSelectedItem(order.getPayStat());
                    statusBox.setSelectedItem("Open");
                    

                }

                else{
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Please enter an ID", "Error", JOptionPane.ERROR_MESSAGE);
                        iDField.setText(" ");
                        priceField.setText(" ");
                        deadlineField.setText(" ");
                        descArea.setText(" ");
                        noteArea.setText(" ");
                        addressArea.setText(" ");
                }

            }

            if(e.getSource() == editOrder){

                Boolean exists = false;

                if(iDField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error, no Order selected.");
                     iDField.setText(" ");
                        priceField.setText(" ");
                        deadlineField.setText(" ");
                        descArea.setText(" ");
                        noteArea.setText(" ");
                        addressArea.setText(" ");
                    return;
                }

                String ID = iDField.getText().strip();
                if(!isInteger(ID)){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error: ID Must Be An Integer.");
                        iDField.setText(" ");
                        priceField.setText(" ");
                        deadlineField.setText(" ");
                        descArea.setText(" ");
                        noteArea.setText(" ");
                        addressArea.setText(" ");
                    return;
                }

                else{
                    int iD = Integer.parseInt(iDField.getText().strip());
                    for(Order o: currentOrders)
                    {
                        if(o.getID() == iD){
                            exists = true;       
                        }

                    }

                    if(exists == true){

                        String reg = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";

                        String description = descArea.getText();
                        String notes = noteArea.getText();
                        String payStatus = String.valueOf(payBox.getSelectedItem());
                        String deadline = deadlineField.getText();
                        String address = addressArea.getText();
                        float price = Float.parseFloat(priceField.getText());

                        if(!(Pattern.matches(reg, deadline))){
                            JOptionPane.showMessageDialog(ViewOrdersUI.this, "Not a valid date", "Error", JOptionPane.ERROR_MESSAGE);

                        }

                        int response = JOptionPane.showConfirmDialog(ViewOrdersUI.this, "Save new details?");

                        if(response == JOptionPane.YES_OPTION){
                            OrderController conn = new OrderController();
                            Boolean success = conn.editOrder(description, notes, payStatus, address, price, deadline, iD);

                            if(success == true){
                                addToTable();
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Update Successful");
                                iDField.setText(" ");
                                priceField.setText(" ");
                                deadlineField.setText(" ");
                                descArea.setText(" ");
                                noteArea.setText(" ");
                                addressArea.setText(" ");
                            }

                            else{
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Update failed");
                                iDField.setText(" ");
                                priceField.setText(" ");
                                deadlineField.setText(" ");
                                descArea.setText(" ");
                                noteArea.setText(" ");
                                addressArea.setText(" ");
                            }
                         }

                        else{
                    
                            iDField.setText(" ");
                            priceField.setText(" ");
                            deadlineField.setText(" ");
                            descArea.setText(" ");
                            noteArea.setText(" ");
                            addressArea.setText(" ");
                        }

                    }

                    else{

                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order does not exist.", "Error", JOptionPane.ERROR_MESSAGE);

                    }


                }


                
                


            }

            if(e.getSource() == submit){

                Boolean exists = false;
                Boolean success = false;

               

                if(iDField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error, no Order selected.");
                        iDField.setText(" ");
                        priceField.setText(" ");
                        deadlineField.setText(" ");
                        descArea.setText(" ");
                        noteArea.setText(" ");
                        addressArea.setText(" ");
                    return;
                }

                String ID = iDField.getText().strip();
                if(!isInteger(ID)){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error: ID Must Be An Integer.");
                        iDField.setText(" ");
                        priceField.setText(" ");
                        deadlineField.setText(" ");
                        descArea.setText(" ");
                        noteArea.setText(" ");
                        addressArea.setText(" ");
                    return;
                }

                else{
                    int iD = Integer.parseInt(iDField.getText().strip());
                    for(Order o: currentOrders)
                    {
                        if(o.getID() == iD){
                            exists = true;       
                        }
                    }

                    if((exists == true) && (String.valueOf(statusBox.getSelectedItem()).equals("Complete"))){
                        int response = JOptionPane.showConfirmDialog(ViewOrdersUI.this, "Complete Order?");

                        if(response == JOptionPane.YES_OPTION){
                            OrderController conn = new OrderController();
                            success = conn.completeOrder(iD);

                            if(success == true){
                                addToTable();                                
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order Completed");
                                iDField.setText(" ");
                                priceField.setText(" ");
                                deadlineField.setText(" ");
                                descArea.setText(" ");
                                noteArea.setText(" ");
                                addressArea.setText(" ");
                            }

                            else{
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error: Order not Completed");
                            }

                        }

                        else
                        {
                            iDField.setText(" ");
                            priceField.setText(" ");
                            deadlineField.setText(" ");
                            descArea.setText(" ");
                            noteArea.setText(" ");
                            addressArea.setText(" ");
                        }


                    }

                    else if(String.valueOf(statusBox.getSelectedItem()).equals("Open")){
                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "To complete this order, please select the correct status option.");

                    }

                    else{

                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order does not exist");
                        System.out.println(String.valueOf(statusBox.getSelectedItem()));

                    }




            }

            
           
        }

        if(e.getSource() == deleteOrder){
            Boolean exists = false;
            Boolean success = false;
            

                if(iDField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error, No Order Selected.");
                        iDField.setText(" ");
                        priceField.setText(" ");
                        deadlineField.setText(" ");
                        descArea.setText(" ");
                        noteArea.setText(" ");
                        addressArea.setText(" ");
                    return;
                }

                String ID = iDField.getText().strip();
                if(!isInteger(ID)){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error: ID Must Be An Integer.");
                        iDField.setText(" ");
                        priceField.setText(" ");
                        deadlineField.setText(" ");
                        descArea.setText(" ");
                        noteArea.setText(" ");
                        addressArea.setText(" ");
                    return;
                }

                else{
                    int iD = Integer.parseInt(iDField.getText().strip());
                    for(Order o: currentOrders)
                    {
                        if(o.getID() == iD){
                            exists = true;       
                        }
                    }

                    if(exists == true){
                        int response = JOptionPane.showConfirmDialog(ViewOrdersUI.this, "Cancel Order?");

                        if(response == JOptionPane.YES_OPTION){
                            success = new OrderController().cancelOrder(iD);
                            if(success == true){
                                addToTable();
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order Cancelled.");
                                iDField.setText(" ");
                                priceField.setText(" ");
                                deadlineField.setText(" ");
                                descArea.setText(" ");
                                noteArea.setText(" ");
                                addressArea.setText(" ");

                            }
                        }

                        else{
                            iDField.setText(" ");
                            priceField.setText(" ");
                            deadlineField.setText(" ");
                            descArea.setText(" ");
                            noteArea.setText(" ");
                            addressArea.setText(" ");
                        }

                    }

                    else{

                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error, Order Does Not Exist.");
                        iDField.setText(" ");
                        priceField.setText(" ");
                        deadlineField.setText(" ");
                        descArea.setText(" ");
                        noteArea.setText(" ");
                        addressArea.setText(" ");
                        

                    }

                }


                

        }

        if(e.getSource() == viewCompleted){
            setVisible(false);
            ViewCompleteOrdersUI viewComp = new ViewCompleteOrdersUI(ViewOrdersUI.this);


        }

        if(e.getSource() == exit){
            ViewOrdersUI.this.setVisible(false);
            home.setVisible(true);

        }

    }


    

}

private class SortListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == sortByDeadline){
            ArrayList<Order> orders = new ArrayList<Order>();
            orders = new OrderController().viewCurrentOrders();
            Collections.sort(orders, new DeadlineSort());
            addToTable(orders);


        }

        if(e.getSource() == sortByID){
            ArrayList<Order> orders = new ArrayList<Order>();
            orders = new OrderController().viewCurrentOrders();
            Collections.sort(orders, new OrderIDSort());
            addToTable(orders);

        }

        if(e.getSource() == sortByStatus){
            ArrayList<Order> orders = new ArrayList<Order>();
            orders = new OrderController().viewCurrentOrders();
            Collections.sort(orders, new StatusSort());
            addToTable(orders);

        }
    }
}

}
