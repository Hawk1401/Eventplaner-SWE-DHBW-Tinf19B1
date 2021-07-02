package com.model.event;

public class Hilfsmittel {

    String bezeichnung;
    int gesamtAnzahl;
    int aktuelleAnzahl;
    String beschreibung;        // Fehler im Klassendiagramm -> int zu String


    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getGesamtAnzahl() {
        return gesamtAnzahl;
    }

    public void setGesamtAnzahl(int gesamtAnzahl) {
        this.gesamtAnzahl = gesamtAnzahl;
    }

    public int getAktuelleAnzahl() {
        return aktuelleAnzahl;
    }

    public void setAktuelleAnzahl(int aktuelleAnzahl) {
        this.aktuelleAnzahl = aktuelleAnzahl;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

}
