package GUI;

import javax.swing.*;
import BusinessLogic.Order.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateOrderUI extends JFrame{
    private JButton addOrder, cancelOrder;
    private JPanel entryPanel, buttonPanel;
    private JLabel title, nameLabel1, nameLabel2, addrLabel, phoneLabel, paymentSelect, contactLabel, priceLabel, dueDateLabel, addNoteLabel, deliLabel, flavourLabel, eventLabel, descLabel;
    private JTextField fname, lname, phone, address, event, flavour, contactField, price, dueDate, delivery;
    private JTextArea desc, addNote;
    private JComboBox<String> paystat;
    private String[] paymentStat= {"Pending","Deposited","Completed"};
    private Color bgColor = new Color(100, 67, 59);
    private String pay = "Pending";
    private ViewOrdersUI view;

    public CreateOrderUI(ViewOrdersUI view){
        this.view = view;

        setBackground(new Color(244, 235, 220));

        Font ver1 = new Font("Courier New", Font.BOLD, 30);
        Font ver3 = new Font("Bradley Hand ITC", Font.BOLD, 30);

        setTitle("Create Order Form");
        entryPanel = new JPanel();
        buttonPanel = new JPanel();

        entryPanel.setLayout(new GridLayout(13,3));
        buttonPanel.setLayout(new GridLayout(1,2));


        title = new JLabel("ORDER CREATION FORM");
        title.setFont(ver1);
        title.setBounds(300, 250, 300, 50);
        title.setForeground(bgColor);

        nameLabel1 = new JLabel("First Name:");
        nameLabel1.setFont(ver3);
        nameLabel1.setForeground(bgColor);
        entryPanel.add(nameLabel1);
        fname = new JTextField(50);
        fname.setFont(ver3);
        fname.setForeground(bgColor);
        entryPanel.add(fname);

        nameLabel2 = new JLabel("Last Name:");
        nameLabel2.setFont(ver3);
        nameLabel2.setForeground(bgColor);
        entryPanel.add(nameLabel2);
        lname = new JTextField(50);
        lname.setFont(ver3);
        lname.setForeground(bgColor);
        entryPanel.add(lname);

        phoneLabel = new JLabel("Telephone Number:");
        phoneLabel.setFont(ver3);
        phoneLabel.setForeground(bgColor);
        entryPanel.add(phoneLabel);
        phone = new JTextField(10);
        phone.setFont(ver3);
        phone.setForeground(bgColor);
        entryPanel.add(phone);

        contactLabel = new JLabel("Contact Method (Eg: WhatsApp, Email, Instagram):");
        contactLabel.setFont(ver3);
        contactLabel.setForeground(bgColor);
        entryPanel.add(contactLabel);
        contactField = new JTextField(15);
        contactField.setFont(ver3);
        contactField.setForeground(bgColor);
        entryPanel.add(contactField);

        dueDateLabel = new JLabel("Deadline (format: yyyy-mm-dd):");
        dueDateLabel.setFont(ver3);
        dueDateLabel.setForeground(bgColor);
        entryPanel.add(dueDateLabel);
        dueDate = new JTextField(15);
        dueDate.setFont(ver3);
        dueDate.setForeground(bgColor);
        entryPanel.add(dueDate);

        eventLabel = new JLabel("Event (Anniversary, Birthday etc.):");
        eventLabel.setFont(ver3);
        eventLabel.setForeground(bgColor);
        entryPanel.add(eventLabel);
        event = new JTextField(20);
        event.setFont(ver3);
        event.setForeground(bgColor);
        entryPanel.add(event);

        flavourLabel = new JLabel("Flavour:");
        flavourLabel.setFont(ver3);
        flavourLabel.setForeground(bgColor);
        entryPanel.add(flavourLabel);
        flavour = new JTextField(20);
        flavour.setFont(ver3);
        flavour.setForeground(bgColor);
        entryPanel.add(flavour);

        descLabel = new JLabel("Description:");
        descLabel.setFont(ver3);
        descLabel.setForeground(bgColor);
        entryPanel.add(descLabel);
        desc = new JTextArea(3,40);
        desc.setFont(ver3);
        desc.setForeground(bgColor);
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        entryPanel.add(desc);

        priceLabel = new JLabel("Price:");
        priceLabel.setFont(ver3);
        priceLabel.setForeground(bgColor);
        entryPanel.add(priceLabel);
        price = new JTextField(10);
        price.setFont(ver3);
        price.setForeground(bgColor);
        entryPanel.add(price);

        deliLabel = new JLabel("Delivery Destination:");
        deliLabel.setFont(ver3);
        deliLabel.setForeground(bgColor);
        entryPanel.add(deliLabel);
        delivery = new JTextField(30);
        delivery.setFont(ver3);
        delivery.setForeground(bgColor);
        entryPanel.add(delivery);

        addNoteLabel = new JLabel("Additional Notes:");
        addNoteLabel.setFont(ver3);
        addNoteLabel.setForeground(bgColor);
        entryPanel.add(addNoteLabel);
        addNote = new JTextArea(3,40);
        addNote.setFont(ver3);
        addNote.setForeground(bgColor);
        addNote.setLineWrap(true);
        addNote.setWrapStyleWord(true);
        entryPanel.add(addNote);


        //Dropdown selection for payment status
        paymentSelect = new JLabel("Select payment status:");
        paymentSelect.setFont(ver3);
        paymentSelect.setForeground(bgColor);
        paymentSelect.setBounds(50,50,130,15);
        paystat = new JComboBox<String>(paymentStat);
        paystat.setBounds(150,50,130,15);
        paystat.setFont(ver3);
        paystat.setForeground(bgColor);
        entryPanel.add(paymentSelect);
        entryPanel.add(paystat);


        addOrder = new JButton("Add Order");
        addOrder.setBackground(bgColor);
        addOrder.setForeground(new Color(255,255,255));
        addOrder.setFont(ver1);
        addOrder.setBounds(20, 260, 100, 50);

        cancelOrder = new JButton("Cancel");
        cancelOrder.setBackground(bgColor);
        cancelOrder.setForeground(new Color(255,255,255));
        cancelOrder.setFont(ver1);
        cancelOrder.setBounds(20, 260, 100, 50);

        addOrder.addActionListener(new ButtonListener());
        cancelOrder.addActionListener(new ButtonListener());

        buttonPanel.add(addOrder);
        buttonPanel.add(cancelOrder);

        add(title, BorderLayout.NORTH);
        add(entryPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);  

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 900));  

    }

    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
            if(e.getSource() == addOrder){
                try{
                    String firstName = fname.getText().trim();
                    String lastName = lname.getText().trim();
                    //String addr = address.getText().trim();
                    String teleNum = phone.getText().trim();
                    String flav = flavour.getText().trim();
                    String eventType = event.getText().trim();
                    float priceAmt = Float.parseFloat(price.getText().trim());
                    String description = desc.getText().trim();
                    String add_notes = addNote.getText().trim();
                    String method = contactField.getText().trim();
                    String destination = delivery.getText().trim();
                    String payStatus = (String) paystat.getSelectedItem();
                    String deadline = dueDate.getText();

                    if((firstName.equals("")) || (lastName.isEmpty()) || (teleNum.isEmpty()) || (flav.isEmpty()) || (eventType.isEmpty()) || (method.isEmpty()) || (description.isEmpty()) ){
                        JOptionPane.showMessageDialog(CreateOrderUI.this, "Empty Fields Detected: Please Enter Order Information.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;

                    }

                    else{
                        OrderController Controls = new OrderController();
                        Boolean success = Controls.createOrder(firstName, lastName, teleNum, flav, eventType, deadline, priceAmt, description, add_notes, method, destination, payStatus);

                        if(success == true){
                            JOptionPane.showMessageDialog(CreateOrderUI.this, "Order Created!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            CreateOrderUI.this.setVisible(false);
                            view.addToTable();
                            view.setVisible(true);
                        }

                        else{
                            JOptionPane.showMessageDialog(CreateOrderUI.this, "Error: Order not created", "Error", JOptionPane.ERROR_MESSAGE);

                        }


                    }

                    
                    //Controls.entryValidity();
                }
                catch(NumberFormatException nfe){

                }
                catch(NullPointerException npe){

                }

                
            }

            else if(e.getSource() == paystat){
                try{
                    pay = (String) paystat.getSelectedItem();
                }
    
                catch(NullPointerException npe){
                    JOptionPane.showMessageDialog(CreateOrderUI.this, "Invalid entry detected. Please select a payment status.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            else{
                setVisible(false);
                view.setVisible(true);
            }
        }
    }

}