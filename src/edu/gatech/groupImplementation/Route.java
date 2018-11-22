package edu.gatech.groupImplementation;

import java.util.HashMap;

public class Route {
	private Integer id;
	private Integer number;
	private String name;
	private HashMap<Integer, Integer> stops;
	
	public Route(int uniqueId, int number, String routeName) {
		id = Integer.valueOf(uniqueId);
		this.number = Integer.valueOf(number);
		name = routeName;
		stops = new HashMap<Integer,Integer>();	
		}

	public void extendRoute(int stopId) {
		stops.put(Integer.valueOf(stops.size()), Integer.valueOf(stopId));
	}
	
	public Integer getNextLocation(int routeLocation) {
	    int routeSize = stops.size() - 1;
	    if (routeSize > 0 && routeLocation != routeSize) {
	    	return Integer.valueOf(routeLocation % routeSize + 1);
	    } return Integer.valueOf(0);
	  }
	
	public Integer getCurrentStop(int currentLocation) {
		return stops.get(Integer.valueOf(currentLocation));
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + ", number=" + number + ", name=" + name + "]";
	}
}
