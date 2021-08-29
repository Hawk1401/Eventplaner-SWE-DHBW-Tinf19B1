package com.model.dataTypes;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Datum {

    long timestamp;
    String datum;
    Timestamp ts;

     public Datum(long timestamp){
        this.timestamp = timestamp;
        ts = new Timestamp(timestamp);
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Datum(String Date){
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            ts = new Timestamp(((java.util.Date)df.parse(Date)).getTime());
            timestamp = ts.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Datum(){
        this(System.currentTimeMillis());
    }
    public long getTimestamp(){
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        ts = new Timestamp(timestamp);
    }
    public String getDatum(){
         if(ts == null){
             ts = new Timestamp(timestamp);
         }
        String s = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(ts);
        return s;
    }
}