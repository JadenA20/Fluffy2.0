package BusinessLogic.Comparator;

import java.util.Comparator;
import BusinessLogic.Inventory.Inventory;

public class InventoryIDSort implements Comparator<Inventory>{
    public int compare(Inventory i1, Inventory i2 ){
        return new Integer(i1.getID()).compareTo(new Integer(i2.getID()));
    }


}
