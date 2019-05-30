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
//		double latDiff = (this.latitude - otherLocation.getLatitude()) * 69;
//		double lonDiff = (this.longitude - otherLocation.getLongitude()) * 55;
//		return Math.sqrt((latDiff * latDiff) + (lonDiff * lonDiff));
		double theta = this.longitude - otherLocation.getLongitude();
		double dist = Math.sin(deg2rad(this.latitude)) * Math.sin(deg2rad(otherLocation.getLatitude()))
				+ Math.cos(deg2rad(this.latitude)) * Math.cos(deg2rad(otherLocation.getLatitude()))
						* Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		return dist;
	}

	private double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

}