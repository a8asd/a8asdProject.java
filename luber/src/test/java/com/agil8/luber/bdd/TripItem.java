package com.agil8.luber.bdd;

import com.agil8.luber.tdd.Trip;

public class TripItem {
	private Trip trip;
	private String driver;
	private double fromLatitude;
	private double fromLongitude;
	private String customer;
	private double toLatitude;
	private double toLongitude;

	public TripItem(Trip trip)
	{
		this.trip = trip;
		this.customer = trip.getCustomer().getEmail();
		this.driver = trip.getDriver().getEmail();
		this.fromLatitude = trip.getTripFrom().getLatitude();
		this.fromLongitude = trip.getTripFrom().getLongitude();
		this.toLatitude = trip.getTripTo().getLatitude();
		this.toLongitude = trip.getTripTo().getLongitude();
	}
	
	public String getCustomer()
	{
		return this.trip.getCustomer().getEmail();
	}
	
	public String getDriver()
	{
		return this.trip.getDriver().getEmail();
	}
	
	public double getFromLatitude()
	{
		return this.trip.getTripFrom().getLatitude();
	}

	public double getFromLongitude()
	{
		return this.trip.getTripFrom().getLongitude();
	}

	
	public double getToLatitude()
	{
		return this.trip.getTripTo().getLatitude();
	}

	public double getToLongitude()
	{
		return this.trip.getTripTo().getLongitude();
	}

}
