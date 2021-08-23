package com.model.dataTypes;

public class Kontaktdaten {

    String vorname;
    String nachname;
    Email email;
    Telefonnummer telefonnummer;
    Anschrift anschrift;
    
    public Kontaktdaten(String vorname, String nachname, Email email, Telefonnummer telefonnummer, Anschrift anschrift){
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.telefonnummer = telefonnummer;
        this.anschrift = anschrift;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Telefonnummer getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(Telefonnummer telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Anschrift getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(Anschrift anschrift) {
        this.anschrift = anschrift;
    }

    
}