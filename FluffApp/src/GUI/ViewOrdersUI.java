package GUI;

import BusinessLogic.Comparator.DeadlineSort;
import BusinessLogic.Comparator.OrderIDSort;
import BusinessLogic.Comparator.StatusSort;
import BusinessLogic.Order.Customer;
import BusinessLogic.Order.Order;
import BusinessLogic.Order.OrderController;
import Database.CustomerTableController;
import Security.Authorization;
import Security.Baker;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

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

        /*currentOrders = new OrderController().viewCurrentOrders();
        for(Order o: currentOrders){
            System.out.println(o);
        }

        ArrayList<Customer> customers = new CustomerTableController().getCustomers("Select * from customers");
        for(Customer c: customers){
            System.out.println(c);
        }*/
        

        this.home = Home;
        this.login = Login;

        //Instantiate Labels
        title = new JLabel("Orders"); 
        title.setFont(new Font("Courier New", 1, 24)); 
        title.setForeground(new Color(100, 67, 59));


        notes = new JLabel("Notes: "); 
        notes.setFont(new Font("Courier New", 1, 14)); 
        notes.setForeground(new Color(100, 67, 59));


        description = new JLabel("Description"); 
        description.setFont(new Font("Courier New", 1, 14)); 
        description.setForeground(new Color(100, 67, 59));
    

        orderID = new JLabel("Order ID: "); 
        orderID.setFont(new Font("Courier New", 1, 12)); 
        orderID.setForeground(new Color(100, 67, 59));
        
        deadline = new JLabel("Deadline: "); 
        deadline.setFont(new Font("Courier New", 1, 14)); 
        deadline.setForeground(new Color(100, 67, 59));

        address = new JLabel("Address");
        address.setFont(new Font("Courier New", 1, 14)); 
        address.setForeground(new Color(100, 67, 59));

        
        price = new JLabel("Price: "); 
        price.setFont(new Font("Courier New", 1, 14)); 
        price.setForeground(new Color(100, 67, 59));
    

        paymentStatus = new JLabel("Payment Status: "); 
        paymentStatus.setFont(new Font("Courier New", 1, 13)); 
        paymentStatus.setForeground(new Color(100, 67, 59));
        paymentStatus.setPreferredSize(new Dimension(200, 30)); 

    

        status = new JLabel("Status: "); 
        status.setFont(new Font("Courier New", 1, 14));
        status.setForeground(new Color(100, 67, 59));


        //Instantiate textfeilds
        iDField = new JTextField(10); 
        deadlineField = new JTextField(10); 
        priceField = new JTextField(10); 

        //Instantiate TextArea
        descArea = new JTextArea(); 
        descArea.setColumns(20);
        descArea.setForeground(new Color(100, 67, 59));
        descArea.setRows(5);

        noteArea = new JTextArea(); 
        noteArea.setColumns(20);
        noteArea.setForeground(new Color(100, 67, 59));
        noteArea.setRows(5);

        addressArea =  new JTextArea();
        addressArea.setColumns(20);
        addressArea.setForeground(new Color(100, 67, 59));
        addressArea.setRows(5);


       

        //Instantiate ComboBox
        payBox = new JComboBox(); 
        payBox.setForeground(new Color(100, 67, 59));
        payBox.setFont(new Font("Courier New", 1, 14));
        payBox.setModel(new DefaultComboBoxModel<>(new String[] { "Pending", "Deposited", "Completed"}));

        statusBox = new JComboBox<>(); 
        statusBox.setForeground(new Color(100, 67, 59));
        statusBox.setFont(new Font("Courier New", 1, 14));
        statusBox.setModel(new DefaultComboBoxModel<>(new String[] { "Open", "Complete"}));


        //Instantiate scroll panel
        scrollPane1 = new JScrollPane();
        scrollPane1.setViewportView(descArea);

        scrollPane2 = new JScrollPane(); 
        scrollPane2.setViewportView(noteArea);

        scrollPane3 = new JScrollPane(); 

        scrollPane4 = new JScrollPane();
        scrollPane4.setViewportView(addressArea);
       
        //Instantiate buttons
        createOrder = new JButton("Create Order"); 
        createOrder.setBackground(new Color(100, 67, 59));
        createOrder.setFont(new Font("Courier New", 1, 14)); 
        createOrder.setForeground(new Color(255, 255, 255));
        createOrder.addActionListener(new ButtonListener());
    

        editOrder = new JButton("Edit Order"); 
        editOrder.setBackground(new Color(100, 67, 59));
        editOrder.setFont(new Font("Courier New", 1, 14)); 
        editOrder.setForeground(new Color(255, 255, 255));
        editOrder.addActionListener(new ButtonListener());
        

        deleteOrder = new JButton("Cancel Order"); 
        deleteOrder.setBackground(new Color(100, 67, 59));
        deleteOrder.setFont(new Font("Courier New", 1, 14)); 
        deleteOrder.setForeground(new Color(255, 255, 255));
        deleteOrder.addActionListener(new ButtonListener());

        sortByDeadline = new JButton("Sort-by-Deadline"); 
        sortByDeadline.setBackground(new Color(100, 67, 59));
        sortByDeadline.setFont(new Font("Courier New", 1, 12)); 
        sortByDeadline.setForeground(new Color(255, 255, 255));
        sortByDeadline.addActionListener(new SortListener());
       

        search = new JButton("Search"); 
        search.setBackground(new Color(100, 67, 59));
        search.setFont(new Font("Courier New", 1, 10)); 
        search.setForeground(new Color(255, 255, 255));
        search.addActionListener(new ButtonListener());

        sortByID = new JButton("Sort-by-ID"); 
        sortByID.setBackground(new Color(100, 67, 59));
        sortByID.setFont(new Font("Courier New", 1, 12)); 
        sortByID.setForeground(new Color(255, 255, 255));
        sortByID.addActionListener(new SortListener());
       

        sortByStatus = new JButton("Sort-by-Status"); 
        sortByStatus.setBackground(new Color(100, 67, 59));
        sortByStatus.setFont(new Font("Courier New", 1, 12)); 
        sortByStatus.setForeground(new Color(255, 255, 255));
        sortByStatus.addActionListener(new SortListener());


        viewCompleted = new JButton("View Completed"); 
        viewCompleted.setBackground(new Color(100, 67, 59));
        viewCompleted.setFont(new Font("Courier New", 1, 14)); 
        viewCompleted.setForeground(new Color(255, 255, 255));
        viewCompleted.addActionListener(new ButtonListener());
        

        exit = new JButton("Exit"); 
        exit.setBackground(new Color(100, 67, 59));
        exit.setFont(new Font("Courier New", 1, 14)); 
        exit.setForeground(new Color(255, 255, 255));
        exit.addActionListener(new ButtonListener());

        submit = new JButton("Submit"); 
        submit.setBackground(new Color(100, 67, 59));
        submit.setFont(new Font("Courier New", 1, 10)); 
        submit.setForeground(new Color(255, 255, 255));
        submit.addActionListener(new ButtonListener());;
        
       

        //Instantiate table
        ordersTable = new JTable();

        ordersTable.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.black, Color.white, Color.white));
        ordersTable.setFont(new Font("Courier New", 1, 12)); 
        ordersTable.setForeground(new Color(100, 67, 59));
        ordersTable.setModel(new DefaultTableModel(
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

    public Boolean isFloat(String str){
        if(str == null  || str.isEmpty()){
            return false;
        }

        try {
            Float.parseFloat(str);
            return true;
            
        } catch (Exception e) {
            return false;

            // TODO: handle exception
        }
    }

    public Boolean validDateFormat(String date){
        try{
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(date, format);
            return true;
        }

        catch(DateTimeParseException e){
            System.out.println(e);
            return false;
            
        }



    }

    public Boolean isValidDate(String date){
        if(validDateFormat(date)){
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dateEntered = LocalDate.parse(date, format);
            LocalDate currnDate = LocalDate.now();

            if(dateEntered.isAfter(currnDate) || dateEntered.isEqual(currnDate)){
                return true;
            }

            else{
                return false;
            }
        }

        else{
            return false;
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
                ArrayList<Order> orders = new ArrayList<Order>();
                orders = new OrderController().viewCurrentOrders();
                Boolean exists = false;

               

                if(!(iDField.getText().isEmpty())){
                    String ID = iDField.getText().strip();

                    if(!isInteger(ID)){
                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "ID Must Be An Integer.", "Error", JOptionPane.ERROR_MESSAGE);
                        iDField.setText("");
                        priceField.setText("");
                        deadlineField.setText("");
                        descArea.setText("");
                        noteArea.setText("");
                        addressArea.setText("");
                        return;
                    }
                    Order order = new Order();
                    int iD = Integer.parseInt(iDField.getText().strip());

                    for(Order o: orders){
                        if (o.getID() == iD){
                            order = o;
                            exists = true;
                        }
                        
                    }

                    if (exists == false){
                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order Does Not Exist.", "Error", JOptionPane.ERROR_MESSAGE);
                        iDField.setText("");
                        priceField.setText("");
                        deadlineField.setText("");
                        descArea.setText("");
                        noteArea.setText("");
                        addressArea.setText("");
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
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Please Enter An ID", "Error", JOptionPane.ERROR_MESSAGE);
                        iDField.setText("");
                        priceField.setText("");
                        deadlineField.setText("");
                        descArea.setText("");
                        noteArea.setText("");
                        addressArea.setText("");
                }

            }

            if(e.getSource() == editOrder){
                ArrayList<Order> orders = new ArrayList<Order>();
                orders = new OrderController().viewCurrentOrders();

                Boolean exists = false;

                if(iDField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "No Order Selected.", "Error", JOptionPane.ERROR_MESSAGE);
                     iDField.setText("");
                        priceField.setText("");
                        deadlineField.setText("");
                        descArea.setText("");
                        noteArea.setText("");
                        addressArea.setText("");
                    return;
                }

                String ID = iDField.getText().strip();
                if(!isInteger(ID)){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "ID Must Be An Integer.", "Error", JOptionPane.ERROR_MESSAGE);
                        iDField.setText("");
                        priceField.setText("");
                        deadlineField.setText("");
                        descArea.setText("");
                        noteArea.setText("");
                        addressArea.setText("");
                    return;
                }

                else{
                    int iD = Integer.parseInt(iDField.getText().strip());
                    for(Order o: orders)
                    {
                        if(o.getID() == iD){
                            exists = true;       
                        }

                    }

                    if(exists == true){

                        String description = descArea.getText().strip();
                        String notes = noteArea.getText().strip();
                        String payStatus = String.valueOf(payBox.getSelectedItem());
                        String deadline = deadlineField.getText().strip();

                        if(!isValidDate(deadline)){
                            JOptionPane.showMessageDialog(ViewOrdersUI.this, "Not A Valid Date", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String address = addressArea.getText().strip();
                        String p = priceField.getText().strip();

                        if(!isFloat(p)){
                            JOptionPane.showMessageDialog(ViewOrdersUI.this, "Price Must Be A Number.", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        float price = Float.parseFloat(priceField.getText());

                        int response = JOptionPane.showConfirmDialog(ViewOrdersUI.this, "Save new details?");

                        if(response == JOptionPane.YES_OPTION){
                            OrderController conn = new OrderController();
                            Boolean success = conn.editOrder(description, notes, payStatus, address, price, deadline, iD);

                            if(success == true){
                                addToTable();
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Update Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                                iDField.setText("");
                                priceField.setText("");
                                deadlineField.setText("");
                                descArea.setText("");
                                noteArea.setText("");
                                addressArea.setText("");
                            }

                            else{
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Update Failed", "Error", JOptionPane.ERROR_MESSAGE);
                                iDField.setText("");
                                priceField.setText("");
                                deadlineField.setText("");
                                descArea.setText("");
                                noteArea.setText("");
                                addressArea.setText("");
                            }
                         }

                        else{
                    
                            iDField.setText("");
                            priceField.setText("");
                            deadlineField.setText("");
                            descArea.setText("");
                            noteArea.setText("");
                            addressArea.setText("");
                        }

                    }

                    else{

                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order Does Not Exist.", "Error", JOptionPane.ERROR_MESSAGE);

                    }


                }


                
                


            }

            if(e.getSource() == submit){

                Boolean exists = false;
                Boolean success = false;
                ArrayList<Order> orders = new ArrayList<Order>();
                orders = new OrderController().viewCurrentOrders();

               

                if(iDField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "No Order Selected.", "Error", JOptionPane.ERROR_MESSAGE);
                        iDField.setText("");
                        priceField.setText("");
                        deadlineField.setText("");
                        descArea.setText("");
                        noteArea.setText("");
                        addressArea.setText("");
                    return;
                }

                String ID = iDField.getText().strip();
                if(!isInteger(ID)){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "ID Must Be An Integer.", "Error", JOptionPane.ERROR_MESSAGE);
                        iDField.setText("");
                        priceField.setText("");
                        deadlineField.setText("");
                        descArea.setText("");
                        noteArea.setText("");
                        addressArea.setText("");
                    return;
                }

                else{
                    int iD = Integer.parseInt(iDField.getText().strip());
                    for(Order o: orders)
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
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order Completed", "Success", JOptionPane.INFORMATION_MESSAGE);
                                iDField.setText("");
                                priceField.setText("");
                                deadlineField.setText("");
                                descArea.setText("");
                                noteArea.setText("");
                                addressArea.setText("");
                            }

                            else{
                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order Not Completed", "Error", JOptionPane.ERROR_MESSAGE);
                            }

                        }

                        else
                        {
                            iDField.setText("");
                            priceField.setText("");
                            deadlineField.setText("");
                            descArea.setText("");
                            noteArea.setText("");
                            addressArea.setText("");
                        }


                    }

                    else if(String.valueOf(statusBox.getSelectedItem()).equals("Open")){
                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "To Complete This Order, Please Select The Correct Status Option.", "Error", JOptionPane.ERROR_MESSAGE);

                    }

                    else{

                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order Does Not Exist","Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println(String.valueOf(statusBox.getSelectedItem()));

                    }




            }

            
           
        }

        if(e.getSource() == deleteOrder){
    
            Boolean exists = false;
            Boolean success = false;
            ArrayList<Order> orders = new ArrayList<Order>();
            orders = new OrderController().viewCurrentOrders();
            

                if(iDField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "No Order Selected.", "Error", JOptionPane.ERROR_MESSAGE);
                    iDField.setText("");
                    priceField.setText("");
                    deadlineField.setText("");
                    descArea.setText("");
                    noteArea.setText("");
                    addressArea.setText("");
                    return;
                }

                String ID = iDField.getText().strip();
                if(!isInteger(ID)){
                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "ID Must Be An Integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    iDField.setText("");
                    priceField.setText("");
                    deadlineField.setText("");
                    descArea.setText("");
                    noteArea.setText("");
                    addressArea.setText("");
                    return;
                }

                else{
                    int iD = Integer.parseInt(iDField.getText().strip());
                    for(Order o: orders)
                    {
                        if(o.getID() == iD){
                            exists = true;       
                        }
                    }

                    if(exists == true){
                       
                        Baker current_baker = login.getCurrentUser();
                        boolean authorized = new OrderController().authorized(current_baker);
                        String key;
                        Boolean matched = false;
                        Boolean checked = false;
                        
                        
                        if (authorized == false) {
            
                           key = JOptionPane.showInputDialog(null, "Admin Not Detected. Please Enter Admin Passkey.", JOptionPane.INFORMATION_MESSAGE);
            
                           boolean match = new Authorization().checkPasskey(key);
            
                            if (match == false) {

                                JOptionPane.showMessageDialog(ViewOrdersUI.this, "Invalid Passkey. Please Try Again.", "Error", JOptionPane.ERROR_MESSAGE);
                                
                            }

                            else {
                            
                                matched = true;
                            } 
                        
                        } 
                       
                        else {

                            checked = true;
                       
                        }

                        if ((checked == true) || (matched == true)) {

                            int response = JOptionPane.showConfirmDialog(ViewOrdersUI.this, "Cancel Order?");

                            if(response == JOptionPane.YES_OPTION){
                                success = new OrderController().cancelOrder(iD);
                                if(success == true){
                                    addToTable();
                                    JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order Cancelled.", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    iDField.setText("");
                                    priceField.setText("");
                                    deadlineField.setText("");
                                    descArea.setText("");
                                    noteArea.setText("");
                                    addressArea.setText("");

                                }
                            }

                            else{
                                iDField.setText("");
                                priceField.setText("");
                                deadlineField.setText("");
                                descArea.setText("");
                                noteArea.setText("");
                                addressArea.setText("");
                            }

                        }

                    }

                    else{

                        JOptionPane.showMessageDialog(ViewOrdersUI.this, "Order Does Not Exist.", "Error", JOptionPane.ERROR_MESSAGE);
                        iDField.setText("");
                        priceField.setText("");
                        deadlineField.setText("");
                        descArea.setText("");
                        noteArea.setText("");
                        addressArea.setText("");
                        

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
