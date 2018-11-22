package com.company;

import java.util.Comparator;

public class EventComparator implements Comparator<Event> {

    //If e1 time for event is less than e2's, it should be higher in the queue
    public int compare(Event e1, Event e2)
    {
        return e1.timeForEvent - e2.timeForEvent;
    }
}
