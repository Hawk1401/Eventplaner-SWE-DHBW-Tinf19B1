package com.model;

import com.model.dataTypes.Datum;
import com.model.person.*;;

public class Vertrag {

    double kosten;
    String beschreibung;
    String bezeichnung;
    Datum datum;
    int vertragsnummer;
    Kunde kunde;

    public Vertrag(){
    }

    public Vertrag(String details){
        this.bezeichnung = details;
    }
    public Vertrag(double kosten, String beschreibung, String bezeichnung, Datum datum, int vertragsnummer, Kunde kunde){
        this.kosten = kosten;
        this.beschreibung = beschreibung;
        this.bezeichnung = bezeichnung;
        this.datum = datum;
        this.vertragsnummer = vertragsnummer;
        this.kunde = kunde;
    }

    public double getKosten() {
        return this.kosten;
    }

    public void setKosten(double kosten) {
        this.kosten = kosten;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getBezeichnung() {
        return this.bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Datum getDatum() {
        return this.datum;
    }

    public void setDatum(Datum datum) {
        this.datum = datum;
    }

    public int getVertragsnummer() {
        return this.vertragsnummer;
    }

    public void setVertragsnummer(int vertragsnummer) {
        this.vertragsnummer = vertragsnummer;
    }

    public Kunde getKunde() {
        return this.kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

}
