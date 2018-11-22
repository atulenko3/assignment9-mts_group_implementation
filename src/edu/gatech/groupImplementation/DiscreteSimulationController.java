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
}
