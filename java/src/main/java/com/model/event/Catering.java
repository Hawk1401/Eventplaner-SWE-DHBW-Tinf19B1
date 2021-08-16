package com.model.event;

import com.model.dataTypes.*;
import com.model.person.ExternBeauftragter;
import com.model.person.Mitarbeiter;

import java.util.ArrayList;

public class Catering extends Teilevent{

    int anzahlMenues;
    TypEssen artEssen;
    PDF speisekarte;

    public Catering(String bezeichnung, Datum start_Termin, Datum end_Termin, String beschreibung, Status status, double kosten, Weahrung weahrung, int teilnehmner, ArrayList<Bild> bilder, ExternBeauftragter externBeauftragter, Anschrift standort, ArrayList<Angebot> angebotslist, Mitarbeiter montageLeiter, ArrayList<Mitarbeiter> montagePersonal, Mitarbeiter gruppenleiterBeschaffung, ArrayList<Mitarbeiter> beschaffungsPersonal, ArrayList<Hilfsmittel> hilfsmittel) {
        super(bezeichnung, start_Termin, end_Termin, beschreibung, status, kosten, weahrung, teilnehmner, bilder, externBeauftragter, standort, angebotslist, montageLeiter, montagePersonal, gruppenleiterBeschaffung, beschaffungsPersonal, hilfsmittel);
    }
}
