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
    Weahrung weahrung; // nur geplant
    int teilnehmeranzahl;

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Datum getStart_Termin() {
        return start_Termin;
    }

    public void setStart_Termin(Datum start_Termin) {
        this.start_Termin = start_Termin;
    }

    public Datum getEnd_Termin() {
        return end_Termin;
    }

    public void setEnd_Termin(Datum end_Termin) {
        this.end_Termin = end_Termin;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getKosten() {
        return kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }

    public Weahrung getWeahrung() {
        return weahrung;
    }

    public void setWeahrung(Weahrung weahrung) {
        this.weahrung = weahrung;
    }

    public int getTeilnehmeranzahl() {
        return teilnehmeranzahl;
    }

    public void setTeilnehmeranzahl(int teilnehmeranzahl) {
        this.teilnehmeranzahl = teilnehmeranzahl;
    }

    public ArrayList<Bild> getBilder() {
        return bilder;
    }

    public void setBilder(ArrayList<Bild> bilder) {
        this.bilder = bilder;
    }

    ArrayList<Bild> bilder = new ArrayList<Bild>();         // Fehler im Klassendiagramm einzelnes Bild zu ArrayList

    public Event(){
        this.bezeichnung = "Default";
    }

    public Event(String bezeichnung, Datum start_Termin, Datum end_Termin,
        String beschreibung, Status status, double kosten,
        int teilnehmner, ArrayList<Bild> bilder){
        this.bezeichnung = bezeichnung;
        this.start_Termin = start_Termin;
        this.end_Termin = end_Termin;
        this.beschreibung = beschreibung;
        this.status = status;
        this.kosten = kosten;
    }

}
