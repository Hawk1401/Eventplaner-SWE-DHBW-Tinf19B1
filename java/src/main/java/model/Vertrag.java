package model;

import model.dataTypes.Datum;

public class Vertrag {

    // Vertrag muss in Package Model??

    double kosten;
    String beschreibung;
    String bezeichnung;
    Datum datum;
    int vertragsnummer;
    //Kunde kunde;        // fehler im KLassendiagramm!!
                        // Entweder Kunde im model.Vertrag oder model.Vertrag in Kunde beides geht aber nicht.
}
