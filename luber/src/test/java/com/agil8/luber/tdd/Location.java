package com.agil8.luber.tdd;

public class Location {
	private double longitude;
	private double latitude;

	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double distance(Location otherLocation) {
		double latDiff = this.latitude - otherLocation.getLatitude();
		double lonDiff = this.longitude - otherLocation.getLongitude();
		return Math.sqrt((latDiff * latDiff) + (lonDiff * lonDiff));
	}
}