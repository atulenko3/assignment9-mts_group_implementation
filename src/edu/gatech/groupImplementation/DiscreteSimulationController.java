package edu.gatech.groupImplementation;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DiscreteSimulationController {
	private Double kWaiting = 1.0;
	private Double kBuses = 1.0;
	private Double kCapacity = 1.0;
	private Double kSpeed = 1.0;
	private Double kCombined = 1.0;
	private static PriorityQueue<Event> eventQueue;
	private Comparator<Event> eventComparator;
	private HashMap<Integer,Route> routes;
	private HashMap<Integer,Bus> buses;
	private HashMap<Integer,Stop> stops;
	private HashMap<Integer,SystemState> systemStates;
	
	public DiscreteSimulationController() {
		routes = new HashMap<Integer,Route>();
		buses = new HashMap<Integer,Bus>();
		stops = new HashMap<Integer,Stop>();
		systemStates = new HashMap<Integer,SystemState>();
		eventComparator = new EventComparator();
		eventQueue = new PriorityQueue<Event>(100, eventComparator);
		
	}
	public void makeStop(int uniqueId,String name, int riders, double latitude, double longitude) {
		stops.put(uniqueId, new Stop(uniqueId, name, riders, latitude, longitude));
		};
		
	// This method allows us to set the probabilities for each stop currently available in the system (based on the first setup file)
	public void addProbabilities(int stopId,int ridersArriveHigh, int ridersArriveLow, int ridersOffHigh, int ridersOffLow, int ridersOnHigh, int ridersOnLow,
			int ridersDepartHigh, int ridersDepartLow) {
		if (stops.containsKey(Integer.valueOf(stopId))) {
			stops.get(Integer.valueOf(stopId)).setProbabilities(ridersArriveHigh,ridersArriveLow,ridersOffHigh,ridersOffLow,ridersOnHigh,ridersOnLow,ridersDepartHigh,ridersDepartLow);
		} System.out.println("StopId:" + stopId + ", does not exist in the current system - ignoring command"); //If the stop doesnt exist, will print the console
	}
		
	public void makeRoute(int uniqueId, int number, String name) {
		routes.put(uniqueId, new Route(uniqueId, number, name));
	};
	
	public void makeBus(int uniqueId,int routeId, int location, int initialCapacity, int speed) {
		buses.put(uniqueId, new Bus(uniqueId, routeId, location, initialCapacity, speed));
	};
	
	public void addStopToRoute(int routeId, int stopId) {
		(routes.get(routeId)).extendRoute(stopId);
	}
	
	public void addEvent(int rank, String type, int busId) {
		eventQueue.add(new Event(rank,type,busId));
	}
	
	public void triggerNextEvent() {
		if (eventQueue.size() > 0) {
			Event activeEvent = eventQueue.poll();
			switch (activeEvent.getType()) {
			case "move_bus":
				Bus activeBus = getBus(activeEvent.getId()); //Returns the bus that needs to be moved based on the activeEvent ID
				
				Route activeRoute = getRoute(activeBus.getRoute()); //Returns the activeRoute the bus is on based on the route attribute of the bus object
				
				int activeLocation = activeBus.getCurrentLocation(); //Returns the current location of the bus along the route
				
				int activeStopId = activeRoute.getCurrentStop(activeLocation); //Based on the activeLocation on the route get the activeStopId
				Stop activeStop = getStop(activeStopId); //Returns the stop object identified by activeStopId
				
				//TODO Passenger Management
				
				int nextLocation = activeRoute.getNextLocation(activeLocation); //Based on the activeLocation, returns the nextLocation's position on the route
				int nextStopId = activeRoute.getCurrentStop(nextLocation); //Based on the nextLocation on the route get the activeStopId
				Stop nextStop = getStop(nextStopId); //Returns the stop object identified by nextStopId
				
				Double distanceBetweenStops = activeStop.findDistance(nextStop); //Calculates the distance between the activeStop and the nextStop
				int travelTime = 1 + (distanceBetweenStops.intValue() * 60) / activeBus.getAverageSpeed(); //Returns the travel time between stops 
				activeBus.setLocation(nextLocation); //"Moves" the bus to the next location on the route
				int nextArrivalTime = activeEvent.getRank() + travelTime; //Returns the logical time at which the bus will arrive at its next stop
				activeBus.setArrivalTime(nextArrivalTime); //Updates the arrivalTime attribute of the bus object
				eventQueue.add(new Event(nextArrivalTime, "move_bus", activeEvent.getId())); //Queue the next event for this bus that is to occur at the previously calculated logical time
				
				System.out.println("b:" + activeBus.getId() + "->s:" + nextStopId + "@" + activeBus.getArrivalTime() + "//p:0/f:0"); //Output summary to console for each event
				break;
			default:
				System.out.println("This is not valid event");
			}
		}
		else {
			System.out.println("The queue is empty");
		}	
	}
	
	public Stop getStop(int stopID) {
	    if (stops.containsKey(Integer.valueOf(stopID))) return stops.get(Integer.valueOf(stopID));
	    return null;
	  }
	  
	public Route getRoute(int routeID) {
	    if (routes.containsKey(Integer.valueOf(routeID))) return routes.get(Integer.valueOf(routeID));
	    return null;
	  }
	  
	public Bus getBus(int busID) {
	    if (buses.containsKey(Integer.valueOf(busID))) return buses.get(Integer.valueOf(busID));
	    return null;
	  }

	public Double getKWaiting() {
		return kWaiting;
	}
	
	public void setKWaiting(double kWaiting) {
		this.kWaiting = Double.valueOf(kWaiting);
	}
	
	public Double getkBuses() {
		return kBuses;
	}
	
	public void setkBuses(double kBuses) {
		this.kBuses = Double.valueOf(kBuses);
	}
	
	public Double getkCapacity() {
		return kCapacity;
	}
	
	public void setkCapacity(double kCapacity) {
		this.kCapacity = Double.valueOf(kCapacity);
	}
	
	public Double getkSpeed() {
		return kSpeed;
	}
	
	public void setkSpeed(double kSpeed) {
		this.kSpeed = Double.valueOf(kSpeed);
	}
	
	public Double getkCombined() {
		return kCombined;
	}
	
	public void setkCombined(double kCombined) {
		this.kCombined = Double.valueOf(kCombined);
	}
	
	public Integer waitingPassengers() {
		Integer totalPassengers = 0;
		for (Stop stop: stops.values()) {
			totalPassengers =+ stop.getWaitingPassengers();
		}
		return totalPassengers;
	}
	
	public Double busCost() {
		Double busCost = Double.valueOf(0.0);
		for (Bus bus: buses.values()) {
			busCost =+ (Double.valueOf(kSpeed) * bus.getAverageSpeed().doubleValue() + Double.valueOf(kCapacity) * bus.getPassengerCapacity().doubleValue());
		}
		return busCost;
	}
	
	public Double getSystemEfficiency() {
		return Double.valueOf(Double.valueOf(kWaiting) * waitingPassengers().doubleValue() + Double.valueOf(kBuses) * Double.valueOf(busCost()) + 
				Double.valueOf(kCombined) * waitingPassengers().doubleValue() * Double.valueOf(busCost()));
	}
}
