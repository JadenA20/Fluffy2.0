package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OrderTableController {
    private String url = "jdbc:mysql://127.0.0.1:3306/fluffy_schema";
    private String user = "root";
    private String password = "fluffySweet2025!";



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


}
