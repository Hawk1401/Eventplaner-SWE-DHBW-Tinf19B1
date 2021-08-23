package com.model.event;

import com.model.Vertrag;
import com.model.person.Mitarbeiter;
import com.model.dataTypes.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Hauptevent extends Event{


    Mitarbeiter organisator;
    Vertrag vertrag;
    ArrayList<Teilevent> listeTeilevent = new ArrayList<Teilevent>();

    

    public Hauptevent(String bezeichnung, Mitarbeiter organisator, Vertrag vertrag,
                      ArrayList<Teilevent> teilevente, double budget, int anzahlTeilnehmer,
                      String beschreibung, Status status, ArrayList<Bild> bilder, Datum start_Termin, Datum end_Termin){
        super(bezeichnung, start_Termin, end_Termin, beschreibung, status, budget, anzahlTeilnehmer, bilder);
        setOrganisator(organisator);
        setVertrag(vertrag);
        setListeTeilevent(teilevente);

    }
    
    public Hauptevent(){
        super("", new Datum(), new Datum(), "", Status.ERSTELLT, 0, 0, new ArrayList<>());
        
    }

    
    

    
        public Mitarbeiter getOrganisator() {
            return organisator;
        }
    
        public void setOrganisator(Mitarbeiter organisator) {
            this.organisator = organisator;
        }
    
        public Vertrag getVertrag() {
            return vertrag;
        }
    
        public void setVertrag(Vertrag vertrag) {
            this.vertrag = vertrag;
        }
        
        public ArrayList<Teilevent> getListeTeilevent(){
                return listeTeilevent;
            }
    
        public void setListeTeilevent(ArrayList<Teilevent> listeTeilevent) {
            this.listeTeilevent = listeTeilevent;
        }
    


    public void addTeilevent(){
        // TODO missing code in methode addTeilevent
    }

    public void removeTeilevent(){          // nicht in Klassendiagramm
        // TODO missing code in methode removeTeilevent
    }

    

}
