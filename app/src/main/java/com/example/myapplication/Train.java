package com.example.myapplication;

public class Train {
   protected String date ;
   protected String time;

   public void train(String date,String time){
       this.date=date;
       this.time=time;
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
}
