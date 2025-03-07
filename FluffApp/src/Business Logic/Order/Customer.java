package Order;
import java.util.ArrayList;

public class Customer {
    private String fname, lname, phone, address;
    private ArrayList<Order> orders = new ArrayList<Order>();

    public Customer(String fname, String lname, String phone, String address){
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.address = address;
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

    public void address(String address){
        this.address = address;
    }

    public String getFname(){
        return this.fname;
    }

    public String getLname(){
        return this.lname;
    }

    public String name(){
        return this.fname + " " + this.lname;
    }



    public String getPhone(){
        return this.phone;
    }

    public String address(){
        return this.address;
    }




}
