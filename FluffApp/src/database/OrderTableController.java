package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;

import BusinessLogic.Order.*;
import Security.Admin;

import java.util.*;

public class OrderTableController {
    private String url = "jdbc:mysql://127.0.0.1:3306/fluffy_schema";
    private String user = "root";
    private String password = "fluffySweet2025!";
    private ArrayList<Order> orders;
    private ArrayList<Customer> customers;
    private CustomerTableController cust = new CustomerTableController();



    public Boolean addOrder(String query){
        int rowsAffected = 0;

        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            rowsAffected = stmt.executeUpdate(query);
            stmt.close();
            connection.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return rowsAffected > 0;
    }

    public ArrayList<Order> getOrders(String query){
        orders = new ArrayList<Order>();
        customers = cust.getCustomers("select * from Customers");

        try{

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(query);
        
        while(result.next()){
            for(Customer c: customers){
                if(c.getID() == result.getInt("CustomerID")){
                    Order o = new Order(result.getInt("order_ID"), c, result.getString("Flavour"), result.getFloat("Price"), result.getString("Description"), result.getString("Note"), result.getString("Event"), result.getString("Address"), result.getString("Deadline"), result.getString("Date_Created"), result.getString("Date_Completed"), result.getString("PayStatus"), result.getBoolean("Status"));
                    orders.add(o);
                }
                
                           
            }
            
        } 
    }
        
        catch(Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return orders;

       
    }


    public Boolean editOrder(String query){

        int rowsUpdated = 0;

        try {

            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            rowsUpdated = stmt.executeUpdate(query);

            
        } 
        
        catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }

        return rowsUpdated > 0;

    }

    public Boolean deleteOrder(String query){

        int rowsUpdated = 0;

        try {

            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            rowsUpdated = stmt.executeUpdate(query);

            
        } 
        
        catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
        }

        return rowsUpdated > 0;
        
    }


    /*public String toString(Date date) {
        return "Customer{id=" + date.getYear()+ ", name='" + getName() + "', email='}";
    }*/
}

    

