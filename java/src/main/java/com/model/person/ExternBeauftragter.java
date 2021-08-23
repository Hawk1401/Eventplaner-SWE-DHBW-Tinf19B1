package com.model.person;

import com.model.Vertrag;
import com.model.dataTypes.*;
import com.model.event.Angebot;

public class ExternBeauftragter {

    Vertrag vertrag;
    Kontaktdaten kontaktdaten;
    String firmenname;
    String beschreibung;
    Angebot angebot;
    int anzahlPersonal;
    String test;

    public ExternBeauftragter(String externBeauftragter) {
        this.test = externBeauftragter;
    }
    

    public ExternBeauftragter(String externBeauffirmenname, String externBeaufangebot, String externBeaufAnzahlPersonen,
        String externBeaufBeschreibung, String externBeaufVorname, String externBeaufNachname, String externBeaufEmail,
        int externBeaufTelefonnummer, String externBeaufAdresse){

        firmenname = externBeauffirmenname;
        beschreibung = externBeaufBeschreibung;
        kontaktdaten = new Kontaktdaten(externBeaufVorname,
                            externBeaufNachname,
                            new Email(externBeaufEmail),
                            new Telefonnummer(externBeaufTelefonnummer),
                            new Anschrift(externBeaufAdresse));
        // angebot Angobt to string?
        anzahlPersonal = Integer.parseInt(externBeaufAnzahlPersonen);
    }


    /*
    String externBeauffirmenname = gUIexternBeauftragter.textFieldFirmenname.getText();
    String externBeaufangebot = gUIexternBeauftragter.textFieldAngebot.getText();
    String externBeaufAnzahlPersonen = gUIexternBeauftragter.textFieldAnzahlPersonen.getText();
    String externBeaufBeschreibung = gUIexternBeauftragter.textFieldBeschreibung.getText();
    String externBeaufVorname = gUIexternBeauftragter.textFieldVorname.getText();
    String externBeaufNachname = gUIexternBeauftragter.textFieldNachname.getText();
    String externBeaufEmail = gUIexternBeauftragter.textFieldEmail.getText();
    String externBeaufTelefonnummer = gUIexternBeauftragter.textFieldTelefonnummer.getText();
    String externBeaufAdresse = gUIexternBeauftragter.textFieldAdresse.getText();
    */

}
