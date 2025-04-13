package BusinessLogic.Inventory;

import java.util.ArrayList;

import Database.InventoryTableController;
import Security.*;

public class InventoryController {

    public ArrayList<Inventory> viewRecords(){
        ArrayList<Inventory> itemList = new ArrayList<Inventory>();
        itemList = new InventoryTableController().getItems("select * from inventory");


        return itemList;

    }

    public Boolean createItem(String name, String description, String priority, String type, int quantity){
        Boolean success = false;
        String query = String.format("insert into inventory (Item_Name, Description, Item_Type, Priority, Quantity) values('%s', '%s', '%s', '%s', '%d')",name, description,type,priority,quantity);
        success = new InventoryTableController().addItem(query);

        return success;
    }

    public Boolean editItem(int iD, String name, String descString, String type, String status, int quantity){
        String query = String.format("UPDATE inventory SET Item_Name = '%s', Description = '%s', Item_Type = '%s', Priority = '%s', Quantity = '%d' WHERE Item_ID = '%d'", name, descString, type, status, quantity, iD);
        return new InventoryTableController().edit(query);
    }

    public Boolean deleteItem(int iD){
        String query = String.format("DELETE FROM inventory WHERE Item_ID = '%d'", iD);
        return new InventoryTableController().delete(query);
    }

    public Boolean authorized(Baker baker){
        return new Authorization().authorizeBaker(baker);
    }

}
