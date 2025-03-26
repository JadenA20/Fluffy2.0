package Inventory;

public class Inventory {
//Inventory
private int id,stockCount,priorityStatus;
private static int count =1;
private String name, item_desc;

public Inventory(int id, int stockCount, int priorityStatus,String name, String item_desc){
    this.id=count;
    this.stockCount = stockCount;
    this.priorityStatus = priorityStatus;
    this.name = name;
    this.item_desc = item_desc;
    count++;
}

public void setStockCount(int newStockCount){
    this.stockCount = newStockCount;
}

public void setPriorityStatus(int newPriority){
    this.priorityStatus = newPriority;
}

public void setName(String newName){
    this.name = newName;
}
public void setDescription(String newDescrip){
    this.item_desc = newDescrip;
}

}
