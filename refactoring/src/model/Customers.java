package model;
import java.util.*;

@Deprecated public class Customers extends Customer
{
    private String _name;
    private Vector _rentals = new Vector();
    
    public Customers(String name){
    	super(name);
    }
    
}
 