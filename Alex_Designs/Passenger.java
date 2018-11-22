package com.company;

public class Passenger {
    private String destinationStop;
    private String busRouteId;

    public Passenger()
    {

    }

    public Passenger(String destinationStop, String busRouteId)
    {
        this.destinationStop = destinationStop;
        this.busRouteId = busRouteId;
    }
}
