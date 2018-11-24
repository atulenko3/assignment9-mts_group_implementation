package edu.gatech.groupImplementation;

public class Event {
	private Integer rank;
	private String type;
	private Integer busId;
	
	public Event(int rank, String eventType, int id) {
		this.rank = Integer.valueOf(rank);
		type = eventType;
		busId = Integer.valueOf(id);
	}
	
	public Integer getRank() {
		return rank.intValue();
	}

	public void setRank(int rank) {
		this.rank = Integer.valueOf(rank);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return busId.intValue();
	}

	public void setId(int id) {
		this.busId = Integer.valueOf(id);
	}

	@Override
	public String toString() {
		return "Event [rank=" + rank + ", type=" + type + ", busId=" + busId + "]";
	}
}
