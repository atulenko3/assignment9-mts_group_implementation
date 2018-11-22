package com.company;

import java.util.ArrayList;

public class MoveBusEvent extends Event{
    private Bus bus;

    public MoveBusEvent(Bus bus, int timeForEvent)
    {
        this.bus = bus;
        this.timeForEvent = timeForEvent;
    }

    public String printEventInfo()
    {
        return "Event time: " + this.timeForEvent + " Bus Info: " + this.bus.BusInfo();
    }

    public ArrayList<Event> executeEvent()
    {
        int timeToNextStop = this.bus.moveToNextStop(this.timeForEvent);
        MoveBusEvent nextEvent = new MoveBusEvent(this.bus, timeToNextStop + this.timeForEvent);
        ArrayList<Event> upcomingEvents = new ArrayList<>();
        upcomingEvents.add(nextEvent);
        return upcomingEvents;
    }
}