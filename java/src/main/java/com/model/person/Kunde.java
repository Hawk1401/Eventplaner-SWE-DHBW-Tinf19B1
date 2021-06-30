package com.model.person;


import com.model.Vertrag;
import com.model.dataTypes.Kontaktdaten;

public class Kunde {

    Kontaktdaten kontaktdaten;
    int budget;
    Vertrag vertrag;        // Fehler im Klassendiagramm!!
                              // Entweder Kunde im com.model.Vertrag oder com.model.Vertrag in Kunde beides geht aber nicht.

}
