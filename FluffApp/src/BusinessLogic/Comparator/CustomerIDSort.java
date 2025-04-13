package BusinessLogic.Comparator;

import java.util.Comparator;

import BusinessLogic.Order.Customer;

public class CustomerIDSort implements Comparator<Customer>{
    public int compare(Customer c1, Customer c2){
        return new Integer(c1.getID()).compareTo(new Integer(c2.getID()));
        
    }

}
