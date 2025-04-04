package Security;
import Database.UserTableController;
import java.util.*;

public class RegisterController {

    public boolean passwordValid(String confirmedpass, String pass){ // Goes in register controller
        boolean validity = false;

        if (pass.equals(confirmedpass))
            validity = true;
        return validity;
    }


    public Boolean registerBaker(String fName, String lName, String userName, String password){
        String query = String.format("INSERT INTO Users (FirstName, LastName, Username, Password, Type) VALUES ('%s', '%s', '%s', '%s', 'N')", fName, lName, userName, password, "N");
        UserTableController conn = new UserTableController();
        
        return conn.register(query);


    }

    public Object[] registerAdmin(String fName, String lName, String userName, String password){
        Random random = new Random();
        int passkey = random.nextInt(9000) + 1000; //Generates Random passkey between 0 and 9999;
        String query = String.format("INSERT INTO Users (FirstName, LastName, Username, Password, Type, AdminKey) VALUES ('%s', '%s', '%s', '%s', 'A', %d)", fName, lName, userName, password, passkey);
        UserTableController conn = new UserTableController();
        Object [] result = new Object[2];
        Boolean success = false;
        success = conn.register(query);
        result[0] = success;
        result[1] = passkey;
        
        return result;


    }

    public Boolean bakerExists(String userName, String password){
        Boolean exists = false;
        UserTableController userTableController = new UserTableController();
        ArrayList<Baker> bakers = new ArrayList<Baker>();
        bakers = new UserTableController().getBakers("select * from users");

        for(Baker b: bakers){
            if(b.getUserName().equals(userName) && b.getPassword().equals(password)){
                exists = true;
            }
        }

        return  exists;

    }

}
