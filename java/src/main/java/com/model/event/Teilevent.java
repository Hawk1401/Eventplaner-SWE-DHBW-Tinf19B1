package com.model.event;

import com.model.dataTypes.Anschrift;
import com.model.person.ExternBeauftragter;
import com.model.person.Mitarbeiter;

import java.util.ArrayList;

public class Teilevent extends Event{

    ExternBeauftragter externBeauftragter;
    Anschrift standort;
    ArrayList<Angebot> angebotslist = new ArrayList<>();
    Mitarbeiter montageLeiter;
    ArrayList<Mitarbeiter> montagePersonal = new ArrayList<>();
    Mitarbeiter gruppenleiterBeschaffung;
    ArrayList<Mitarbeiter> beschaffungsPersonal = new ArrayList<>();
    ArrayList<Hilfsmittel> hilfsmittel = new ArrayList<>();


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

    public ArrayList<Hilfsmittel> getHilfsmittel() {
        return hilfsmittel;
    }

    public void setHilfsmittel(ArrayList<Hilfsmittel> hilfsmittel) {
        this.hilfsmittel = hilfsmittel;
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
}
