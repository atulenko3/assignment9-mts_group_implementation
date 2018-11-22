package edu.gatech.groupImplementation;

public class Stop {
	private Integer id;
	private String name;
	private Integer riders;
	private Double latitude;
	private Double longitude;
	private Integer ridersArriveHigh;
	private Integer ridersArriveLow;
	private Integer ridersOffHigh;
	private Integer ridersOffLow;
	private Integer ridersOnHigh;
	private Integer ridersOnLow;
	private Integer ridersDepartHigh;
	private Integer ridersDepartLow;
	private Integer waitingPassengers;
	private Integer transferRiders = 0; 
	
	public Stop (int uniqueId,String name,int initialRiders, double latitude, double longitude) {
		id = Integer.valueOf(uniqueId);
		this.name = name;
		riders = Integer.valueOf(initialRiders);
		this.latitude = Double.valueOf(latitude);
		this.longitude = Double.valueOf(longitude);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRiders() {
		return riders;
	}

	public void setRiders(Integer riders) {
		this.riders = riders;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Integer getRidersArriveHigh() {
		return ridersArriveHigh;
	}

	public void setRidersArriveHigh(Integer ridersArriveHigh) {
		this.ridersArriveHigh = ridersArriveHigh;
	}

	public Integer getRidersArriveLow() {
		return ridersArriveLow;
	}

	public void setRidersArriveLow(Integer ridersArriveLow) {
		this.ridersArriveLow = ridersArriveLow;
	}

	public Integer getRidersDepartHigh() {
		return ridersDepartHigh;
	}

	public void setRidersDepartHigh(Integer ridersDepartHigh) {
		this.ridersDepartHigh = ridersDepartHigh;
	}

	public Integer getRidersDepartLow() {
		return ridersDepartLow;
	}

	public void setRidersDepartLow(Integer ridersDepartLow) {
		this.ridersDepartLow = ridersDepartLow;
	}

	public Integer getRidersOnHigh() {
		return ridersOnHigh;
	}

	public void setRidersOnHigh(Integer ridersOnHigh) {
		this.ridersOnHigh = ridersOnHigh;
	}

	public Integer getRidersOnLow() {
		return ridersOnLow;
	}

	public void setRidersOnLow(Integer ridersOnLow) {
		this.ridersOnLow = ridersOnLow;
	}
	
	public Integer getRidersOffHigh() {
		return ridersOffHigh;
	}

	public void setRidersOffHigh(Integer ridersOffHigh) {
		this.ridersOffHigh = ridersOffHigh;
	}
	
	public Integer getRidersOffLow(){
		return ridersOffLow;
	}
	
	public void setRidersOffLow(Integer ridersOffLow) {
		this.ridersOffLow = ridersOffLow;
	}
	
	public Integer getWaitingPassengers() {
		return waitingPassengers;
	}

	public void setWaitingPassengers(Integer waitingPassengers) {
		this.waitingPassengers = waitingPassengers;
	}

	public Integer getTransferRiders() {
		return transferRiders;
	}

	public void setTransferRiders(Integer transferRiders) {
		this.transferRiders = transferRiders;
	}

	@Override
	public String toString() {
		return "Stop [ id= " + id + ",name= " + name + "]";
	}
}
