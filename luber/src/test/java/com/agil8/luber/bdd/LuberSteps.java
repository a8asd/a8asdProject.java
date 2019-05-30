package com.agil8.luber.bdd;

import java.util.ArrayList;

import com.agil8.luber.tdd.Location;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LuberSteps {
	private LuberApi api = new LuberApi(new ArrayList<Driver>());
	private Location custLocation;

	@Given("^(.*) is a driver$")
	public void someone_is_a_driver(String driverName) {
		api.addDriver(driverName);
	}

	@Given("^(.*) is an unavailable driver$")
	public void someone_is_an_unavailable_driver(String driverName) {
		api.addUnavailableDriver(driverName);
	}

	@Given("^(.*) is a driver at (\\-?\\d+\\.\\d+),(\\-?\\d+\\.\\d+)$")
	public void someone_is_a_driver_at_location(String driverName, double x, double y) {
		api.getDrivers().add(new Driver(driverName, true, x, y));
	}

	@Given("^(.*) is a customer$")
	public void someone_is_a_customer(String someone) {
		custLocation = new Location(0, 0);		
	}

	@Given("^(.*) is a customer at (\\-?\\d+\\.\\d+),(\\-?\\d+\\.\\d+)$")
	public void someone_is_a_customer_at_location(String someone, double x, double y) {
		custLocation = new Location(x, y);
	}

	@When("^Tony requests a taxi$")
	public void someone_requests_a_taxi() {
	}

	@Then("^Tony sees these drivers available$")
	public void whoever_sees_these_drivers_available(DataTable table) {
		table.diff(api.getAvailableDrivers(custLocation));
	}
}
