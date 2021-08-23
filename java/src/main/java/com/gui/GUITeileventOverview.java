package com.gui;

import com.databaseInterface.Eventverwaltung;
import com.model.event.Hauptevent;
import com.model.event.Teilevent;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import de.dhbwka.swe.utils.gui.SimpleTableComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUITeileventOverview implements IGUIEventListener {

    JPanel Center;
    JFrame frame;
    List<Teilevent> Teilevents;
    public GUITeileventOverview(List<Teilevent> Teilevents){
        this.Teilevents = Teilevents;
        frame = new JFrame();

        frame.setTitle("Teilevents");

        frame.pack();
        frame.setMinimumSize(new Dimension(1000,    600));
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());

        Center = new JPanel();
        Center.setLayout(new BoxLayout(Center, BoxLayout.X_AXIS));

        GUITeilEventList EventList = new GUITeilEventList(Teilevents, this);
        Center.add(EventList.getTable());

        GUITeilevent event = new GUITeilevent();
        Center.add(event);

        frame.add(Center);
        frame.pack();
        frame.repaint();
    }

    @Override
    public void processGUIEvent(GUIEvent ge) {
        if(ge.getCmd().equals(SimpleTableComponent.Commands.MULTIPLE_ROWS_SELECTED)){
            String t = ((List<GUITeilEventList.tableclass>)ge.getData()).get(0).getName();

            for (int i = 0; i < Teilevents.size(); i++) {
                if(Teilevents.get(i).getBezeichnung() == t){
                    GUITeilevent teilevent = new GUITeilevent(Teilevents.get(i));
                    Center.remove(1);
                    Center.add(teilevent.getOverviewPanel());
                    frame.pack();
                }
            }
        }
    }
}
