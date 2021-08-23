package com.gui;

import de.dhbwka.swe.utils.event.IGUIEventListener;

import javax.swing.*;
import java.awt.*;

public class GUIOverview extends GUIComponent{

    //TODO still nothing there
    private JPanel panel = new JPanel();
    public JPanel getOverviewPanel(){return  panel;}

    public GUIOverview(IGUIEventListener obs) {

        GUISuche guiSuche = new GUISuche();
        panel.setLayout(new BorderLayout());

        GUIEventlist guiEventlist = new GUIEventlist(obs);
        panel.add(guiSuche.getAttributeComponent(), BorderLayout.NORTH);
        panel.add(guiEventlist.getTable(), BorderLayout.SOUTH);
    }


}
