package com.agil8.luber.bdd;

import com.agil8.luber.tdd.Location;

public class Driver {

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	private String email;
	private boolean available;
	private Location location;

	Driver(String email, boolean available)
	{
		this(email, available, 0, 0);
	}
	
	public Driver(String email, boolean available, double latitude, double longitude) {
		this.email = email;
		this.available = available;
		setLocation(latitude, longitude);
	}

	public void setLocation(double latitude, double longitude) {
		this.setLocation(new Location(latitude, longitude));
	}

	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return this.available;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}

