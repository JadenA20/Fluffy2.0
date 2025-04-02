package BusinessLogic.Inventory;

import java.util.ArrayList;

import Database.InventoryTableController;

public class InventoryController {

    public ArrayList<Inventory> viewRecords(){
        ArrayList<Inventory> itemList = new ArrayList<Inventory>();
        itemList = new InventoryTableController().getItems("select * from inventory");


        return itemList;

    }

}
