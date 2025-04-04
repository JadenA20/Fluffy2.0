package BusinessLogic.Comparator;

import java.util.Comparator;

import BusinessLogic.Order.Customer;

public class LastNameSort implements Comparator<Customer>{
    public int compare(Customer c1, Customer c2){
        return c1.getLname().compareTo(c2.getLname());
        
    }
}