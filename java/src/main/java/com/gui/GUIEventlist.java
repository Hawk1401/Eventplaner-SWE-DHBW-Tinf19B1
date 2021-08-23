package com.gui;

import com.databaseInterface.Eventverwaltung;
import de.dhbwka.swe.utils.*;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import de.dhbwka.swe.utils.gui.ButtonComponent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.SimpleTableComponent;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import com.model.event.*;

public class GUIEventlist extends GUIComponent implements IGUIEventListener {

    //TODO still nothing there
    SimpleTableComponent table;
    ArrayList<Hauptevent> listHauptevent;


    public GUIEventlist(IGUIEventListener obs) {
        Hauptevent he = com.StartUp.testHauptevent;
        listHauptevent = Eventverwaltung.getInstance().getListeHauptevent();

        IDepictable[] elems = new IDepictable[listHauptevent.size()];
        for (int i = 0; i < elems.length; i++) {
            Hauptevent haupt = listHauptevent.get(i);
            elems[i] = new tableclass(haupt.getBezeichnung(), haupt.getStart_Termin().getDatum(), haupt.getEnd_Termin().getDatum(),haupt.getStatus().toString(), Integer.toString(haupt.getTeilnehmeranzahl()));
        }
        /*
        IDepictable[] elems = new IDepictable[]{

                new tableclass("Geburtags", "14.01.2022", "15.01.2022", "In planung", "69"),
                new tableclass("Geburtags", "14.01.2023", "15.01.2023", "In planung", "420")
        };*/


        table = SimpleTableComponent.builder("tableEvents").selectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ).columnNames(new String[]{"name","StartDatum","EndDatum","Status","TeilnehmerAnzahl"}).build();

        table.setData(elems, new String[]{"name","StartDatum","EndDatum","Status","TeilnehmerAnzahl"});
        table.addObserver(obs);
    }

    public SimpleTableComponent getTable(){return table;}

    @Override
    public void processGUIEvent(GUIEvent ge) {
        
    }

    //temp
    public class tableclass implements IDepictable {

        public String name;
        public String StartDatum;
        public String EndDatum;
        public String Status;
        public String TeilnehmerAnzahl;

        public String getTeilnehmerAnzahl() {
            return TeilnehmerAnzahl;
        }

        public String getName() {
            return name;
        }

        public void setTeilnehmerAnzahl(String teilnehmerAnzahl) {
            TeilnehmerAnzahl = teilnehmerAnzahl;
        }

        public tableclass(String name, String StartDatum,
                          String EndDatum,
                          String Status,
                          String TeilnehmerAnzahl){

                           this.name = name;
                           this.StartDatum = StartDatum;
                           this.EndDatum = EndDatum;
                           this.Status = Status;
                           this.TeilnehmerAnzahl = TeilnehmerAnzahl;
                       }
                       @Override
                       public String getElementID() {
                           return this.name;
                       }
           
                       @Override
                       public Attribute[] getAttributeArray() {
                           return new Attribute[] { new Attribute("name",
                                   this.name,
                                   String.class,
                                   this.name,
                                   "name",
                                   true,
                                   true,
                                   true

                           ),
                                   new Attribute("StartDatum",
                                           this.StartDatum,
                                           String.class,
                                           this.StartDatum,
                                           "StartDatum",
                                           true,
                                           true,
                                           true

                                   ),
                                   new Attribute("EndDatum",
                                           this.EndDatum,
                                           String.class,
                                           this.EndDatum,
                                           "EndDatum",
                                           true,
                                           true,
                                           true

                                   ),
                                   new Attribute("Status",
                                           this.Status,
                                           String.class,
                                           this.Status,
                                           "Status",
                                           true,
                                           true,
                                           true

                                   ),
                                   new Attribute("TeilnehmerAnzahl",
                                           this.TeilnehmerAnzahl,
                                           String.class,
                                           this.TeilnehmerAnzahl,
                                           "TeilnehmerAnzahl",
                                           true,
                                           true,
                                           true

                                   )};
                       }
           
                       //Attribute(String name, Object dedicatedInstance, Class<?> clazz, Object value, Object defaultValue, boolean visible, boolean modifiable, boolean editable)
                   }
    //temp
}
