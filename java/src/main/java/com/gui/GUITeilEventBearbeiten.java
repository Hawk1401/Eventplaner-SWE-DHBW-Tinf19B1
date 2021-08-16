package com.gui;

import javax.swing.*;
import java.awt.*;
import de.dhbwka.swe.utils.gui.*;
import de.dhbwka.swe.utils.gui.TextComponent;

public class GUITeilEventBearbeiten extends GUIComponent{
    private JPanel jp = new JPanel();
    public JPanel getOverviewPanel(){return  jp;}

    public GUITeilEventBearbeiten(){
        GridBagLayout gbl = new GridBagLayout();
        jp.setLayout(gbl);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        Label labelTeileventName = new Label("Teilevent");
        gbl.setConstraints(labelTeileventName, gbc);
        jp.add(labelTeileventName);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        TextComponent textFieldTeileventName = TextComponent.builder("t").initialText("Band Schräge Musik").build();
        gbl.setConstraints(textFieldTeileventName, gbc);
        jp.add(textFieldTeileventName);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        Label labelZugehoerigeHauptevent = new Label("ZuGehöriges HauptEvent");
        gbl.setConstraints(labelZugehoerigeHauptevent, gbc);
        jp.add(labelZugehoerigeHauptevent);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        AttributeElement ZugeoerigeHaupteventComboboxElement = AttributeElement.builder("ZugeoerigeHaupteventComboboxElement")
                        .labelName(" ")
                        .actionType(AttributeElement.ActionType.COMBOBOX)
                        .build();
        gbl.setConstraints(ZugeoerigeHaupteventComboboxElement, gbc);
        jp.add(ZugeoerigeHaupteventComboboxElement);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        Label labelKunde = new Label("Kunde");
        gbl.setConstraints(labelKunde, gbc);
        jp.add(labelKunde);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        AttributeElement KundeComboboxElement = AttributeElement.builder("KundeComboboxElement")
                        .labelName(" ")
                        .actionType(AttributeElement.ActionType.COMBOBOX)
                        .build();
        gbl.setConstraints(KundeComboboxElement, gbc);
        jp.add(KundeComboboxElement);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        Label labelStartDatum = new Label("Start Datum");
        gbl.setConstraints(labelStartDatum, gbc);
        jp.add(labelStartDatum);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        CalendarComponent calendarComponentStartDatum = new CalendarComponent.CCBuilder().build();
        gbl.setConstraints(calendarComponentStartDatum, gbc);
        jp.add(calendarComponentStartDatum);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        Label labelEndDatum = new Label("End Datum");
        gbl.setConstraints(labelEndDatum, gbc);
        jp.add(labelEndDatum);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        CalendarComponent calendarComponentEndDatum = new CalendarComponent.CCBuilder().build();
        gbl.setConstraints(calendarComponentEndDatum, gbc);
        jp.add(calendarComponentEndDatum);

    }
}
