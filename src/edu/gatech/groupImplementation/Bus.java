package edu.gatech.groupImplementation;

public class Bus {
	private Integer id;
	private Integer route;
	private Integer nextLocation;
	private Integer currentLocation;
	private Integer passengers = 0;
	private Integer passengerCapacity;
	private Integer averageSpeed;
	private Integer arrivalTime;
	
	public Bus (int uniqueId,int routeId, int location, int initialCapacity, int speed) {
		id = Integer.valueOf(uniqueId);
		route = Integer.valueOf(routeId);
		nextLocation = currentLocation = Integer.valueOf(location);
		averageSpeed = Integer.valueOf(speed);	
		}
	
	@Override
	public String toString() {
		return "Bus [id= " + id + ", route = " + route + "]";
	}
}
