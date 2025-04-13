//Last Modified: March 11th, 2025

package Security;
import Database.UserTableController;
import java.util.ArrayList;

public class LoginController {
    
    //Verifies and validates a Baker's login credentials
    public Object[] login(String userName, String password){
        Object [] ob = new Object[2];
        Boolean verified = false;
        String query = "SELECT * FROM Users";
        UserTableController conn = new UserTableController();

        ArrayList<Baker> bakers = conn.getBakers(query);

        for(Baker b: bakers){
            if ((b.getUserName().equals(userName)) && (b.getPassword().equals(password))){
                verified = true;
                ob[0] = verified;
                ob[1] = b;

            }

        }


        return ob;
    //Gets saved registration information from database and checks for a match


    }

}
