package com.example.myapplication;

import java.sql.Time;
import java.util.Date;

public class SwimmingTime {
    protected String pool;
    protected int distance;
    protected String stroke;
    protected Time time;
    protected Date date;

    public SwimmingTime(String pool, int distance, String stroke, Time time, Date date) {
        this.pool = pool;
        this.distance = distance;
        this.stroke = stroke;
        this.time = time;
        this.date = date;
    }

    public void swimmingTime() {
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}