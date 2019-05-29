package com.agil8.luber.tdd;

import static org.junit.Assert.assertEquals;

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
	public void distanceInMiles()
	{
		Location otherLocation = new Location(51.412505, -1.422734);
		Location location = new Location(51.392769, -1.240040);
		assertEquals(8.00, location.distanceInMiles(otherLocation), 0.1);
	}
	
	@Test
	public void tonyDistanceTest1()
	{
		Location thatchamCentre = new Location(51.4058, -1.2665);
		Location thatchamHQ = new Location(51.397487, -1.227136);
		assertEquals(2.00, thatchamCentre.distanceInMiles(thatchamHQ), 1);
	}
	
	@Test
	public void tonyDistanceTest2()
	{
		Location newburyCentre = new Location(51.4014, -1.3231);
		Location readingCentre = new Location(51.4543, -0.9781);
		assertEquals(15, newburyCentre.distanceInMiles(readingCentre), 1);
	}
}
