package com.agil8.luber.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TripTests {

	@Test
	public void DummyTest()
	{
		//fail();
	}
	
	@Test
	public void constructor()
	{
		// Check assignment of Trip Source
		Location start = new Location(1.23,2.34);
		Location end = new Location(3.45,4.556);
		Customer c = new Customer("fred@test.com");
		Trip testTrip = new Trip(c,start,end);
		assertEquals(1.23,testTrip.getTripFrom().getLatitude(),.01);
		assertEquals(2.34,testTrip.getTripFrom().getLongitude(),.01);
		assertEquals(3.45,testTrip.getTripTo().getLatitude(),.01);
		assertEquals(4.56,testTrip.getTripTo().getLongitude(),.01);
	}

}
