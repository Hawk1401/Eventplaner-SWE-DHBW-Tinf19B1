package model.person;

import model.dataTypes.Datum;
import model.dataTypes.Kontaktdaten;
import model.dataTypes.Rolle;

import java.util.ArrayList;

public class Mitarbeiter {

    Kontaktdaten kontaktdaten;
    Rolle rolle;
    int personalnummer;
    ArrayList<Aufgabenfeld> aufgabenfeldList = new ArrayList<Aufgabenfeld>();
    Datum geburtsdatum;
    String geburtsort;

}
