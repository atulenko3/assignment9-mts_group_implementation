package edu.gatech.groupImplementation;

public class Bus {
	private Integer id;
	private Integer route;
	private Integer nextLocation;
	private Integer previousLocation;
	private Integer passengers = 0;
	private Integer passengerCapacity;
	private Integer averageSpeed;
	private Integer arrivalTime;
	private boolean busRouteUpdateRequested = false;
	private boolean busRouteUpdateRequestedTwice = false;
	private Integer routeUpdateId;
    private Integer routeUpdateStopIndex;
	private boolean busCapacityUpdateRequested = false;
	private boolean busCapacityUpdateRequestedTwice = false;
	private Integer busCapcityUpdate;

	
	public Bus (int uniqueId,int routeId, int location, int initialCapacity, int speed) {
		id = Integer.valueOf(uniqueId);
		route = Integer.valueOf(routeId);
		nextLocation = Integer.valueOf(location);
		previousLocation = Integer.valueOf(location);
		passengerCapacity = Integer.valueOf(initialCapacity);
		averageSpeed = Integer.valueOf(speed);
		}


    public Bus (Bus bus)
    {
        id = bus.getId();
        route = bus.getRoute();
        nextLocation = bus.getNextLocation();
        previousLocation = bus.getPreviousLocation();
        passengers = bus.getPassengers();
        passengerCapacity = bus.getPassengerCapacity();
        averageSpeed = bus.getAverageSpeed();
        arrivalTime = bus.getArrivalTime();
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

	public Integer getPreviousLocation() {
		return previousLocation;
	}

	public void setLocation(int newLocation) {
		previousLocation = nextLocation;
		nextLocation = Integer.valueOf(newLocation);
	}

	public Integer getPassengers() {
		return passengers;
	}

	public void setPassengers(Integer passengers) {
		this.passengers = passengers;
	}

	public Integer ridersOff(int ridersOff) {
		if (ridersOff <= this.passengers.intValue()) {
			passengers -= ridersOff;
			return Integer.valueOf(ridersOff);
		} else {
			int totalPassengers = this.passengers.intValue();
			passengers = 0;
			return Integer.valueOf(totalPassengers);
		}
	}

	public Integer ridersOn(int ridersOn) {
		if (ridersOn <= (passengerCapacity.intValue() - passengers.intValue())) {
			passengers += ridersOn;
			return ridersOn;
		} else {
			passengers = passengerCapacity;
			return (passengerCapacity.intValue() - passengers.intValue());
		}
		
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
		previousLocation = Integer.valueOf(locationWithinRoute);
	}

	public int updateBusCapacity(Integer newCapacity) {
		this.passengerCapacity = newCapacity;
		if (this.passengerCapacity < this.passengers) {
			int excessPassengers = this.passengers - this.passengerCapacity;
			this.passengers = this.passengerCapacity;
			return excessPassengers;
		}
		return 0;
	}

	public boolean getBusRouteUpdateRequested() {return busRouteUpdateRequested;}
    public void setBusRouteUpdateRequested(boolean busRouteUpdateRequested) {this.busRouteUpdateRequested = busRouteUpdateRequested;}

	public boolean getBusRouteUpdateRequestedTwice() {return busRouteUpdateRequestedTwice;}
	public void setBusRouteUpdateRequestedTwice(boolean busRouteUpdateRequestedTwice) {this.busRouteUpdateRequestedTwice = busRouteUpdateRequestedTwice;}

    public Integer getRouteUpdateId() {return routeUpdateId;}
    public void setRouteUpdateId(Integer routeUpdateId) {this.routeUpdateId = routeUpdateId;}

    public Integer getRouteUpdateStopIndex() {return routeUpdateStopIndex;}
    public void setRouteUpdateStopIndex(Integer routeUpdateStopIndex) {this.routeUpdateStopIndex = routeUpdateStopIndex;}

	public boolean getBusCapacityUpdateRequested() {return busCapacityUpdateRequested;}
	public void setBusCapacityUpdateRequested(boolean busCapacityUpdateRequested) {this.busCapacityUpdateRequested = busCapacityUpdateRequested;}

	public boolean getBusCapacityUpdateRequestedTwice() {return busCapacityUpdateRequestedTwice;}
	public void setBusCapacityUpdateRequestedTwice(boolean busCapacityUpdateRequestedTwice) {this.busCapacityUpdateRequestedTwice = busCapacityUpdateRequestedTwice;}

	public Integer getBusCapcityUpdate() {return busCapcityUpdate;}
	public void setBusCapcityUpdate(Integer busCapcityUpdate) {this.busCapcityUpdate = busCapcityUpdate;}

	@Override
	public String toString() {
		return "Bus [id= " + id + ", route = " + route + "]";
	}
}
