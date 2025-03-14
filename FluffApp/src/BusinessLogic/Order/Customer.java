package BusinessLogic.OrderData;
import java.util.ArrayList;

public class Customer {
    private String fname, lname, phone, address, method;
    private ArrayList<Order> orders = new ArrayList<Order>();

    public Customer(String fname, String lname, String phone, String address, String method){
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.address = address;
        this.method = method;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public void setFname(String fName){
        this.fname = fName;
    }

    public void setLname(String lName){
        this.lname = lName;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setMethod(String contact){
        this.method = contact;
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

    public String getAddress(){
        return this.address;
    }

    public String getMethod(){
        return method;
    }


}
