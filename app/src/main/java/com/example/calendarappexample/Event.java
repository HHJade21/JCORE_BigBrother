package com.example.calendarappexample;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Event
{
    public static ArrayList<Event> eventsList = new ArrayList<>();

    public Event(String cateName, String selectedDate, String pre_time) {
        this.name = cateName;
    }

    public Event(String name, String pre_time, String next_time) {
        this.name = name;
        this.time = pre_time;
        this.next_time = next_time;

    }

    public static ArrayList<Event> eventsForDate(LocalDate date)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }

        return events;
    }

    public static ArrayList<Event> eventsForDateAndTime(LocalDate date, LocalTime time)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            int eventHour = event.time.getHour();
            int cellHour = time.getHour();
            if(event.getDate().equals(date) && eventHour == cellHour)
                events.add(event);
        }

        return events;
    }


    private String name;
    private LocalDate date;
    private String time;
    private String next_time;

    public Event(String name, String pre_time, String next_time)
    {
        this.name = name;
        this.time = pre_time;
        this.next_time = next_time;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }
}