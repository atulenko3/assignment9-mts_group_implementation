package com.company;

import java.util.ArrayList;

public class Stop {
    private String stopID;
    private String stopName;
    private double latitude;
    private double longitude;
    private int numRiders;
    private ArrayList<Passenger> passengers;

    public Stop(String stopId, String stopName, double latitude, double longitude, ArrayList<Passenger> passengers)
    {
        this.stopID = stopId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stopName = stopName;
        this.passengers = passengers;
    }

    public Stop(String stopId, String stopName, double latitude, double longitude, int numRiders)
    {
        this.stopID = stopId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stopName = stopName;
        this.numRiders = numRiders;
    }

    public double getLatitude()
    {
        return this.latitude;
    }

    public double getLongitude()
    {
        return this.longitude;
    }

    public String getStopId()
    {
        return this.stopID;
    }

    public void simulatePassengerArrival()
    {

    }
}
