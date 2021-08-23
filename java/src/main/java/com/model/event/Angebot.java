package com.model.event;

import com.model.dataTypes.Kontaktdaten;
import com.model.dataTypes.PDF;

public class Angebot {

    PDF pdf;
    double preis;
    String name;
    String beschreibung;
    Kontaktdaten kontaktdaten;

    public Angebot(PDF pdf, double preis, String name, String beschreibung, Kontaktdaten kontakt){
        this.pdf = pdf;
        this.preis = preis;
        this.name = name;
        this.beschreibung = beschreibung;
        this.kontaktdaten = kontakt;
    }
    public Angebot(){}

}
