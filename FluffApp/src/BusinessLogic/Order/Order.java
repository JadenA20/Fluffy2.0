package BusinessLogic.Order;
import java.time.*;


public class Order {
    // Order class
    private int iD;
    private Customer customer;
    private float price;
    private String desc, event, specialNote, deadline, date_cr, date_cmp, deliveryAddress;
    private Boolean status;
    private String payStat;


    public Order (int iD, Customer customer, String flavour,float price, String desc, String note,String event, String date_cr, String date_comp, String payStat){

        this.iD = iD;
        this.customer = customer;
        this.desc = desc;
        this.event = event;
        this.specialNote = specialNote;
        this.deliveryAddress = deliveryAddress;
        this.price = price;
        this.payStat = payStat;
        this.deadline = deadline;
        this.status = status;
        this.date_cr = date_cr;
        this.date_cmp = date_comp;
        
        
        
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
