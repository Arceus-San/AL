package model;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie ro = new Movie("Rogue One",1);
		Movie frozen = new Movie("Reine des neiges",2);
		Movie sw3 = new Movie("Star Wars III",0);
		
		Customers client = new Customers("Patrick");
		
		Rental r1 = new Rental(ro,5);
		Rental r2 = new Rental(frozen,7);
		Rental r3 = new Rental(sw3,4);
		
		client.addRental(r1);
		client.addRental(r2);
		client.addRental(r3);
		
		System.out.println(client.statement());
		
		

	}

}
