package com.model.event;

import com.model.dataTypes.*;
import com.model.person.ExternBeauftragter;
import com.model.person.Mitarbeiter;

import java.util.ArrayList;
import org.javatuples.Pair;


public class Location extends Teilevent{

    double groeßeIn2m;
    String dekorationStil;
    Kapaziteat kueche;
    Kapaziteat bar;
    Kapaziteat spuelmaschine;
    boolean terrasse;
    int anzahlRaeume;
    int anzahlToiletten;
    boolean umkleide;
    int anzahlZulaessigePersonen;

    public Location(String bezeichnung, Datum start_Termin, Datum end_Termin, String beschreibung, Status status, double kosten, int teilnehmner, ArrayList<Bild> bilder, ExternBeauftragter externBeauftragter, Anschrift standort, ArrayList<Angebot> angebotslist, Mitarbeiter montageLeiter, ArrayList<Mitarbeiter> montagePersonal, Mitarbeiter gruppenleiterBeschaffung, ArrayList<Mitarbeiter> beschaffungsPersonal, ArrayList<Pair<Hilfsmittel, Integer>> hilfsmittel, Hauptevent hauptevent) {
        super(bezeichnung, start_Termin, end_Termin, beschreibung, status, kosten, teilnehmner, bilder, externBeauftragter, standort, angebotslist, montageLeiter, montagePersonal, gruppenleiterBeschaffung, beschaffungsPersonal, hilfsmittel, hauptevent);
    }
}
