package model.event;

import model.Vertrag;
import model.person.Mitarbeiter;

import java.util.ArrayList;

public class Hauptevent extends Event{

    Mitarbeiter organisator;
    Vertrag vertrag;
    ArrayList<Teilevent> listeTeilevent = new ArrayList<Teilevent>();


    public void addTeilevent(){
        // TODO missing code in methode addTeilevent
    }

    public void removeTeilevent(){          // nicht in Klassendiagramm
        // TODO missing code in methode removeTeilevent
    }

    public ArrayList<Teilevent> getListeTeilevent(){
        return listeTeilevent;
    }

}
