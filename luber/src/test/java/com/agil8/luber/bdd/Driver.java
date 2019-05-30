package com.agil8.luber.bdd;

public class Driver {

    private String email;
	private boolean available;
	private double longtitude;
	private double latitude;

	Driver(String email, boolean available)
	{
		this(email, available, 0, 0);
	}
	
	Driver(String email, boolean available, double latitude, double longtitude) {
		this.email = email;
		this.available = available;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}

	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return this.available;
	}

}

