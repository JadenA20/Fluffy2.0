package BusinessLogic.Comparator;

import java.util.Comparator;
import BusinessLogic.Order.Order;

public class OrderIDSort implements Comparator<Order>{
    public int compare(Order o1, Order o2){
        return new Integer(o1.getID()).compareTo(new Integer(o2.getID()));
        }


}
