package edu.gatech.groupImplementation;

import java.util.PriorityQueue;

public class SystemState {
		private Bus bus;
		private Stop stop;
		private PriorityQueue<Event> queueSnapshot;
		
		public SystemState(Bus bus, Stop stop, PriorityQueue<Event> queue) {
			this.bus = bus;
			this.stop = stop;
			this.queueSnapshot = queue;
		}

		public Bus getBus() {
			return this.bus;
		}

		public Stop getStop() {
			return this.stop;
		}

		public PriorityQueue<Event> getQueueSnapshot() {
			return this.queueSnapshot;
		}
		
}
