package com.agil8.luber.bdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.agil8.luber.tdd.Customer;
import com.agil8.luber.tdd.Location;
import com.agil8.luber.tdd.Trip;

public class LuberApi {
	private Map<String, Driver> drivers = new HashMap<String, Driver>();
	private Map<String, Customer> customers = new HashMap<String, Customer>();
	private List<Trip> schedule = new ArrayList<Trip>();

	public LuberApi() {
	}

	public Map<String, Driver> getDrivers() {
		return drivers;
	}

	public void addDriver(String driverName) {
		getDrivers().put(driverName, new Driver(driverName, true));
	}

	public void addUnavailableDriver(String driverName) {
		getDrivers().put(driverName, new Driver(driverName, false));
	}

	public List<Driver> getAvailableDrivers(Location customerLocation) {
		List<Driver> availDrivers = new ArrayList<Driver>();
		for (Driver driver : drivers.values()) {
			if (driver.isAvailable() && driver.getLocation().distanceInMiles(customerLocation) < 5.0)
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

	public boolean createTrip(String customer, String driver, Location from, Location to) {
		try {
			Trip newTrip = new Trip(customers.get(customer), from, to);
			newTrip.setDriver(drivers.get(driver));
			schedule.add(newTrip);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	
	public List<Trip> getSchedule() {
		return this.schedule;
	}
}