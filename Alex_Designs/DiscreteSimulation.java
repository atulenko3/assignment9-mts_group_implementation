package com.company;

import javafx.util.Pair;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.lang.Exception;

public class DiscreteSimulation {
    private PriorityQueue<Event> eventQueue;
    private HashMap<String, Route> routes;
    private HashMap<String, Bus> buses;
    private HashMap<String, Stop> stops;

    private final String ADD_DEPOT = "add_depot";
    private final String ADD_STOP = "add_stop";
    private final String ADD_ROUTE = "add_route";
    private final String ADD_BUS = "add_bus";
    private final String ADD_EVENT = "add_event";
    private final String ADD_MOVE_BUS_EVENT = "move_bus";
    private final String EXTEND_ROUTE = "extend_route";

    public DiscreteSimulation()
    {
        this.eventQueue = new PriorityQueue<>(10, new EventComparator());
        this.routes = new HashMap<>();
        this.buses = new HashMap<>();
        this.stops = new HashMap<>();
    }

    public void printSimulationState()
    {
        Iterator it = this.buses.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            it.remove();
        }

        Iterator it2 = this.routes.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry pair = (Map.Entry)it2.next();
            it2.remove();
        }
    }


    public void processSimulationSetup(String fileLocation)
    {
        try {
            File file = new File(fileLocation);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] input = line.split(",");
                if (!processInputLine(input))
                {
                    System.out.println("Incorrect Input: " + Arrays.toString(input));
                    throw new Exception("Incorrect Input!");
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception");
        }
    }

    private boolean processInputLine(String[] input)
    {
        String command = input[0];
        switch (command) {
            case ADD_DEPOT:
                return addDepot();
            case ADD_STOP:
                if (input.length != 6)
                    return false;
                return addStop(input[1], input[2], Integer.parseInt(input[3]), Double.parseDouble(input[4]), Double.parseDouble(input[5]));
            case ADD_ROUTE:
                if (input.length != 4)
                    return false;
                return addRoute(input[1], input[3], Integer.parseInt(input[2]));
            case ADD_BUS:
                if (input.length != 9)
                    return false;
                return addBus(input[1], input[2], Integer.parseInt(input[3]), Integer.parseInt(input[4]), Integer.parseInt(input[5]), Double.parseDouble(input[6]), Double.parseDouble(input[7]), Integer.parseInt(input[8]));
            case ADD_EVENT:
                if (input.length != 4)
                    return false;

                //Needs to be extended if new events added
                if (input[2].equals(ADD_MOVE_BUS_EVENT))
                    return addMoveBusEvent(Integer.parseInt(input[1]), input[3]);
                else
                    return false;
            case EXTEND_ROUTE:
                if (input.length != 3)
                    return false;
                return extendRoute(input[1], input[2]);
            default:
                return false;

        }
    }

    public void processNextEvent()
    {
        if (this.eventQueue.peek() == null)
            return;

        Event e = eventQueue.poll();
        ArrayList<Event> nextEvents = e.executeEvent();

        this.eventQueue.addAll(nextEvents);
    }

    private boolean addMoveBusEvent(int time, String busId)
    {
        if (!this.buses.containsKey(busId))
            return false;

        Event e = new MoveBusEvent(this.buses.get(busId), time);
        this.eventQueue.add(e);
        return true;
    }

    //ToDo
    private boolean addDepot()
    {
        return true;
    }

    private boolean addBus(String busId, String routeId, int location, int initialPassengers, int passengerCapacity, double initialFuel, double maxFuel, int speed)
    {
        if (this.buses.containsKey(busId) || !this.routes.containsKey(routeId))
            return false;

        Bus bus = new Bus(busId, this.routes.get(routeId), location, initialPassengers, passengerCapacity, initialFuel, maxFuel, speed);
        this.buses.put(busId, bus);
        return true;
    }

    private boolean addRoute(String routeId, String routeName, int routeNumber)
    {
        if (this.routes.containsKey(routeId))
            return false;


        Route newRoute = new Route(routeId, routeName, routeNumber);
        this.routes.put(routeId, newRoute);
        return true;
    }

    private boolean addStop(String stopId, String stopName, int initialRiders, double latitude, double longitude)
    {
        if (this.stops.containsKey(stopId))
            return false;

        Stop stop = new Stop(stopId, stopName, latitude, longitude, initialRiders);
        this.stops.put(stopId, stop);
        return true;
    }

    private boolean extendRoute(String routeId, String stopId)
    {
        if(!this.routes.containsKey(routeId) || !this.stops.containsKey(stopId))
            return false;

        Route route = this.routes.get(routeId);
        Stop stop = this.stops.get(stopId);

        route.extendRoute(stop);

        return true;
    }




}
