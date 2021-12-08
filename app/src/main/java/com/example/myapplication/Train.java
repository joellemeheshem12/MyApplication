package com.example.myapplication;

import java.sql.Time;
import java.util.Date;

public class Train {
   protected Date date ;
   protected Time time;

    public void train(){

    }

    public Train(Date date, Time time) {
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
