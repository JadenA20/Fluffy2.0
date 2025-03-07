package database;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

 public class UserDatabaseController {
    private String url = "jdbc:mysql://127.0.0.1:3306/fluffy_schema";
    private String user = "root";
    private String password = "fluffySweet2025!";
    private ArrayList<String> users;

    public ArrayList<String> executeQuery(String query){
        users = new ArrayList<String>();
        try {
            
            


            Connection connection = DriverManager.getConnection(url, user, password);
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                String u = result.getString("Username") + ":" + result.getString("Password");
                users.add(u);           
            }

           
            

            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return users;




    }


    /*public static void main(String[] args) {
        UserDatabaseController userDatabaseController = new UserDatabaseController();
        ArrayList<String> help = new ArrayList<String>();
        help = userDatabaseController.executeQuery("SELECT * FROM Users");
        System.out.println(help);
        
    }*/
    


}
