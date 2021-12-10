package com.example.myapplication;

import java.sql.Time;
import java.util.Date;

public class Date_Time {
    protected Date date;
   protected Time time;

    public Date_Time(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
