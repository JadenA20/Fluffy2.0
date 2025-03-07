package Order;
import java.time.*;


public class Order {
    // Order class
    private Customer customer;
    private int iD;
    private static int count = 1;
    private float price;
    private String desc, event, date_cr, date_cmp = " ";
    private Boolean open = true;
    private String payStat;


    public Order (Customer customer, float price, String desc, String event, String date_cr, String payStat){
        this.customer = customer;
        this.iD = count;
        this.price = price;
        this.desc = desc;
        this.event = event;
        this.date_cr = getCurrentDate();
        this.payStat = payStat;
        count++;

    }

    public void setStatus(){
        this.open = false;
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
        if(this.open == true){
            return true;
        }
        else{
            return false;
        }
    }




}
