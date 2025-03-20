package BusinessLogic.Order;
import java.time.*;


public class Order {
    // Order class
    private int iD;
    private Customer customer;
    private float price;
    private String desc, event, flavour, specialNote, deadline, date_cr, date_cmp, deliveryAddress;
    private Boolean status;
    private String payStat;


    public Order (int iD, Customer customer, String flavour,float price, String desc, String note,String event, String deliveryAddress, String deadline, String date_cr, String date_comp, String payStat, Boolean status){

        this.iD = iD;
        this.customer = customer;
        this.desc = desc;
        this.flavour = flavour;
        this.event = event;
        this.specialNote = note;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.payStat = payStat;
        this.deadline = deadline;
        this.status = status;
        this.date_cr = date_cr;
        this.date_cmp = date_comp;
        this.status = status;
        
        
        
    }

    public void setStatus(){
        this.status = false;
        this.date_cmp = getCurrentDate();

        if (this.payStat != "Complete"){
            this.payStat = "Complete";
        }  
    }

    public void setPaymentStatus(String p){
        this.payStat = p;
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

    public String getEvent(){
        return this.event;

    }

    public String getFlavour(){
        return this.flavour;

    }

    public String getNotes(){
        return this.specialNote;

    }

    public String getDescription(){
        return this.desc;

    }

    public String getDeadline(){
        return this.deadline;

    }

    public String getPayStat(){
        return this.payStat;

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

    public String toString() {
        return "Order{id=" + this.iD + ", cust='" + getCustomer() + "', email='}";
    }




}
