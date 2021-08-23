package com.databaseInterface;

import com.model.dataTypes.Anschrift;
import com.model.dataTypes.Email;
import com.model.dataTypes.Telefonnummer;
import com.model.dataTypes.URL;
import com.model.event.Hauptevent;
import com.model.event.Hilfsmittel;
import com.model.person.Kunde;
import com.model.person.Mitarbeiter;

import java.util.ArrayList;

public class Eventverwaltung {

    private static final Eventverwaltung eventverwaltung = new Eventverwaltung();
    private ArrayList<Hauptevent> listeHauptevent = new ArrayList<>();
    private ArrayList<Mitarbeiter> listeMitarbeiter = new ArrayList<>();
    private ArrayList<Hilfsmittel> listeHilfsmittel = new ArrayList<>();
    private ArrayList<Kunde> listeKunde = new ArrayList<>();
    private String name;

    public static Eventverwaltung getEventverwaltung() {
        return eventverwaltung;
    }

    public ArrayList<Kunde> getListeKunde() {
        return listeKunde;
    }

    public void setListeKunde(ArrayList<Kunde> listeKunde) {
        this.listeKunde = listeKunde;
    }

    private Telefonnummer telefonnummer;
    private Email email;
    private Anschrift adresse;

    public ArrayList<Hauptevent> getListeHauptevent() {
        return listeHauptevent;
    }

    public void setListeHauptevent(ArrayList<Hauptevent> listeHauptevent) {
        this.listeHauptevent = listeHauptevent;
    }

    public ArrayList<Mitarbeiter> getListeMitarbeiter() {
        return listeMitarbeiter;
    }

    public void setListeMitarbeiter(ArrayList<Mitarbeiter> listeMitarbeiter) {
        this.listeMitarbeiter = listeMitarbeiter;
    }

    public ArrayList<Hilfsmittel> getListeHilfsmittel() {
        return listeHilfsmittel;
    }

    public void setListeHilfsmittel(ArrayList<Hilfsmittel> listeHilfsmittel) {
        this.listeHilfsmittel = listeHilfsmittel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Telefonnummer getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(Telefonnummer telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Anschrift getAdresse() {
        return adresse;
    }

    public void setAdresse(Anschrift adresse) {
        this.adresse = adresse;
    }

    public URL getWebseite() {
        return webseite;
    }

    public void setWebseite(URL webseite) {
        this.webseite = webseite;
    }

    private URL webseite;

    private Eventverwaltung(){
        // constructor is private -> no access from outside, no new object -> singleton
    }

    public static Eventverwaltung getInstance(){
        return eventverwaltung;
    }

    public void importData(){
        //TODO missing code in methode importData
    }

    public void saveData(){
        //TODO missing code in methode saveData
    }

}
