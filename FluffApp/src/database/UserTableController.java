package Database;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import Security.*;

 public class UserTableController {
    private String url = "jdbc:mysql://127.0.0.1:3306/fluffy_schema";
    private String user = "root";
    private String password = "fluffySweet2025!";
    private ArrayList<Baker> bakers;
    private ArrayList<Admin> admins;

    public ArrayList<Baker> getBakers(String query){
        bakers = new ArrayList<Baker>();
        try {

            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Baker b = new Baker(result.getString("FirstName"), result.getString("LastName"), result.getString("Username"), result.getString("Password"));
                bakers.add(b);   
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return bakers;

    }

    public Boolean register(String query){
        int rowsAffected = 0;
        try {
            
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            rowsAffected = stmt.executeUpdate(query);
            stmt.close();
            connection.close();

            

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return rowsAffected > 0;

        
    }

    public ArrayList<Admin> getAdmins(){
        admins = new ArrayList<Admin>();
        String query = "SELECT * FROM Users WHERE Type LIKE 'A'";
        try {         
    
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Admin a = new Admin(result.getString("FirstName"), result.getString("LastName"), result.getString("Username"),result.getString("Password"), result.getInt("PassKey"));
                admins.add(a);
                           
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return admins;


    }
    
   

}
