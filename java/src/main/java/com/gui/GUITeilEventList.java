package com.gui;

import com.model.event.Teilevent;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import de.dhbwka.swe.utils.gui.SimpleTableComponent;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUITeilEventList extends GUIComponent implements IGUIEventListener {

    SimpleTableComponent table;

    GUITeilEventList(List<Teilevent> list, IGUIEventListener obs){


        IDepictable[] elems = new IDepictable[]{
                new tableclass("Essen Fassen", "02.04.2003 15:05", "02.04.2004 15:05", "In palnung", "3"),
                new tableclass("Party", "02.06.2003 15:05", "02.04.2006 01:05", "In palnung", "3"),
                new tableclass("Abildung", "02.04.2003 15:05", "02.04.2004 15:05", "In palnung", "1")

        };
        table = SimpleTableComponent.builder("tableEvents").selectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ).columnNames(new String[]{"name", "Start Datum", "End Datum", "Status", "Teilnehmeranzahl"}).build();

        table.setData(elems, new String[]{"name", "Start Datum", "End Datum", "Status", "Teilnehmeranzahl"});
        table.setSize(new Dimension(900,900));
        table.addObserver(obs);
    }

    public SimpleTableComponent getTable() {
        return table;
    }

    public void setTable(SimpleTableComponent table) {
        this.table = table;
    }

    @Override
    public void processGUIEvent(GUIEvent guiEvent) {

    }
    public class tableclass implements IDepictable {

        String name;
        String StartDatum;
        String EndDatum;
        String Status;
        String Teilnehmeranzahl;

        public tableclass(String name, String StartDatum, String EndDatum, String Status, String Teilnehmeranzahl) {
            this.name = name;
            this.StartDatum = StartDatum;
            this.EndDatum = EndDatum;
            this.Status = Status;
            this.Teilnehmeranzahl = Teilnehmeranzahl;
        }

        public String getName() {
            return name;
        }

        @Override
        public String getElementID() {
            return this.name;
        }

        @Override
        public Attribute[] getAttributeArray() {
            return new Attribute[]{
                    new Attribute("name",
                            this.name,
                            String.class,
                            this.name,
                            "name",
                            true,
                            true,
                            true
                    ),
                    new Attribute("Start Datum",
                            this.StartDatum,
                            String.class,
                            this.StartDatum,
                            "StartDatum",
                            true,
                            true,
                            true
                    ),
                    new Attribute("End Datum",
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
                    new Attribute("Teilnehmeranzahl",
                            this.Teilnehmeranzahl,
                            String.class,
                            this.Teilnehmeranzahl,
                            "Teilnehmeranzahl",
                            true,
                            true,
                            true
                    )
            };
        }
        //Attribute(String name, Object dedicatedInstance, Class<?> clazz, Object value, Object defaultValue, boolean visible, boolean modifiable, boolean editable)
    }

}

