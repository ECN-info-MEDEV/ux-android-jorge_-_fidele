package com.example.myassistant;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

    private String name;
    private LocalDate date;
    private LocalTime expectedStartTime;
    private LocalTime realStartTime;
    private LocalTime expectedEndTime;
    private LocalTime realEndTime;
    private LocalTime time;


    public Event(String name, LocalDate date, LocalTime expectedStartTime, LocalTime expectedEndTime) {
        this.name = name;
        this.date = date;
        this.expectedStartTime = expectedStartTime;
        this.expectedEndTime = expectedEndTime;
    }

    public void setExpectedStartTime(LocalTime expectedStartTime) {
        this.expectedStartTime = expectedStartTime;
    }

    public void setRealStartTime(LocalTime realStartTime) {
        this.realStartTime = realStartTime;
    }

    public void setExpectedEndTime(LocalTime expectedEndTime) {
        this.expectedEndTime = expectedEndTime;
    }

    public void setRealEndTime(LocalTime realEndTime) {
        this.realEndTime = realEndTime;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getExpectedStartTime() {
        return expectedStartTime;
    }

    public LocalTime getExpectedEndTime() {
        return expectedEndTime;
    }

    public LocalTime getRealStartTime() {
        return realStartTime;
    }

    public LocalTime getRealEndTime() {
        return realEndTime;
    }
}
