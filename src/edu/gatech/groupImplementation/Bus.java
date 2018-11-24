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
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = Integer.valueOf(id);
	}

	public Integer getRoute() {
		return route;
	}

	public void setRoute(Integer route) {
		this.route = Integer.valueOf(route);
	}

	public Integer getNextLocation() {
		return nextLocation;
	}

	public Integer getCurrentLocation() {
		return currentLocation;
	}

	public void setLocation(int newLocation) {
		currentLocation = nextLocation;
		nextLocation = Integer.valueOf(newLocation);
	}

	public Integer getPassengers() {
		return passengers;
	}

	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}

	public Integer getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(Integer passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public Integer getAverageSpeed() {
		return Integer.valueOf(averageSpeed);
	}

	public void setAverageSpeed(Integer averageSpeed) {
		this.averageSpeed = averageSpeed;
	}
	
	public Integer getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Integer arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public void updateRoute(int routeId, int locationWithinRoute) {
		route = Integer.valueOf(routeId);
		currentLocation = Integer.valueOf(locationWithinRoute);
	}

	@Override
	public String toString() {
		return "Bus [id= " + id + ", route = " + route + "]";
	}
}
