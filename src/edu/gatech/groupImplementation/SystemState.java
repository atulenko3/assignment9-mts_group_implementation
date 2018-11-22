package edu.gatech.groupImplementation;

import java.util.PriorityQueue;

public class SystemState {
		private Bus bus;
		private Stop stop; 
		private Route route; // unsure if we need to track the route, since the bus knows it as well as the location it was on the route
		private PriorityQueue<Event> queueSnapshot;
		
		public SystemState(Bus bus, Stop stop, PriorityQueue<Event> queue) {
			this.bus = bus;
			this.stop = stop;
			queueSnapshot = queue;
		}
		
}
