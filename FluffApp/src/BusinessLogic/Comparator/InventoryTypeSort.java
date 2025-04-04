package BusinessLogic.Comparator;

import java.util.Comparator;

import BusinessLogic.Inventory.Inventory;

public class InventoryTypeSort implements Comparator<Inventory>{
    public int compare(Inventory i1, Inventory i2 ){
        return i1.getType().compareTo(i2.getType());
    }

}
