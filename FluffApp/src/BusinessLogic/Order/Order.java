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

    public Order(){
        
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

    public String getDeliveryAddress(){
        return this.deliveryAddress;
    }

    public String getDateCreated(){
        return this.date_cr;
    }

    public String getDateCompleted(){
        return this.date_cmp;
       
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
        String str = getID() + ":" + getCustomer().getName() + ":" + getFlavour() + ":" + getDescription() + ":" + getEvent() + ":" + getNotes() + ":" + getDeliveryAddress() + ":" + getDeadline() + ":" + getPrice() + ":" + getPayStat() ;
        return str;
    }




}
