package model;

import static org.junit.Assert.*;

import org.junit.*;

public class MainTest {
	
	private Customers client;
	
	@Before
	public void start() {
		Movie ro = new Movie("Rogue One",1);
		Movie frozen = new Movie("Reine des neiges",2);
		Movie sw3 = new Movie("Star Wars III",0);
		
		client = new Customers("Patrick");
		
		Rental r1 = new Rental(ro,5);
		Rental r2 = new Rental(frozen,7);
		Rental r3 = new Rental(sw3,4);
		
		client.addRental(r1);
		client.addRental(r2);
		client.addRental(r3);
	}

	@Test
	public void test() {
		assertEquals("Rental Record for Patrick\n" + 
				"	Rogue One	15.0 \n" + 
				"	Reine des neiges	7.5 \n" + 
				"	Star Wars III	5.0 \n" + 
				"Amount owned is 27.5\n" + 
				"You earned 4 frequent renter points",
				
				client.statement());
	}

}
