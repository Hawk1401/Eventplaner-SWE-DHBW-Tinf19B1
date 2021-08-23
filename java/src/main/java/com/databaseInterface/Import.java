package com.databaseInterface;

import com.model.dataTypes.*;
import com.model.event.Hauptevent;
import com.model.event.Hilfsmittel;
import com.model.person.*;
import org.javatuples.Triplet;

import java.util.ArrayList;

public interface Import {

    public ArrayList<Hauptevent> importHauptevent();
    public ArrayList<Mitarbeiter> importMitarbieter();
    public ArrayList<Hilfsmittel> importHilfsmittel();
    public Triplet<ArrayList<Hauptevent>, ArrayList<Mitarbeiter>, ArrayList<Hilfsmittel>> importAll();

}
