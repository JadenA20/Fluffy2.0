package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.Order.Order;
import BusinessLogic.Order.OrderController;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ViewOrdersUI extends JFrame{

    private JLabel title, notes, description, orderID, deadline, price, paymentStatus, status;
    private JTextField iDfield,  deadlineField, priceField;
    private JTextArea descArea, noteArea;
    private JComboBox payBox, statusBox;
    private JScrollPane scrollPane1, scrollPane2, scrollPane3;
    private JButton createOrder, editOrder, deleteOrder, sortByDeadline, search, sortByID, sortByStatus, viewCompleted, exit, sumbit;
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
        orderID.setFont(new Font("Courier New", 1, 14)); // NOI18N
        orderID.setForeground(new Color(100, 67, 59));
        
        deadline = new JLabel("Deadline: "); //JLabel 5
        deadline.setFont(new Font("Courier New", 1, 14)); // NOI18N
        deadline.setForeground(new Color(100, 67, 59));
        
        price = new JLabel("Price: "); //JLabel 6
        price.setFont(new Font("Courier New", 1, 14)); // NOI18N
        price.setForeground(new Color(100, 67, 59));
    

        paymentStatus = new JLabel("Payment Status: "); //JLabel 7
        paymentStatus.setFont(new Font("Courier New", 1, 14)); // NOI18N
        paymentStatus.setForeground(new Color(100, 67, 59));
        paymentStatus.setPreferredSize(new Dimension(200, 30)); // Adjust width as needed

    

        status = new JLabel("Status: "); //JLabel 8
        status.setFont(new Font("Courier New", 1, 14)); // NOI18N
        status.setForeground(new Color(100, 67, 59));


        //Instantiate textfeilds
        iDfield = new JTextField(10); //1
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
       

        //Instantiate ComboBox
        payBox = new JComboBox(); //1
        payBox.setForeground(new Color(100, 67, 59));
        payBox.setFont(new Font("Courier New", 1, 14));
        payBox.setModel(new DefaultComboBoxModel<>(new String[] { "Pending", "Deposit", "Complete"}));

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
        

        deleteOrder = new JButton("Delete Order"); //3
        deleteOrder.setBackground(new Color(100, 67, 59));
        deleteOrder.setFont(new Font("Courier New", 1, 14)); // NOI18N
        deleteOrder.setForeground(new Color(255, 255, 255));
        deleteOrder.addActionListener(new ButtonListener());

        sortByDeadline = new JButton("Sort-by-Deadline"); //4
        sortByDeadline.setBackground(new Color(100, 67, 59));
        sortByDeadline.setFont(new Font("Courier New", 1, 14)); // NOI18N
        sortByDeadline.setForeground(new Color(255, 255, 255));
       

        search = new JButton("Search"); //5
        search.setBackground(new Color(100, 67, 59));
        search.setFont(new Font("Courier New", 1, 10)); // NOI18N
        search.setForeground(new Color(255, 255, 255));
        search.addActionListener(new ButtonListener());

        sortByID = new JButton("Sort-by-ID"); //6
        sortByID.setBackground(new Color(100, 67, 59));
        sortByID.setFont(new Font("Courier New", 1, 14)); // NOI18N
        sortByID.setForeground(new Color(255, 255, 255));
       

        sortByStatus = new JButton("Sort-by-Status"); //7
        sortByStatus.setBackground(new Color(100, 67, 59));
        sortByStatus.setFont(new Font("Courier New", 1, 14)); // NOI18N
        sortByStatus.setForeground(new Color(255, 255, 255));


        viewCompleted = new JButton("View Completed"); //8
        viewCompleted.setBackground(new Color(100, 67, 59));
        viewCompleted.setFont(new Font("Courier New", 1, 14)); // NOI18N
        viewCompleted.setForeground(new Color(255, 255, 255));
        

        exit = new JButton("Exit"); //9
        exit.setBackground(new Color(100, 67, 59));
        exit.setFont(new Font("Courier New", 1, 14)); // NOI18N
        exit.setForeground(new Color(255, 255, 255));
        exit.addActionListener(new ButtonListener());

        sumbit = new JButton("Submit"); //10
        sumbit.setBackground(new Color(100, 67, 59));
        sumbit.setFont(new Font("Courier New", 1, 10)); // NOI18N
        sumbit.setForeground(new Color(255, 255, 255));
        sumbit.addActionListener(new ButtonListener());;
        
       

        //Instantiate table
        ordersTable = new JTable();

        ordersTable.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, Color.white, Color.black, Color.white, Color.white));
        ordersTable.setFont(new Font("Courier New", 1, 12)); // NOI18N
        ordersTable.setForeground(new Color(100, 67, 59));
        ordersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
          },
            new String [] {
                "ID", "Customer", "Event", "Flavour", "Description", "Notes", "Price", "PayStat", "Deadline"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(notes, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(createOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(payBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(orderID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(5, 5, 5)
                                                        .addComponent(iDfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(25, 25, 25))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(deadlineField, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(paymentStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(priceField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(deadline, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(130, 130, 130)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(sumbit, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(editOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                        .addComponent(deleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)
                                        .addComponent(viewCompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(sortByDeadline)
                        .addGap(58, 58, 58)
                        .addComponent(sortByID, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(sortByStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit)
                        .addGap(65, 65, 65))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(title).addGap(34, 34, 34).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(description).addComponent(paymentStatus)).addGap(4, 4, 4).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(orderID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(search)
                                    .addComponent(iDfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(payBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(price)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(status)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(statusBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sumbit))))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deadline)
                    .addComponent(notes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deadlineField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createOrder)
                    .addComponent(editOrder)
                    .addComponent(deleteOrder)
                    .addComponent(viewCompleted))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortByDeadline)
                    .addComponent(sortByID)
                    .addComponent(sortByStatus)
                    .addComponent(exit))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        addToTable();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new Dimension(550, 400));
        pack();
        

        




    }

    public void addToTable(){
        DefaultTableModel model = (DefaultTableModel) ordersTable.getModel();
        model.setRowCount(0);
        ArrayList<Order> orders = new ArrayList<Order>();
        orders = new OrderController().viewCurrentOrders();
        Object rowData[] = new Object[9];
        for(Order o: orders){
            rowData[0] = o.getID();
            rowData[1] = o.getCustomer().getName();
            rowData[2] = o.getEvent();
            rowData[3] = o.getFlavour();
            rowData[4] = o.getDescription();
            rowData[5] = o.getNotes();
            rowData[6] = o.getPrice();
            rowData[7] = o.getPayStat();
            rowData[8] = o.getDeadline();
            model.addRow(rowData);
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
                if(!(iDfield.getText().isEmpty())){
                    Order order = new Order();
                    int iD = Integer.parseInt(iDfield.getText());

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

                    iDfield.setText(String.valueOf(iD));
                    priceField.setText(String.valueOf(order.getPrice()));
                    deadlineField.setText(order.getDeadline());
                    descArea.setText(order.getDescription());
                    noteArea.setText(order.getNotes());
                    
                    if(order.getPayStat().equals("Pending")){
                        payBox.setSelectedItem("Pending");
                    }

                    if(order.getPayStat().equals("Deposited")){
                        payBox.setSelectedItem("Deposit");
                    }

                    if(order.getPayStat().equals("Completed")){
                        payBox.setSelectedItem("Complete");
                    }

                    statusBox.setSelectedItem("Open");



                }

                else{
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Please enter an ID", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

            if(e.getSource() == editOrder){

                Boolean exists = false;

                if(iDfield.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error, no Order selected.");
                }

                else{
                    int iD = Integer.parseInt(iDfield.getText());
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
                        float price = Float.parseFloat(priceField.getText());

                        if(!(Pattern.matches(reg, deadline))){
                            JOptionPane.showMessageDialog(ViewOrdersUI.this, "Not a valid date", "Error", JOptionPane.ERROR_MESSAGE);

                        }

                        int response = JOptionPane.showConfirmDialog(ViewOrdersUI.this, "Save new details?");

                        if(response == JOptionPane.YES_OPTION){
                            OrderController conn = new OrderController();
                            Boolean success = conn.editOrder(description, notes, payStatus,price, deadline, iD);

                            if(success == true){
                                addToTable();
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Update Successful");
                                iDfield.setText(" ");
                                priceField.setText(" ");
                                deadlineField.setText(" ");
                                descArea.setText(" ");
                                noteArea.setText(" ");
                            }

                            else{
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Update failed");
                                iDfield.setText(" ");
                                priceField.setText(" ");
                                deadlineField.setText(" ");
                                descArea.setText(" ");
                                noteArea.setText(" ");
                            }
                         }

                        else{
                    
                            iDfield.setText(" ");
                            priceField.setText(" ");
                            deadlineField.setText(" ");
                            descArea.setText(" ");
                            noteArea.setText(" ");
                        }

                    }

                    else{

                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order does not exist.", "Error", JOptionPane.ERROR_MESSAGE);

                    }


                }


                
                


            }

            if(e.getSource() == sumbit){

                Boolean exists = false;
                Boolean success = false;

                if(iDfield.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error, no Order selected.");
                }

                else{
                    int iD = Integer.parseInt(iDfield.getText());
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
                                iDfield.setText(" ");
                                priceField.setText(" ");
                                deadlineField.setText(" ");
                                descArea.setText(" ");
                                noteArea.setText(" ");
                            }

                            else{
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error: Order not Completed");
                            }

                        }

                        else
                        {
                            iDfield.setText(" ");
                            priceField.setText(" ");
                            deadlineField.setText(" ");
                            descArea.setText(" ");
                            noteArea.setText(" ");
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

                if(iDfield.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error, No Order Selected.");
                }

                else{
                    int iD = Integer.parseInt(iDfield.getText());
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
                                iDfield.setText(" ");
                                priceField.setText(" ");
                                deadlineField.setText(" ");
                                descArea.setText(" ");
                                noteArea.setText(" ");

                            }
                        }

                        else{
                            iDfield.setText(" ");
                            priceField.setText(" ");
                            deadlineField.setText(" ");
                            descArea.setText(" ");
                            noteArea.setText(" ");
                        }

                    }

                    else{

                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "Error, Order Does Not Exist.");
                        iDfield.setText(" ");
                        priceField.setText(" ");
                        deadlineField.setText(" ");
                        descArea.setText(" ");
                        noteArea.setText(" ");
                        

                    }

                }


                

        }

        if(e.getSource() == viewCompleted){

        }

        if(e.getSource() == exit){
            ViewOrdersUI.this.setVisible(false);
            home.setVisible(true);

        }

    }



}

}
