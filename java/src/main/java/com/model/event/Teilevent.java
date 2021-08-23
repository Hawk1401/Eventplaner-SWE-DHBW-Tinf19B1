package com.model.event;

import com.model.dataTypes.Datum;
import com.model.dataTypes.Status;
import com.model.dataTypes.Weahrung;
import com.model.dataTypes.Anschrift;
import com.model.person.ExternBeauftragter;
import com.model.person.Mitarbeiter;

import java.util.ArrayList;
import org.javatuples.Pair;

public class Teilevent extends Event{

    ExternBeauftragter externBeauftragter;
    Anschrift standort;
    ArrayList<Angebot> angebotslist = new ArrayList<>();
    Mitarbeiter montageLeiter;
    ArrayList<Mitarbeiter> montagePersonal = new ArrayList<>();
    Mitarbeiter gruppenleiterBeschaffung;
    ArrayList<Mitarbeiter> beschaffungsPersonal = new ArrayList<>();
    ArrayList<Pair<Hilfsmittel, Integer>> hilfsmittelMitAnzahl = new ArrayList<Pair<Hilfsmittel, Integer>>();
    Hauptevent hauptevent;

    public Teilevent(String bezeichnung,
                     Datum start_Termin,
                     Datum end_Termin,
                     String beschreibung,
                     Status status,
                     double kosten,
                     int teilnehmner,
                     ArrayList<Bild> bilder,
                     ExternBeauftragter externBeauftragter,
                     Anschrift standort,
                     ArrayList<Angebot> angebotslist,
                     Mitarbeiter montageLeiter,
                     ArrayList<Mitarbeiter> montagePersonal,
                     Mitarbeiter gruppenleiterBeschaffung,
                     ArrayList<Mitarbeiter> beschaffungsPersonal,
                     ArrayList<Pair<Hilfsmittel, Integer>> hilfsmittelMitAnzahl,
                     Hauptevent hauptevent){

        super(bezeichnung, start_Termin, end_Termin,
                beschreibung, status, kosten,
                teilnehmner, bilder);

        this.externBeauftragter = externBeauftragter;
        this.standort = standort;
        this.angebotslist = angebotslist;
        this.montageLeiter = montageLeiter;
        this.montagePersonal = montagePersonal;
        this.gruppenleiterBeschaffung = gruppenleiterBeschaffung;
        this.beschaffungsPersonal = beschaffungsPersonal;
        this.hilfsmittelMitAnzahl = hilfsmittelMitAnzahl;
        this.hauptevent = hauptevent;
    }

    public Teilevent() {
        super("", new Datum(), new Datum(),
                "", Status.ERSTELLT, 0,
                0, new ArrayList<>());

        this.externBeauftragter = new ExternBeauftragter("");
        this.standort = new Anschrift("");
        this.angebotslist = new ArrayList<>();
        this.montageLeiter = new Mitarbeiter("");
        this.montagePersonal = new ArrayList<>();
        this.gruppenleiterBeschaffung = new Mitarbeiter("");
        this.beschaffungsPersonal = new ArrayList<>();
        this.hilfsmittelMitAnzahl = new ArrayList<>();
        this.hauptevent = new Hauptevent();
    }

    public Mitarbeiter getMontageLeiter() {
        return montageLeiter;
    }

    public void setMontageLeiter(Mitarbeiter montageLeiter) {
        this.montageLeiter = montageLeiter;
    }

    public ArrayList<Mitarbeiter> getMontagePersonal() {
        return montagePersonal;
    }

    public void setMontagePersonal(ArrayList<Mitarbeiter> montagePersonal) {
        this.montagePersonal = montagePersonal;
    }

    public Mitarbeiter getGruppenleiterBeschaffung() {
        return gruppenleiterBeschaffung;
    }

    public void setGruppenleiterBeschaffung(Mitarbeiter gruppenleiterBeschaffung) {
        this.gruppenleiterBeschaffung = gruppenleiterBeschaffung;
    }

    public ArrayList<Mitarbeiter> getBeschaffungsPersonal() {
        return beschaffungsPersonal;
    }

    public void setBeschaffungsPersonal(ArrayList<Mitarbeiter> beschaffungsPersonal) {
        this.beschaffungsPersonal = beschaffungsPersonal;
    }

    public ArrayList<Pair<Hilfsmittel, Integer>> getHilfsmittel() {
        return hilfsmittelMitAnzahl;
    }

    public void setHilfsmittel(ArrayList<Pair<Hilfsmittel, Integer>> hilfsmittelMitAnzahl) {
        this.hilfsmittelMitAnzahl = hilfsmittelMitAnzahl;
    }

    public ExternBeauftragter getExternBeauftragter() {
        return externBeauftragter;
    }

    public void setExternBeauftragter(ExternBeauftragter externBeauftragter) {
        this.externBeauftragter = externBeauftragter;
    }

    public Anschrift getStandort() {
        return standort;
    }

    public void setStandort(Anschrift standort) {
        this.standort = standort;
    }

    public ArrayList<Angebot> getAngebotslist() {
        return angebotslist;
    }

    public void setAngebotslist(ArrayList<Angebot> angebotslist) {
        this.angebotslist = angebotslist;
    }

    public Hauptevent getHauptevent(){
        return this.hauptevent;
    }

    public void setHauptevent(Hauptevent hauptevent){
        this.hauptevent = hauptevent;
    }
}
