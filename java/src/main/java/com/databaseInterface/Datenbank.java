package com.databaseInterface;

import com.model.event.Event;
import com.model.event.Hauptevent;
import com.model.event.Hilfsmittel;
import com.model.person.Mitarbeiter;

public class Datenbank {

    private static final Datenbank datenbank = new Datenbank();


    private Datenbank(){
        // constructor is private -> no access from outside, no new object -> singleton
    }


    public static Datenbank getDatenbank() { return datenbank; }

    public Event getElement() {
        // TODO missing code in methode getElement
        // zum laden der einzelenen Events?? was sind Elements?
        return null;
    }

    public Mitarbeiter getAllMitarbeiter(){
        // TODO missing code in the methode getAllMitarbeiter
        return null;
    }

    public Hauptevent getAllHauptevents(){
        // TODO missing code in the methode getAllHauptevents
        return null;
    }

    public Hilfsmittel getAllHilfsmittel(){
        // TODO missing code in the methode getAllHilfsmittel
        return null;
    }

    public void deleteElement(){
        // TODO missing code in the methode deleteElement
    }

    public void insertElement(){
        // TODO missing code in the mehtode insertElement
    }

}
