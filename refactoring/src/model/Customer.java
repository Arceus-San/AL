package model;
import java.util.*;

public class Customer {

	private String _name;
    private Vector _rentals = new Vector();
    
    public Customer(String name){
    	_name=name;
    }
    
    public void addRental(Rental rental){
    	_rentals.addElement(rental);
    }
    
    public String getName(){
    	return _name;
    }
    
    public String statement(){
		Enumeration rentals=_rentals.elements();
		String result = "Rental Record for "+getName()+"\n";
		while (rentals.hasMoreElements()){
			double thisAmount=0; 
			Rental each=(Rental) rentals.nextElement();
			thisAmount=getPrice(each);
			result +="\t" + each.getMovie().getTitle()+"\t"+
			    String.valueOf(thisAmount) +" \n";
		    }
		result += "Amount owned is " + String.valueOf(getTotalPrice(_rentals.elements())) +
		    "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoint(_rentals.elements())) +
		    " frequent renter points";
		return result;
	 
    }
    
    public double computePrice(int days, double priceF, double priceHF, int daysForfait) {
    	double thisAmount=0;
		thisAmount+=priceF;
		if (days>daysForfait){
			thisAmount+=(days-daysForfait)*priceHF;
		}
		return thisAmount;
    }

	public double getPrice(Rental rental) {
    	double thisAmount=0;
    	switch (rental.getMovie().getPriceCode()){
		
	    case Movie.REGULAR:
	    	thisAmount=computePrice(rental.getDaysRented(),2,1.5,2);
	    	break;
		
	    case Movie.NEW_RELEASE:
	    	thisAmount=computePrice(rental.getDaysRented(),0,3,0);
	    	break;
		
	    case Movie.CHILDRENS:
	    	thisAmount=computePrice(rental.getDaysRented(),1.5,1.5,3);
	    	break;
    	}
    	return thisAmount;
    	
    } 
    
    public double getTotalPrice(Enumeration allRentals) {
    	double thisAmount=0;
    	while (allRentals.hasMoreElements()){
    		Rental each=(Rental) allRentals.nextElement();
    		thisAmount+=getPrice(each);
    	}
    	return thisAmount;
    }
    
    public int getFrequentRenterPoints(Rental rental, int daysRenterPoints) {
    	int frequentRenterPoints = 0;
    	frequentRenterPoints++;
    	if( (rental.getMovie().getPriceCode()== Movie.NEW_RELEASE) && (rental.getDaysRented()>daysRenterPoints)) { 
 			    frequentRenterPoints++;
    	}
    	return frequentRenterPoints;
    }
    
    public int getTotalFrequentRenterPoint(Enumeration allRentals) {
    	int frequentRenterPoints = 0;
    	while (allRentals.hasMoreElements()){
    		Rental each=(Rental) allRentals.nextElement();
    		frequentRenterPoints+=getFrequentRenterPoints(each,1);
    	}
    	return frequentRenterPoints;
    }
	
}
