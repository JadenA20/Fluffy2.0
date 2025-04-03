package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BusinessLogic.Inventory.Inventory;
import BusinessLogic.Order.Customer;
import Security.Baker;

public class InventoryTableController {
    private String url = "jdbc:mysql://127.0.0.1:3306/fluffy_schema";
    private String user = "root";
    private String password = "fluffySweet2025!";
    private ArrayList<Inventory> items;


    public ArrayList<Inventory> getItems(String query){
        items = new ArrayList<Inventory>();

        try{

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(query);
        
        while(result.next()){
            Inventory i = new Inventory(result.getInt("Item_ID"), result.getInt("Quantity"), result.getString("Item_Name"), result.getString("Description"), result.getString("Item_Type"), result.getString("Priority"));
            items.add(i); 
            
        } 
    }
        
        catch(Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }


        return items;
    }


    public Boolean addItem(String query){
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

    public Boolean edit(String query){
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

    public Boolean delete(String query){
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


   


}
