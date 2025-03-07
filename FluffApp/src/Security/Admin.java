package Security;

public class Admin extends Baker{
    private int passKey;


    public Admin(String fName, String lName, String userName, String password, int passKey){
        super(fName, lName, userName, password);
        this.passKey = passKey;
    }


    public int getPasskey(){
        return this.passKey;
    }




}