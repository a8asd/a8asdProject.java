package com.agil8.luber.bdd;

import java.util.ArrayList;
import java.util.List;

import com.agil8.luber.tdd.Customer;
import com.agil8.luber.tdd.Location;
import com.agil8.luber.tdd.Trip;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LuberSteps {
	private LuberApi api = new LuberApi();
	private Location custLocation;
	private Location destLocation;

	private ArrayList<Trip> allTrips = new ArrayList<Trip>();
	private ArrayList<Trip> schedule = new ArrayList<Trip>();
	
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
		api.getDrivers().put(driverName, new Driver(driverName, true, x, y));
	}

	@Given("^(.*) is a customer$")
	public void someone_is_a_customer(String someone) {
		someone_is_a_customer_at_location(someone, 0, 0, 0, 0);		
	}

	@Given("^(.*) is a customer at (\\-?\\d+\\.\\d+),(\\-?\\d+\\.\\d+) travelling to (\\-?\\d+\\.\\d+),(\\-?\\d+\\.\\d+)$")
	public void someone_is_a_customer_at_location(String someone, double customerLatitude, double customerLongitude, double destinationLatitude, double destinationLongitude) {
		api.addCustomer(new Customer(someone));
		custLocation = new Location(customerLatitude, customerLongitude);
		destLocation = new Location(destinationLatitude, destinationLongitude);
	}

	@When("^(.*) requests a taxi$")
	public void someone_requests_a_taxi(String someone) {
		// Customer customer = api.findCustomerByEmail(someone);
	}

	@When("^tony@test\\.com accepts ayrton@test\\.com$")
	public void tony_test_com_accepts_ayrton_test_com() {
		api.createTrip("tony@test.com","ayrton@test.com",custLocation, destLocation);
	}

	@Then("^(.*) sees these drivers available$")
	public void whoever_sees_these_drivers_available(String whoever, DataTable table) {
		table.diff(api.getAvailableDrivers(custLocation));
	}


	@Then("^these trips are in the system$")
	public void these_trips_are_in_the_system(DataTable table) {
		List<TripItem> tripItems = new ArrayList<TripItem>();
		for(Trip trip:api.getSchedule())
		{
			tripItems.add(new TripItem(trip));
		}
		
		table.diff(tripItems);
	}

	
	
	
	@Given("^these trips are defined in the system$")
	public void these_trips_are_in_the_system() {
		Trip ayrtonTrip = new Trip(new Customer("tony@test.com"), new Location(0, 0), new Location(0, 0));
		ayrtonTrip.setDriver(new Driver("ayrton@test.com", true));
		Trip davidTrip = new Trip(new Customer("anyone@test.com"), new Location(0, 0), new Location(0, 0));
		davidTrip.setDriver(new Driver("david@test.com", true));

		allTrips.add(ayrtonTrip);
		allTrips.add(davidTrip);
	}

	@When("^ayrton@test\\.com views his schedule$")
	public void ayrton_test_com_views_his_schedule() {
		for(Trip currentTrip : allTrips)
		{
			if(currentTrip.getDriver().getEmail().equals("ayrton@test.com"))
			{
				schedule.add(currentTrip);
			}
		}
			}

	@Then("^ayrton@test\\.com sees these trips$")
	public void ayrton_test_com_sees_these_trips(DataTable table) {
		java.util.List<TripItem> tripitems = new ArrayList<TripItem>();
		for(Trip trip: schedule) {
			TripItem item = new TripItem(trip);
			tripitems.add(item);
		}
		table.diff(tripitems);
		
	}
}
