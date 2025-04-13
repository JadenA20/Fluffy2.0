package BusinessLogic.Inventory;

public class Inventory {
    private int iD, quantity;
    private String name, description, itemType, priorityStatus;

    public Inventory(int iD, int quantity, String name, String description, String type, String status){
        this.iD = iD;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
        this.itemType = type;
        this.priorityStatus = status;
    }

    public Inventory(){

    }

    public int getID(){
        return this.iD;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getName(){
        return this.name;
    }

    
    public String getDesc(){
        return this.description;
    }
    
    public String getStatus(){
        return this.priorityStatus;
    }
    
    public String getType(){
        return this.itemType;
    }

    


}
