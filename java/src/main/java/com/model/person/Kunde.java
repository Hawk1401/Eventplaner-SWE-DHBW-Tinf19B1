package com.model.person;


import com.model.Vertrag;
import com.model.dataTypes.Anschrift;
import com.model.dataTypes.Email;
import com.model.dataTypes.Kontaktdaten;
import com.model.dataTypes.Telefonnummer;

public class Kunde {

    Kontaktdaten kontaktdaten;
    double budget;
    Vertrag vertrag;        // Fehler im Klassendiagramm!!
                              // Entweder Kunde im com.model.Vertrag oder com.model.Vertrag in Kunde beides geht aber nicht.
    public Kunde(String vorname, String nachname, String email, int telefonnummer, String anschrift, double budget, Vertrag vertrag){
        this.setKontaktdaten(vorname, nachname, email, telefonnummer, anschrift);
        this.budget = budget;
        this.vertrag = vertrag;
    }

     public void setKontaktdaten(Kontaktdaten kontaktdaten){
        this.kontaktdaten = kontaktdaten;
     }
     public void setKontaktdaten(String vorname, String nachname, String email, int telefonnummer, String anschrift){
        this.kontaktdaten = new Kontaktdaten(vorname, nachname, new Email(email) , new Telefonnummer(telefonnummer), new Anschrift(anschrift));
     }
     public Kontaktdaten getKontaktdaten(){
        return this.kontaktdaten;
     }
     public void setBudget(int budget){
        this.budget = budget;
     }
     public double getBudget(){
        return this.budget;
     }
     public void setVertrag(String vertrag){
        this.vertrag = new Vertrag(vertrag);
     }
     public Vertrag getVertrag(){
        return this.vertrag;
     }
}
