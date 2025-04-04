package BusinessLogic.Comparator;

import java.util.Comparator;

import BusinessLogic.Order.Order;

public class DateCompletedSort implements Comparator<Order>{
    public int compare(Order o1, Order o2){
        return o1.getDateCompleted().compareTo(o2.getDateCompleted());
    }

}
