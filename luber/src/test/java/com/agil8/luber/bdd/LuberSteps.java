package com.agil8.luber.bdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LuberSteps {
	private List<Driver> drivers = new ArrayList<Driver>();

	@Given("^(.*) is a driver$")
	public void someone_is_a_driver(String driverName) {
		drivers.add(new Driver(driverName, true));
	}

	@Given("^(.*) is an unavailable driver$")
	public void someone_is_an_unavailable_driver(String driverName) {
		drivers.add(new Driver(driverName, false));
	}

	@Given("^tony@test\\.com is a customer$")
	public void someone_is_a_customer() {
	}

	@When("^Tony requests a taxi$")
	public void someone_requests_a_taxi() {
	}

	@Then("^Tony sees these drivers available$")
	public void whoever_sees_these_drivers_available(DataTable table) {
		List<Driver> availDrivers = new ArrayList<Driver>();
        Iterator<Driver> iter = drivers.iterator();
        while (iter.hasNext()) {
        	Driver d = iter.next();
        	if (d.isAvailable()) availDrivers.add(d);
        }
		table.diff(availDrivers);
	}
}
