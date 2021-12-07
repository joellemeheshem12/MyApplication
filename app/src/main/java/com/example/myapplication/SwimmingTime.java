package com.example.myapplication;

public class SwimmingTime {
    protected String pool;
    protected int distance;
    protected String stroke;
    protected String time;
    protected String date;

    public void swimmingTime(String pool,int distance,String stroke, String time,String date){
        this.pool=pool;
        this.distance=distance;
        this.stroke=stroke;
        this.time=time;
        this.date=date;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
