package Security;

import Database.UserTableController;
import java.util.ArrayList;

public class Authorization {
    private ArrayList<Admin> admins;

    public Authorization(){

    }

    public Boolean authorizeBaker(Baker baker){

        admins = new UserTableController().getAdmins();
        boolean match = false;

        for (Admin a  : admins) {

            String adUsername = a.getUserName();
            String bakerUsername = baker.getUserName(); 

            if (adUsername.equals(bakerUsername)){
                
                match = true;
                
            }
            
        }
        
        return match;

        
    }


    public Boolean checkPasskey(String passkey) {

        admins = new UserTableController().getAdmins();
        boolean match = false;

        for (Admin a  : admins) {

            int adPasskey = a.getPasskey();
            int entry = Integer.valueOf(passkey);

            if (adPasskey == entry){
                
                match = true;
                
            }
            
        }
        
        return match;


    }


}
