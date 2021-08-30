package com;


import static com.GUIController.getGuiController;

import com.databaseInterface.Eventverwaltung;
import com.databaseInterface.JSONExport;
import com.databaseInterface.JSONImport;
import com.model.event.*;
import com.model.dataTypes.*;
import com.model.person.*;
import com.model.Vertrag;
import org.javatuples.Pair;
import org.javatuples.Quartet;

import java.util.ArrayList;


public class StartUp {

    public static Hauptevent testHauptevent;
    public static void main(String[] args) {
        // init data

        // init Gui

        ArrayList<Teilevent> testTeilevents = new ArrayList<Teilevent>();
        ArrayList<Mitarbeiter> testMitarbeiter = new ArrayList<Mitarbeiter>();
        ArrayList<Mitarbeiter> testMitarbeiter2 = new ArrayList<Mitarbeiter>();

        testMitarbeiter.add(new Mitarbeiter("Emil", "Peeters", "Emil.Peeters@web.de", 4958269832825L, "hiner den lienden 1", 1, Rolle.MITARBEITER, new ArrayList<>(), new Datum(), "Berlin"));
        testMitarbeiter.add(new Mitarbeiter("Anton", "Janssens", "Anton.Janssens@web.de", 495826984525L, "hiner den lienden 2", 2, Rolle.BESCHAFFUNGSPERSONAL, new ArrayList<>(), new Datum(), "Berlin"));
        testMitarbeiter.add(new Mitarbeiter("Karl", "Maes", "Karl.Maes@web.de", 4953836984835L, "hiner den lienden 3", 3, Rolle.GRUPPENLEITER, new ArrayList<>(), new Datum(), "Berlin"));
        testMitarbeiter.add(new Mitarbeiter("Paul", "Jacobs", "Paul.Jacobs@web.de", 4953826384825L, "hiner den lienden 4", 4, Rolle.MONTAGELEITER, new ArrayList<>(), new Datum(), "Berlin"));
        testMitarbeiter.add(new Mitarbeiter("Theo", "Mertens", "Theo.Mertens@web.de", 4953826985825L, "hiner den lienden 5", 5, Rolle.ORGANISATOR, new ArrayList<>(), new Datum(), "Berlin"));
        testMitarbeiter2.add(new Mitarbeiter("Felix", "Willems", "Felix.Willems@web.de", 495826584825L, "hiner den lienden 6", 6, Rolle.GRUPPENLEITER, new ArrayList<>(), new Datum(), "köln"));
        testMitarbeiter2.add(new Mitarbeiter("Oskar", "Claes", "Oskar.Claes@web.de", 495826924525L, "hiner den lienden 7", 7, Rolle.MITARBEITER, new ArrayList<>(), new Datum(), "Ulm"));
        testMitarbeiter2.add(new Mitarbeiter("Noah", "Goossens", "Noah.Goossens@web.de", 4953821984825L, "hiner den lienden 8", 8, Rolle.ADMINISTRATOR, new ArrayList<>(), new Datum(), "mainz"));
        testMitarbeiter2.add(new Mitarbeiter("Ben", "Wouters", "Ben.Wouters@web.de", 495486584825L, "hiner den lienden 9", 9, Rolle.GRUPPENLEITER, new ArrayList<>(), new Datum(), "köln"));
        testMitarbeiter2.add(new Mitarbeiter("Elias", "Jacobs", "Elias.Jacobs@web.de", 495826894525L, "hiner den lienden 10", 10, Rolle.BESCHAFFUNGSPERSONAL, new ArrayList<>(), new Datum(), "Ulm"));
        testMitarbeiter2.add(new Mitarbeiter("Arthur", "Janssens", "Arthur.Janssens@web.de", 4958473984825L, "hiner den lienden 11", 11, Rolle.ADMINISTRATOR, new ArrayList<>(), new Datum(), "mainz"));

        /*
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



        Hauptevent testHauptevent2 = new Hauptevent("Hauptevent Name die zweite",
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
                new Datum("13.04.1992 12:33"),
                new Datum("13.04.1993 23:33"));

        Eventverwaltung.getInstance().getListeHauptevent().add(testHauptevent);
        Eventverwaltung.getInstance().getListeHauptevent().add(testHauptevent2);
        */




        Eventverwaltung.getInstance().getListeHilfsmittel().add(new Hilfsmittel("Stuhl"));
        Eventverwaltung.getInstance().getListeHilfsmittel().add(new Hilfsmittel("Tisch"));
        Eventverwaltung.getInstance().getListeHilfsmittel().add(new Hilfsmittel("Lautsprecher"));
        Eventverwaltung.getInstance().getListeHilfsmittel().add(new Hilfsmittel("Mischpult"));
        Eventverwaltung.getInstance().getListeHilfsmittel().add(new Hilfsmittel("Bühne"));
        Eventverwaltung.getInstance().getListeHilfsmittel().add(new Hilfsmittel("Leimwand"));
        Eventverwaltung.getInstance().getListeHilfsmittel().add(new Hilfsmittel("verlängerungskabel"));


        Eventverwaltung.getInstance().getListeMitarbeiter().addAll(testMitarbeiter);
        Eventverwaltung.getInstance().getListeMitarbeiter().addAll(testMitarbeiter2);

        Eventverwaltung.getInstance().getListeKunde().add(new Kunde("Otto", "maier","otto.maier@web.de", 123342, "Dorfstraße 69 25567 Muensterdorf ", 4500, new Vertrag()));





        JSONImport importler = new JSONImport();
        Quartet<ArrayList<Hauptevent>, ArrayList<Mitarbeiter>, ArrayList<Hilfsmittel>, ArrayList<Kunde>> data = importler.importAll();

        Eventverwaltung.getInstance().setListeHauptevent(data.getValue0());
        //Eventverwaltung.getInstance().setListeMitarbeiter(data.getValue1());

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            GUIController controller =  getGuiController();

            public void run() {
                JSONExport export = new JSONExport();

                export.exportAll(Eventverwaltung.getInstance().getListeHauptevent(),
                        Eventverwaltung.getInstance().getListeMitarbeiter(),
                        Eventverwaltung.getInstance().getListeHilfsmittel(),
                        Eventverwaltung.getInstance().getListeKunde());
            }
        }));
    }
}
