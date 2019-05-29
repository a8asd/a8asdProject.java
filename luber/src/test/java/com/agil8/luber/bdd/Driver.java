package com.agil8.luber.bdd;

public class Driver {

    private String email;
	private boolean available;

	Driver(String s, boolean available) {
		this.email = s;
		this.available = available;
	}

	public boolean isAvailable() {
		// TODO Auto-generated method stub
		return this.available;
	}

}
