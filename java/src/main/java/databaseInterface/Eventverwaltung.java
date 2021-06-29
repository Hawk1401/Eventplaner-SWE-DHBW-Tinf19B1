package databaseInterface;

import model.dataTypes.Anschrift;
import model.dataTypes.Email;
import model.dataTypes.Telefonnummer;
import model.dataTypes.URL;
import model.event.Hauptevent;
import model.event.Hilfsmittel;
import model.person.Mitarbeiter;

import java.util.ArrayList;

public class Eventverwaltung {

    private static final Eventverwaltung eventverwaltung = new Eventverwaltung();
    ArrayList<Hauptevent> listeHauptevent = new ArrayList<>();
    ArrayList<Mitarbeiter> listeMitarbeiter = new ArrayList<>();
    ArrayList<Hilfsmittel> listeHilfsmittel = new ArrayList<>();
    String name;
    Telefonnummer telefonnummer;
    Email email;
    Anschrift adresse;
    URL webseite;

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
