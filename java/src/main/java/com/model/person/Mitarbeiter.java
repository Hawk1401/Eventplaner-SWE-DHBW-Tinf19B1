package com.model.person;

import com.model.dataTypes.Datum;
import com.model.dataTypes.Kontaktdaten;
import com.model.dataTypes.Rolle;

import java.util.ArrayList;

public class Mitarbeiter {

    Kontaktdaten kontaktdaten;
    Rolle rolle;
    int personalnummer;
    ArrayList<Aufgabenfeld> aufgabenfeldList = new ArrayList<Aufgabenfeld>();
    Datum geburtsdatum;
    String geburtsort;

}
