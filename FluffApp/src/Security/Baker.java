package Security;
public class Baker {
    private String fName, lName, usernName, password;


    public Baker(String fName, String lName, String userName, String password){
        this.fName = fName;
        this.lName = lName;
        this.usernName = userName;
        this.password = password;
    }

    public Baker(){
        
    }


    public String getFName(){
        return this.fName;
    }

    public String getLName(){
        return this.lName;
    }

    public String getUserName(){
        return this.usernName;
    }

    public String getPassword(){
        return this.password;
    }

    
    

}
