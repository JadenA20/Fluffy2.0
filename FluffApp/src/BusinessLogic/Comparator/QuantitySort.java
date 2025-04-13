package BusinessLogic.Comparator;

import java.util.Comparator;

import BusinessLogic.Inventory.Inventory;

public class QuantitySort implements Comparator<Inventory>{

    public int compare(Inventory i1, Inventory i2 ){
        return new Integer(i1.getQuantity()).compareTo(new Integer(i2.getQuantity()));
    }

}
