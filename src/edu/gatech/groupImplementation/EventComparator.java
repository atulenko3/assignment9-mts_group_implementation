package edu.gatech.groupImplementation;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {
	public EventComparator() {};
	
	public int compare (Event x, Event y) {
		if (y == null) return -1;
		if (x == null) return 1;
		return x.getRank() - y.getRank();
	}
}
