package BusinessLogic.Comparator;

import java.util.Comparator;

import BusinessLogic.Inventory.Inventory;

public class InventoryStatusSort implements Comparator<Inventory>{
    public int compare(Inventory i1, Inventory i2 ){
        return i1.getStatus().compareTo(i2.getStatus());
    }

}
