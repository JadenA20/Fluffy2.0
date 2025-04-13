package GUI;

import javax.swing.*;

import BusinessLogic.Inventory.InventoryController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewItemUI extends JFrame{
    private JLabel title, name, quantity, description, type, status;
    private JTextField nameField, quantityField;
    private JTextArea descArea;
    private JButton create, cancel;
    private JScrollPane scrollPane;
    private JComboBox typeBox, statusBox;
    private ViewInventoryUI viewInventoryUI;

    public NewItemUI(ViewInventoryUI viewInventoryUI){

        this.viewInventoryUI = viewInventoryUI;

        // Instantiate Labels
        title = new JLabel("New Item");
        title.setFont(new Font("Courier New", 1, 36)); 
        title.setForeground(new Color(100, 67, 59));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        name = new JLabel("Item Name: ");
        name.setFont(new Font("Courier New", 1, 14)); 
        name.setForeground(new Color(100, 67, 59));

        quantity = new JLabel("Quantity: ");
        quantity.setFont(new Font("Courier New", 1, 14)); 
        quantity.setForeground(new Color(100, 67, 59));

        description = new JLabel("Description");
        description.setFont(new Font("Courier New", 1, 14)); 
        description.setForeground(new Color(100, 67, 59));


        type = new JLabel("Type: ");
        type.setFont(new Font("Courier New", 1, 14)); 
        type.setForeground(new Color(100, 67, 59));


        status = new JLabel("Status: ");
        status.setFont(new Font("Courier New", 1, 14)); 
        status.setForeground(new Color(100, 67, 59));


        // Instantiate TextFields/Areas
        nameField = new JTextField();
        nameField.setFont(new Font("Courier New", 0, 14)); 
        nameField.setForeground(new Color(100, 67, 59));

        quantityField = new JTextField();
        quantityField.setFont(new Font("Courier New", 0, 14)); 
        quantityField.setForeground(new Color(100, 67, 59));

        descArea = new JTextArea();
        descArea.setColumns(20);
        descArea.setFont(new Font("Courier New", 0, 14)); 
        descArea.setForeground(new Color(100, 67, 59));
        descArea.setRows(5);
       
        // Instantiate Buttons
        create = new JButton("Create");
        create.setBackground(new Color(100, 67, 59));
        create.setFont(new Font("Courier New", 1, 14)); 
        create.setForeground(new Color(255, 255, 255));
        create.addActionListener(new ButtonListener());

        cancel = new JButton("Cancel");
        cancel.setBackground(new Color(100, 67, 59));
        cancel.setFont(new Font("Courier New", 1, 14)); 
        cancel.setForeground(new Color(255, 255, 255));
        cancel.addActionListener(new ButtonListener());


        // Instantiate ComboBox
        typeBox = new JComboBox<String>(); 
        typeBox.setFont(new Font("Courier New", 1, 14)); 
        typeBox.setForeground(new Color(100, 67, 59));
        typeBox.setModel(new DefaultComboBoxModel<>(new String[] { "Perishable", "Non-Perishable"}));

        statusBox = new JComboBox<String>();
        statusBox.setFont(new Font("Courier New", 1, 14)); // NOI18N
        statusBox.setForeground(new Color(100, 67, 59));
        statusBox.setModel(new DefaultComboBoxModel<>(new String[] { "Low-Priority", "Medium-Priority", "High-Priority"}));
        

        // Scrollpane
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(descArea);

        GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(description, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                            .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(name, GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(quantity))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(quantityField, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                                    .addComponent(nameField))))
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addComponent(type, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(status, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(typeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(statusBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(56, 56, 56))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(create, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(title,GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170))
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(title)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(name)
                            .addComponent(type)
                            .addComponent(typeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(quantity)
                            .addComponent(status)
                            .addComponent(statusBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(description)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                            .addComponent(create, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                );

                pack();
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setVisible(true);

            
        




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

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == create){

                if(nameField.getText().isEmpty() && quantityField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(NewItemUI.this, "Empty Fields Detected.");
                }

                else{
                    String quant = quantityField.getText();
                    if(!(isInteger(quant))){
                        JOptionPane.showMessageDialog(NewItemUI.this, "Error: Quantity Must be and Integer.");
                        return;
                    }

                    else{
                        int quantity = Integer.parseInt(quant);
                        Boolean success = false;
                        String name = nameField.getText();
                        String description = descArea.getText();
                        String priority = String.valueOf(statusBox.getSelectedItem());
                        String type = String.valueOf(typeBox.getSelectedItem());

                        success = new InventoryController().createItem(name, description, priority, type, quantity);

                        if(success == true){
                            JOptionPane.showMessageDialog(NewItemUI.this, "Item Added Successfully");
                            setVisible(false);
                            viewInventoryUI.addToTable();
                            viewInventoryUI.setVisible(true);

                        }

                        
                        


                    }

                    }


                }

                

            

            if(e.getSource() == cancel){
                setVisible(false);
                viewInventoryUI.setVisible(true);
                
            }
        }
    }


}
