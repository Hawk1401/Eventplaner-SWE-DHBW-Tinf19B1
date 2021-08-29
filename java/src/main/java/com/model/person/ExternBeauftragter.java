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


    public ExternBeauftragter(){}
    public Vertrag getVertrag() {
        return vertrag;
    }

    public void setVertrag(Vertrag vertrag) {
        this.vertrag = vertrag;
    }

    public Kontaktdaten getKontaktdaten() {
        return kontaktdaten;
    }

    public void setKontaktdaten(Kontaktdaten kontaktdaten) {
        this.kontaktdaten = kontaktdaten;
    }

    public String getFirmenname() {
        return firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Angebot getAngebot() {
        return angebot;
    }

    public void setAngebot(Angebot angebot) {
        this.angebot = angebot;
    }

    public int getAnzahlPersonal() {
        return anzahlPersonal;
    }

    public void setAnzahlPersonal(int anzahlPersonal) {
        this.anzahlPersonal = anzahlPersonal;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

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
