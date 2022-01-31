package com.example.myapplication;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Train implements Serializable {
   protected String date ;
   protected String time;

    public Train(){

    }

    public Train(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Train{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
