package Security;
import java.util.ArrayList;

import Database.UserTableController;

import java.util.*;

public class RegisterController {


    public Boolean registerBaker(String fName, String lName, String userName, String password){
        String query = String.format("INSERT INTO Users (FirstName, LastName, Username, Password, Type) VALUES ('%s', '%s', '%s', '%s', 'N')", fName, lName, userName, password);
        UserTableController conn = new UserTableController();
        
        return conn.register(query);


    }

    public Boolean registerAdmin(String fName, String lName, String userName, String password){
        Random random = new Random();
        int passkey = random.nextInt(9000) + 1000; //Generates Random passkey between 0 and 9999;
        String query = String.format("INSERT INTO Users (FirstName, LastName, Username, Password, Type, PassKey) VALUES ('%s', '%s', '%s', '%s', 'A', '%s')", fName, lName, userName, password, passkey);
        UserTableController conn = new UserTableController();
        
        return conn.register(query);


    }

}
