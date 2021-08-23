package com.model.dataTypes;

public class Anschrift {

    String strasse;
    int hausnummer;
    String zusatz;
    int postleitzahl;
    String ort;
    String land;
    String gesamteAdresse;

    public Anschrift(String adresse){
        setGesamteAdresse(adresse);
    }

    public Anschrift(String strasse, int hausnummer, String zusatz,
        int postleitzahl, String ort, String land){
        setStrasse(strasse);
        setHausnummer(hausnummer);
        setZusatz(zusatz);
        setPostleitzahl(postleitzahl);
        setOrt(ort);
        setLand(land);
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(int hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getZusatz() {
        return zusatz;
    }

    public void setZusatz(String zusatz) {
        this.zusatz = zusatz;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getGesamteAdresse() {
        return gesamteAdresse;
    }

    public void setGesamteAdresse(String gesamteAdresse) {
        this.gesamteAdresse = gesamteAdresse;
    }

    public void ueberpruefeAdresse(){
        // TODO missing code in methode ueberpruefeAdresse
    }

}