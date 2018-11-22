package com.company;

import java.util.ArrayList;

abstract public class Event {
    int timeForEvent;

    abstract public ArrayList<Event> executeEvent();
    abstract public String printEventInfo();
}
