package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.Order.Order;
import BusinessLogic.Order.OrderController;

public class ViewCompleteOrdersUI extends JFrame{
    private JLabel title;
    private JTable table;
    private JButton sortByID, sortByDeadline, exit;
    private JScrollPane scrollPane;
    private ViewOrdersUI ViewOrdersUI;

    public ViewCompleteOrdersUI(ViewOrdersUI ViewOrdersUI){
        this.ViewOrdersUI = ViewOrdersUI;

        // Instantiate Elements
        title = new JLabel("Completed Orders");
        title.setFont(new Font("Courier New", 1, 36)); 
        title.setForeground(new Color(100, 67, 59));

        // Instantiate Buttons
        sortByDeadline = new JButton("Sort-By-Deadline");
        sortByDeadline.setBackground(new Color(100, 67, 59));
        sortByDeadline.setFont(new Font("Courier New", 1, 14)); 
        sortByDeadline.setForeground(new Color(255, 255, 255));
        sortByDeadline.addActionListener(new ButtonListener());

        sortByID = new JButton("Sort-By-ID");
        sortByID.setBackground(new Color(100, 67, 59));
        sortByID.setFont(new Font("Courier New", 1, 14)); 
        sortByID.setForeground(new Color(255, 255, 255));
        sortByID.addActionListener(new ButtonListener());

        exit = new JButton("Exit");
        exit.setBackground(new Color(100, 67, 59));
        exit.setFont(new Font("Courier New", 1, 14)); 
        exit.setForeground(new Color(255, 255, 255));
        exit.addActionListener(new ButtonListener());

        scrollPane = new JScrollPane();

        // Instantiate Table
        table = new JTable();
        table.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.black, Color.lightGray, null, null));
        table.setFont(new Font("Courier New", 1, 12)); 
        table.setForeground(new Color(100, 67, 59));
        table.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
            },
            new String [] {
                "ID", "Customer", "Event", "Flavour", "Description", "Price", "DateCreated", "DateCompleted"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new Color(230, 230, 230));
        table.setShowGrid(true);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        scrollPane.setViewportView(table);


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(sortByDeadline)
                .addGap(176, 176, 176)
                .addComponent(sortByID, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addComponent(exit, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(269, 269, 269))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(title)
                .addGap(50, 50, 50)
                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sortByDeadline, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortByID, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );


        addToTable();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
        pack();
        setVisible(true);


    }

    public void addToTable(){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<Order> orders = new ArrayList<Order>();
        orders = new OrderController().viewCompletedOrders();
        Object rowData[] = new Object[9];
        for(Order o: orders){
            rowData[0] = o.getID();
            rowData[1] = o.getCustomer().getName();
            rowData[2] = o.getEvent();
            rowData[3] = o.getFlavour();
            rowData[4] = o.getDescription();
            rowData[5] = o.getPrice();
            rowData[6] = o.getDateCreated();
            rowData[7] = o.getDateCompleted();
            model.addRow(rowData);
        }

    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == sortByDeadline){

            }

            if(e.getSource() == sortByID){

            }

            if(e.getSource() == exit){
                setVisible(false);
                ViewOrdersUI.setVisible(true);
            }
        }
    }
}
