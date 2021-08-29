package com.model.dataTypes;

public class Telefonnummer {

    int leandervorwahl;
    int vorwahl;
    int nummer;
    long gesamteNummer;

    public Telefonnummer(long gesamteNummer){
        this.gesamteNummer = gesamteNummer;
    }

    public Telefonnummer(int laenderVorwahl, int vorwahl, int nummer){
        this.leandervorwahl = laenderVorwahl;
        this.vorwahl = vorwahl;
        this.nummer = nummer;
    }

    public  Telefonnummer(){

    }
    public void ueberpruefeTelefonnummer(){
        // TODO missing code in methode ueberpruefeTelefonnummer
    }

    public int getLeandervorwahl() {
        return leandervorwahl;
    }

    public void setLeandervorwahl(int leandervorwahl) {
        this.leandervorwahl = leandervorwahl;
    }

    public int getVorwahl() {
        return vorwahl;
    }

    public void setVorwahl(int vorwahl) {
        this.vorwahl = vorwahl;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public long getGesamteNummer() {
        return gesamteNummer;
    }

    public void setGesamteNummer(long gesamteNummer) {
        this.gesamteNummer = gesamteNummer;
    }
}