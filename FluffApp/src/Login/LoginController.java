//Last Modified: March 6, 2025

package Login;
import java.util.ArrayList;
import database.UserDatabaseController;

public class LoginController {
    
    //Verifies and validates a Baker's login credentials
    public Boolean login(String userName, String password){
        Boolean verified = false;
        String loginDetails = userName + ":" + password;
        String query = "SELECT Username, Password FROM Users";
        UserDatabaseController conn = new UserDatabaseController();

        ArrayList<String> users = conn.executeQuery(query);

        for(String user: users){
            if (loginDetails.equals(user)){
                verified = true;
            }

        }

        return verified;
    //Gets saved registration information from database and checks for a match


    }

}
