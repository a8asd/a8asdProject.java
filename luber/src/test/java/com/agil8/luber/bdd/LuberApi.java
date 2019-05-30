package com.agil8.luber.bdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.agil8.luber.tdd.Customer;
import com.agil8.luber.tdd.Location;

public class LuberApi {
	private List<Driver> drivers;
	private Map<String, Customer> customers = new HashMap<String,Customer>();
	public LuberApi(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}
	
	public void addDriver(String driverName) {
		getDrivers().add(new Driver(driverName, true));
	}

	public void addUnavailableDriver(String driverName) {
		getDrivers().add(new Driver(driverName, false));
	}

	public List<Driver> getAvailableDrivers(Location customerLocation) {
		List<Driver> availDrivers = new ArrayList<Driver>();
		for(Driver driver:drivers)
		{
        	if (driver.isAvailable() && driver.getLocation().distanceInMiles(customerLocation) < 5.0 ) 
        		availDrivers.add(driver);
        }
	
		return availDrivers;
	}

	public Customer findCustomerByEmail(String someone) {
		return customers.get(someone);
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getEmail(), customer);
		
	}
}