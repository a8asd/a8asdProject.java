package com.agil8.luber.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class LocationTests {

	@Test
	public void DummyTest()
	{
		//fail();
	}
	
	@Test
	public void constructor()
	{
		Location location = new Location(1.234,5.678);
		assertEquals(1.234, location.getLatitude(), 0.001);
		assertEquals(5.678, location.getLongitude(), 0.001);
	}
	
	@Test
	public void distance()
	{
		Location otherLocation = new Location(4,3);
		Location location = new Location(0,0);
		assertEquals(5.0, location.distance(otherLocation), 0.001);
	}
}
