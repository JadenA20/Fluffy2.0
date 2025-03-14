package BusinessLogic.Order;
import java.util.ArrayList;

public class Customer {
    private String fname, lname, phone, method;
    private int iD;
    //private ArrayList<Order> orders = new ArrayList<Order>();

    public Customer(int iD, String fname, String lname, String phone, String method){
        this.iD = iD;
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.method = method;
    }

    public Customer(){
        
    }

    /*public void addOrder(Order order){
        orders.add(order);
    }*/

    public void setFname(String fName){
        this.fname = fName;
    }

    public void setLname(String lName){
        this.lname = lName;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }


    public void setMethod(String contact){
        this.method = contact;
    }

    public int getID(){
        return this.iD;
    }

    public String getFname(){
        return this.fname;
    }

    public String getLname(){
        return this.lname;
    }

    public String getName(){
        return this.fname + " " + this.lname;
    }

    public String getPhone(){
        return this.phone;
    }


    public String getMethod(){
        return method;
    }


}
