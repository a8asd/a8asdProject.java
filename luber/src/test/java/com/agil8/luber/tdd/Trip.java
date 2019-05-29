package com.agil8.luber.tdd;

import com.agil8.luber.bdd.Driver;

public class Trip {

	Customer customer;
	Driver driver;
	Location tripFrom;
	Location tripTo;
	
	Trip (Customer c, Location f, Location t)
	{
		this.customer=c;
		this.tripFrom=f;
		this.tripTo=t;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Location getTripFrom() {
		return tripFrom;
	}

	public void setTripFrom(Location tripFrom) {
		this.tripFrom = tripFrom;
	}

	public Location getTripTo() {
		return tripTo;
	}

	public void setTripTo(Location tripTo) {
		this.tripTo = tripTo;
	}
	

}
