package com.model.event;

import com.model.dataTypes.Anschrift;
import com.model.dataTypes.Datum;
import com.model.dataTypes.Status;
import com.model.dataTypes.Weahrung;
import com.model.person.ExternBeauftragter;
import com.model.person.Mitarbeiter;
import org.javatuples.Pair;

import java.util.ArrayList;

public class Musik extends Teilevent{

    ArrayList<Interpret> listeiInterpreten = new ArrayList<>();     // Fehler in Klassendiagramm: Einzelnes Objekt zu Liste

    public Musik(String bezeichnung, Datum start_Termin, Datum end_Termin, String beschreibung, Status status, double kosten, int teilnehmner, ArrayList<Bild> bilder, ExternBeauftragter externBeauftragter, Anschrift standort, ArrayList<Angebot> angebotslist, Mitarbeiter montageLeiter, ArrayList<Mitarbeiter> montagePersonal, Mitarbeiter gruppenleiterBeschaffung, ArrayList<Mitarbeiter> beschaffungsPersonal, ArrayList<Pair<Hilfsmittel, Integer>> hilfsmittelMitAnzahl,
                 Hauptevent hauptevent) {
        super(bezeichnung,
                start_Termin,
                end_Termin,
                beschreibung,
                status,
                kosten,
                teilnehmner,
                bilder,
                externBeauftragter,
                standort,
                angebotslist,
                montageLeiter,
                montagePersonal,
                gruppenleiterBeschaffung,
                beschaffungsPersonal,
                hilfsmittelMitAnzahl,
                hauptevent);
    }
}
