package BusinessLogic.OrderData;
import java.time.*;


public class Order {
    // Order class
    private int iD;
<<<<<<<< HEAD:FluffApp/src/BusinessLogic/OrderData/Order.java
    private Customer customer;
========
    private static int count = 1;

>>>>>>>> e0ee78ec3c0e7d56bdc3e3331b52fda6923254fe:FluffApp/src/BusinessLogic/Order/Order.java
    private float price;
    private String desc, event, specialNote, deadline, date_cr, date_cmp, deliveryAddress;
    private Boolean status;
    private String payStat;


<<<<<<<< HEAD:FluffApp/src/BusinessLogic/OrderData/Order.java
    public Order (int iD, Customer customer, String desc, String event, String specialNote, String deliveryAddress, float price, String paymentStatus, String deadline, Boolean orderStatus, String dateCreated, String dateCompleted){
        this.iD = iD;
        this.customer = customer;
========
    public Order (Customer customer, String flavour,float price, String desc, String note,String event, String date_cr, String date_comp, String payStat){

        this.iD = count;
        this.price = price;
>>>>>>>> e0ee78ec3c0e7d56bdc3e3331b52fda6923254fe:FluffApp/src/BusinessLogic/Order/Order.java
        this.desc = desc;
        this.event = event;
        this.specialNote = specialNote;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.payStat = paymentStatus;
        this.deadline = deadline;
        this.status = orderStatus;
        this.date_cr = dateCreated;
        this.date_cmp = dateCompleted;
    
    }



    public void setDescription(String desc){
        this.desc = desc;

    }

    public void setEven (String event){
        this.event = event;

    }

    public void setPrice(float p){
        this.price = p;
    }

    public void setPaymentStatus(String p){
        this.payStat = p;
    }

    public void setStatus(){
        this.status = false;
       //this.date_cmp = getCurrentDate();

        if (this.payStat != "Complete"){
            this.payStat = "Complete";
        }  
    }


    public String getCurrentDate(){
        LocalDate date = LocalDate.now();
        return date.toString();

    }

    public Customer getCustomer(){
        return this.customer;
    }

    public int getID(){
        return this.iD;
    }

    public float getPrice(){
        return this.price;
    }

    public String getDateCreated(){
        return this.date_cr;
    }

    public String getDateCompleted(){
        if(isOpen() == false){
            return this.date_cmp;
        }

        else{
            return "Order not completed";
        }
       
    }

    public boolean isOpen(){
        if(this.status == true){
            return true;
        }
        else{
            return false;
        }
    }




}
