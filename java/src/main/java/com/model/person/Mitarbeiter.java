package com.model.person;
import com.model.dataTypes.*;

import java.util.ArrayList;

public class Mitarbeiter {

    Kontaktdaten kontaktdaten;
    Rolle rolle;
    String personalnummer;
    ArrayList<Aufgabenfeld> aufgabenfeldList = new ArrayList<Aufgabenfeld>();
    Datum geburtsdatum;
    String geburtsort;
    String tempName;    // nur zum Testen, sollte wieder entfernt werden

    public Mitarbeiter(){

    }
    public Mitarbeiter(String vorname, String nachname, String email,
        long tel, String adresse, int personalnummer, Rolle rolle, ArrayList<Aufgabenfeld> aufgabenfeldList,
        Datum geburtsdatum, String geburtsort){
        setKontaktdaten(new Kontaktdaten(vorname,nachname,
                                          new Email(email),
                                          new Telefonnummer(tel),
                                          new Anschrift(adresse)));
        setRolle(rolle);
        setPersonalnummer(Integer.toString(personalnummer));
        setAufgabenListe(aufgabenfeldList);
        setGeburtsdatum(geburtsdatum);
        setGeburtsort(geburtsort);
    }

    public Mitarbeiter(String name){
            this.tempName = name;
    }
    
    public void setKontaktdaten(Kontaktdaten kontaktdaten){
        this.kontaktdaten = kontaktdaten;
    }
    public Kontaktdaten getKontaktdaten(){
        return this.kontaktdaten;
    }
    
    public void setRolle(Rolle rolle){
        this.rolle = rolle;
    }
    public Rolle getRolle(){
        return this.rolle;
    }

    public void setPersonalnummer(String personalnummer){
        this.personalnummer = personalnummer;
    }
    public String getPersonalnummer(){
        return this.personalnummer;
    }
 
    public void setAufgabenListe(ArrayList<Aufgabenfeld> aufgabenfeldList){
        this.aufgabenfeldList = aufgabenfeldList;
    }

    public void setGeburtsdatum(Datum geburtsdatum){
        this.geburtsdatum = geburtsdatum;
    }
    public Datum getGeburtsdatum(){
        return this.geburtsdatum;
    }


    public ArrayList<Aufgabenfeld> getAufgabenfeldList() {
        return aufgabenfeldList;
    }

    public void setAufgabenfeldList(ArrayList<Aufgabenfeld> aufgabenfeldList) {
        this.aufgabenfeldList = aufgabenfeldList;
    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public void setGeburtsort(String geburtsort){
        this.geburtsort = geburtsort;
    }
    public String getGeburtsort(){
        return this.geburtsort;
    }

}
