package com.gui;

import javax.swing.*;
import java.awt.*;

public class GUIOverview extends GUIComponent{

    //TODO still nothing there
    private JPanel panel = new JPanel();
    public JPanel getOverviewPanel(){return  panel;}

    public GUIOverview() {

        GUISuche guiSuche = new GUISuche();
        panel.setLayout(new BorderLayout());

        GUIEventlist guiEventlist = new GUIEventlist();
        panel.add(guiSuche.getAttributeComponent(), BorderLayout.NORTH);
        panel.add(guiEventlist.getTable(), BorderLayout.SOUTH);

    }


}
