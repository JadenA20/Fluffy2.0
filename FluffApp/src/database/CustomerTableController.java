package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BusinessLogic.Order.*;

public class CustomerTableController {
    private String url = "jdbc:mysql://127.0.0.1:3306/fluffy_schema";
    private String user = "root";
    private String password = "fluffySweet2025!";
    private ArrayList<Customer> customers;

    public ArrayList<Customer> getCustomers(String query){
        customers = new ArrayList<Customer>();

        try{
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Customer c = new Customer(result.getInt("customerID"), result.getString("FirstName"), result.getString("LastName"), result.getString("Phone"), result.getString("ContactMethod"));
                customers.add(c);
            }

        }

        catch(Exception e){
             // TODO: handle exception
             e.printStackTrace();
        }
        return customers;

    }

    public Boolean newCustomer(String query){
        int rowsAffected = 0;
        try{
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement stmt = connection.createStatement();
        rowsAffected = stmt.executeUpdate(query);
        stmt.close();
        connection.close();

        }

        catch(Exception e){
            // TODO: handle exception
            e.printStackTrace();

        }
        return rowsAffected > 0;


    }


    


}
