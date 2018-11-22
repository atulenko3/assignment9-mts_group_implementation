package com.company;

import javafx.util.Pair;

import java.util.ArrayList;

public class Route {
    private String routeId;
    private String routeName;
    private int routeNumber;
    private ArrayList<Stop> stops;

    public Route(String routeId, String routeName, int routeNumber)
    {
        this.routeId = routeId;
        this.routeName = routeName;
        this.routeNumber = routeNumber;
        this.stops = new ArrayList<>();
    }

    public void extendRoute(Stop stop)
    {
        this.stops.add(stop);
    }

    public Pair<Integer, Stop> getNextStop(int currentStop)
    {
        if (currentStop < stops.size() - 1)
        {
            currentStop++;
            return new Pair<>(currentStop, stops.get(currentStop));
        }

        currentStop = 0;
        return new Pair<>(currentStop, stops.get(currentStop));
    }

    public int timeToNextStop(int currentStopIndex, int speed)
    {
        Stop currentStop = stops.get(currentStopIndex);

        Stop nextStop = (currentStopIndex >= stops.size() - 1) ? stops.get(0) : stops.get(currentStopIndex + 1);

        double distance = 70.0 * (Math.sqrt(Math.pow(currentStop.getLatitude() - nextStop.getLatitude(), 2) + Math.pow(currentStop.getLongitude() - nextStop.getLongitude(), 2)));
        return 1 + ((int)distance * 60 / speed);
    }

    public Stop getStopForIndex(int index)
    {
        return stops.get(index);
    }
}
