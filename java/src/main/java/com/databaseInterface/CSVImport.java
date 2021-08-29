package com.databaseInterface;

import com.model.event.Hauptevent;
import com.model.event.Hilfsmittel;
import com.model.person.Kunde;
import com.model.person.Mitarbeiter;
import org.javatuples.Quartet;

import java.util.ArrayList;

public class CSVImport implements Import{

    @Override
    public ArrayList<Hauptevent> importHauptevent() {
        // TODO missing code
        return null;
    }

    @Override
    public ArrayList<Mitarbeiter> importMitarbieter() {
        // TODO missing code
        return null;
    }

    @Override
    public ArrayList<Hilfsmittel> importHilfsmittel() {
        // TODO missing code
        return null;
    }

    @Override
    public ArrayList<Kunde> importKunden() {
        return null;
    }

    @Override
    public Quartet<ArrayList<Hauptevent>, ArrayList<Mitarbeiter>, ArrayList<Hilfsmittel>, ArrayList<Kunde>> importAll() {
        // TODO missing code
        return null;
    }
}
