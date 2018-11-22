package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Random;

public class Bus {
    private Route route;
    private ArrayList<Passenger> passengers;
    private Stop currentStop;
    private double maxFuel;
    private double currentFuel;
    private int speed;
    private int maxPassengerCapacity;
    private int currentPassengerCapacity;
    private String busId;
    private int routeIndex;
    private Random rand;

    public Bus(String busId, Route route, int routeIndex, int initialPassengers, int maxPassengerCapacity, double currentFuel, double maxFuel, int speed)
    {
        this.busId = busId;
        this.route = route;
        this.routeIndex = routeIndex;
        this.maxPassengerCapacity = maxPassengerCapacity;
        this.currentFuel = currentFuel;
        this.maxFuel = maxFuel;
        this.speed = speed;
        for (int i = 0; i < initialPassengers; i++)
        {
            //Can extended with more logic if we want better passenger logic
            passengers.add(new Passenger());
        }
        this.currentPassengerCapacity = initialPassengers;
        rand = new Random();
    }

    /*
    Future function to implement
     */
    private void removePassengersForStop()
    {
     //   int numToRemove = rand.nextInt() % this.passengers.size();
      //  this.passengers.subList(0, numToRemove).clear();
    }

    /*
    Future function to implement
     */
    private void addPassengersForStop(Stop stop)
    {
       // int availableRoom = maxPassengerCapacity - currentPassengerCapacity;

    }

    public int moveToNextStop(int startTime)
    {
        int time = this.route.timeToNextStop(this.routeIndex, this.speed);
        this.currentStop = this.route.getStopForIndex(this.routeIndex);

        Pair<Integer, Stop> routeInfo = route.getNextStop(this.routeIndex);
        this.routeIndex = routeInfo.getKey();
        this.currentStop = routeInfo.getValue();

        this.removePassengersForStop();
        this.addPassengersForStop(this.currentStop);

        System.out.println("b:" + this.busId + "->s:" + this.currentStop.getStopId() + "@" + (startTime + time) + "//p:"+this.currentPassengerCapacity+"/f:0"); //+this.currentFuel);

        return time;
    }

    public String BusInfo()
    {
        return this.busId;
    }
}
