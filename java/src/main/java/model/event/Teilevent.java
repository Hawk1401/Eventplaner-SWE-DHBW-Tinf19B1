package model.event;

import model.dataTypes.Anschrift;
import model.person.ExternBeauftragter;
import model.person.Mitarbeiter;

import java.util.ArrayList;

public class Teilevent extends Event{

    ExternBeauftragter externBeauftragter;
    Anschrift standort;
    ArrayList<Angebot> angebotArrayList = new ArrayList<>();
    Mitarbeiter montageLeiter;
    ArrayList<Mitarbeiter> montagePersonalArrayList = new ArrayList<>();
    Mitarbeiter gruppenleiterBeschaffung;
    ArrayList<Mitarbeiter> beschaffungsPersonalArrayList = new ArrayList<>();
    ArrayList<Hilfsmittel> hilfsmittelArrayList = new ArrayList<>();


    public Mitarbeiter getMontageLeiter() {
        return montageLeiter;
    }

    public void setMontageLeiter(Mitarbeiter montageLeiter) {
        this.montageLeiter = montageLeiter;
    }

    public ArrayList<Mitarbeiter> getMontagePersonalArrayList() {
        return montagePersonalArrayList;
    }

    public void setMontagePersonalArrayList(ArrayList<Mitarbeiter> montagePersonalArrayList) {
        this.montagePersonalArrayList = montagePersonalArrayList;
    }

    public Mitarbeiter getGruppenleiterBeschaffung() {
        return gruppenleiterBeschaffung;
    }

    public void setGruppenleiterBeschaffung(Mitarbeiter gruppenleiterBeschaffung) {
        this.gruppenleiterBeschaffung = gruppenleiterBeschaffung;
    }

    public ArrayList<Mitarbeiter> getBeschaffungsPersonalArrayList() {
        return beschaffungsPersonalArrayList;
    }

    public void setBeschaffungsPersonalArrayList(ArrayList<Mitarbeiter> beschaffungsPersonalArrayList) {
        this.beschaffungsPersonalArrayList = beschaffungsPersonalArrayList;
    }

    public ArrayList<Hilfsmittel> getHilfsmittelArrayList() {
        return hilfsmittelArrayList;
    }

    public void setHilfsmittelArrayList(ArrayList<Hilfsmittel> hilfsmittelArrayList) {
        this.hilfsmittelArrayList = hilfsmittelArrayList;
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

    public ArrayList<Angebot> getAngebotArrayList() {
        return angebotArrayList;
    }

    public void setAngebotArrayList(ArrayList<Angebot> angebotArrayList) {
        this.angebotArrayList = angebotArrayList;
    }
}
