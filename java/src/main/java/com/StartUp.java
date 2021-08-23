package com;


import static com.GUIController.getGuiController;

import com.databaseInterface.Eventverwaltung;
import com.model.event.*;
import com.model.dataTypes.*;
import com.model.person.*;
import com.model.Vertrag;
import org.javatuples.Pair;

import java.util.ArrayList;


public class StartUp {

    public static Hauptevent testHauptevent;
    public static void main(String[] args) {
        // init data

        // init Gui

        ArrayList<Teilevent> testTeilevents = new ArrayList<Teilevent>();
        ArrayList<Mitarbeiter> testMitarbeiter = new ArrayList<Mitarbeiter>();
        testMitarbeiter.add(new Mitarbeiter("Hans", "König", "hans.koenig@web.de", 495826984825L, "hiner den lienden 24", 1, Rolle.MITARBEITER, new ArrayList<>(), new Datum(), "Berlin"));
        testMitarbeiter.add(new Mitarbeiter("Hans1", "König1", "hans1.koenig@web.de", 495826984525L, "hiner den lienden 25", 4, Rolle.BESCHAFFUNGSPERSONAL, new ArrayList<>(), new Datum(), "Berlin"));
        testMitarbeiter.add(new Mitarbeiter("Hans2", "König2", "hans2.koenig@web.de", 4953826984825L, "hiner den lienden 26", 2, Rolle.BESCHAFFUNGSPERSONAL, new ArrayList<>(), new Datum(), "Berlin"));
        testMitarbeiter.add(new Mitarbeiter("Hans2", "König2", "hans2.koenig@web.de", 4953826984825L, "hiner den lienden 26", 2, Rolle.MONTAGELEITER, new ArrayList<>(), new Datum(), "Berlin"));
        testMitarbeiter.add(new Mitarbeiter("Hans2", "König2", "hans2.koenig@web.de", 4953826984825L, "hiner den lienden 26", 2, Rolle.ORGANISATOR, new ArrayList<>(), new Datum(), "Berlin"));


        ArrayList<Mitarbeiter> testMitarbeiter2 = new ArrayList<Mitarbeiter>();
        testMitarbeiter2.add(new Mitarbeiter("Farbi", "König", "Farbi.koenig@web.de", 495826584825L, "hiner den lienden 4", 10, Rolle.GRUPPENLEITER, new ArrayList<>(), new Datum(), "köln"));
        testMitarbeiter2.add(new Mitarbeiter("Farbi1", "König1", "Farbi1.koenig@web.de", 495826984525L, "hiner den lienden 5", 40, Rolle.MITARBEITER, new ArrayList<>(), new Datum(), "Ulm"));
        testMitarbeiter2.add(new Mitarbeiter("Farbi2", "König2", "Farbi2.koenig@web.de", 4953823984825L, "hiner den lienden 6", 20, Rolle.ADMINISTRATOR, new ArrayList<>(), new Datum(), "mainz"));


        testTeilevents.add(new Teilevent("Dast ist ein Teilevent", new Datum("13.04.1990 12:33"), new Datum("13.04.1991 12:33"),
            "Das ist die beschreibung eins...", Status.ERSTELLT, 500.0, 60, new ArrayList<Bild>(), new ExternBeauftragter("externBeauftragter1"),
            new Anschrift("Das ist eine Adresse"), new ArrayList<Angebot>(), testMitarbeiter2.get(0),
            testMitarbeiter,  testMitarbeiter.get(0),
            testMitarbeiter2, new ArrayList<Pair<Hilfsmittel, Integer>>(), new Hauptevent()));

        testTeilevents.add(new Teilevent("Dast ist das zweite Teilevent", new Datum("13.04.1990 15:33"), new Datum("13.04.1991 23:33"),
            "Das ist die beschreibung zwei...", Status.ERSTELLT, 250.0, 100, new ArrayList<Bild>(), new ExternBeauftragter("externBeauftragter2"),
            new Anschrift("Das ist auch eine Adresse"), new ArrayList<Angebot>(), testMitarbeiter2.get(2),
            testMitarbeiter,testMitarbeiter.get(0),
            testMitarbeiter2, new ArrayList<Pair<Hilfsmittel, Integer>>(), new Hauptevent()));

        testHauptevent = new Hauptevent("Hauptevent Name",
            new Mitarbeiter("John", "Smith", "info@Smith.com",
                012234, "Soll die Adresse sein ist aber noch ein String",
                01, Rolle.ORGANISATOR, new ArrayList<Aufgabenfeld>(), new Datum("13.04.1990 12:33"),
                "Bielefeld"),
            new Vertrag(),
            testTeilevents,
            20000.99,
            100,
            "Das ist die Beschreibung",
            Status.ERSTELLT,
            new ArrayList<Bild>(),
            new Datum("13.04.1990 12:33"),
            new Datum("13.04.1991 23:33"));

        Eventverwaltung.getInstance().getListeHauptevent().add(testHauptevent);
        Eventverwaltung.getInstance().getListeHilfsmittel().add(new Hilfsmittel("Super Tolle Lichter, aber Schwaz licht also achtung"));
        Eventverwaltung.getInstance().getListeMitarbeiter().addAll(testMitarbeiter);
        Eventverwaltung.getInstance().getListeMitarbeiter().addAll(testMitarbeiter2);
        GUIController controller =  getGuiController();

    }
}
