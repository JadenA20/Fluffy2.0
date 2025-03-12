//Last Modified: March 11th, 2025

package Security;
import database.UserTableController;
import java.util.ArrayList;

public class LoginController {
    
    //Verifies and validates a Baker's login credentials
    public Boolean login(String userName, String password){
        Boolean verified = false;
        String query = "SELECT * FROM Users";
        UserTableController conn = new UserTableController();

        ArrayList<Baker> bakers = conn.getBakers(query);

        for(Baker b: bakers){
            if ((b.getUserName().equals(userName)) && (b.getPassword().equals(password))){
                verified = true;
            }

        }

        return verified;
    //Gets saved registration information from database and checks for a match


    }

}
