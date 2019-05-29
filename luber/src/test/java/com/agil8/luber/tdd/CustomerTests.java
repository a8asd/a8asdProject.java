package com.agil8.luber.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTests {

	@Test
	public void constructorTest()
	{
		Customer customer = new Customer("tony@test.com");
		assertEquals("tony@test.com", customer.getEmail());
	}
}
