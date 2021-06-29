package model.person;


import model.Vertrag;
import model.dataTypes.Kontaktdaten;

public class Kunde {

    Kontaktdaten kontaktdaten;
    int budget;
    Vertrag vertrag;        // Fehler im Klassendiagramm!!
                              // Entweder Kunde im model.Vertrag oder model.Vertrag in Kunde beides geht aber nicht.

}
