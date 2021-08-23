package com.model.dataTypes;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Datum {

    long timestamp;
    Timestamp ts;
     public Datum(long timestamp){
        this.timestamp = timestamp;
         ts = new Timestamp(timestamp);
    }

    public Datum(String Date){
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
            ts = new Timestamp(((java.util.Date)df.parse(Date)).getTime());
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

    public String getDatum(){
        String s = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(ts);
        return s;
    }

    public String getTag(){
        String s = new SimpleDateFormat("dd").format(ts);
        return s;
    }

    public String getMonat(){
        String s = new SimpleDateFormat("MM").format(ts);
        return s;
    }

    public String getJahr(){
        String s = new SimpleDateFormat("yyyy").format(ts);
        return s;
    }
}