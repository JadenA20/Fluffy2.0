package BusinessLogic.Order;

import java.util.ArrayList;
import java.util.Arrays;

import Database.CustomerTableController;
import Database.OrderTableController;


public class OrderController{
    private ArrayList<Order> orders;
    private ArrayList<Customer> customers;


    public Boolean createOrder(String fname, String lname, String telenum, String flav, String event, String deadline, float price, String desc, String note, String method, String deliveryAdrr, String payStat){
        // Check if Customer exists
        Boolean custExists = false;
        Customer customer = new Customer();
        String query = "SELECT * FROM Customers"; // Create query to get customers
        customers = new CustomerTableController().getCustomers(query); // Get customer list
        //System.out.println(customers);
        String custName = fname + " " + lname; // Name of customer
        
        for(Customer c: customers){
            if(c.getName().equals(custName)){
                custExists = true;
                customer = c;

            }
        }

        if(custExists){
            //System.out.println(customer.toString());
            String query1 =  String.format("INSERT INTO Orders (CustomerID, Flavour, Description, Event, Note, Address, Deadline, Price, Status, PayStatus, Date_Created) VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', %.2f, %d, '%s', CURRENT_DATE())", customer.getID(), flav, desc, event, note, deliveryAdrr, deadline, price, 0, payStat);
            OrderTableController conn = new OrderTableController();
            if(conn.addOrder(query1)){
                return true;
            }

            else{
                return false;
            }

        }

        else{
            Boolean newCustomer = false;
            String query2 = String.format("INSERT INTO Customers (FirstName, LastName, Phone, ContactMethod) VALUES('%s', '%s', '%s', '%s')", fname, lname, telenum, method);
            CustomerTableController cuu_conn = new CustomerTableController();

            if(cuu_conn.newCustomer(query2)){
                newCustomer = true;
                customers = cuu_conn.getCustomers(query);

                for(Customer c: customers){
                    if(c.getName().equals(custName)){
                        customer = c;
                    }
                }

                

                String query1 =  String.format("INSERT INTO Orders (CustomerID, Flavour, Description, Event, Note, Address, Deadline, Price, Status, PayStatus, Date_Created) VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', %.2f, %d, '%s', CURRENT_DATE())", customer.getID(), flav, desc, event, note, deliveryAdrr, deadline, price, 0, payStat);
                OrderTableController conn = new OrderTableController();
                if(conn.addOrder(query1)){
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
       
        

    }

   
}
