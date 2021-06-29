package model.event;

import model.Vertrag;
import model.person.Mitarbeiter;

import java.util.ArrayList;

public class Hauptevent extends Event{

    Mitarbeiter organisator;
    Vertrag vertrag;
    ArrayList<Teilevent> teileventArrayList = new ArrayList<Teilevent>();


    public void addTeilevent(){

    }

    public void removeTeilevent(){          // nicht in Klassendiagramm

    }

    public ArrayList<Teilevent> getListeTeilevent(){
        return teileventArrayList;
    }

}
