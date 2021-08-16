package com.model.event;

import com.model.dataTypes.Datum;
import com.model.dataTypes.Status;
import com.model.dataTypes.Weahrung;

import java.util.ArrayList;

public abstract class Event {

    String bezeichnung;
    Datum start_Termin;
    Datum end_Termin;
    String beschreibung;
    Status status;
    double kosten;
    Weahrung weahrung;
    int teilnehmeranzahl;
    ArrayList<Bild> bilder = new ArrayList<Bild>();         // Fehler im Klassendiagramm einzelnes Bild zu ArrayList

    public Event(){
        this.bezeichnung = "Default";
    }

    public Event(String bezeichnung, Datum start_Termin, Datum end_Termin,
        String beschreibung, Status status, double kosten, Weahrung weahrung,
        int teilnehmner, ArrayList<Bild> bilder){
        this.bezeichnung = bezeichnung;
        this.start_Termin = start_Termin;
        this.end_Termin = end_Termin;
        this.beschreibung = beschreibung;
        this.status = status;
        this.kosten = kosten;
        this.weahrung = weahrung;
    }

}
