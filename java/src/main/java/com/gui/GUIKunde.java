package com.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.model.event.*;
import com.model.dataTypes.*;
import com.model.person.*;

import com.gui.Interface.GUIDateTimeSelectorInterface;

import com.model.event.Teilevent;
import com.model.person.ExternBeauftragter;
import com.model.person.Mitarbeiter;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import de.dhbwka.swe.utils.gui.*;
import de.dhbwka.swe.utils.gui.TextComponent;

public class GUIKunde extends GUIComponent implements IGUIEventListener{

    private JPanel jp = new JPanel();
    public JPanel getOverviewPanel(){return  jp;}

    private GridBagLayout gbl;
    private GridBagConstraints gbcLeftSide;
    private JFrame frame;

    private Label labelVorname;
    private Label labelNachname;
    private Label labelEmail;
    private Label labelTelefonnummer;
    private Label labelAnschrift;
    private Label labelBudget;

    private TextComponent textVorname;
    private TextComponent textNachname;
    private TextComponent textEmail;
    private TextComponent textTelefonnummer;
    private TextComponent textAnschrift;
    private TextComponent textBudget;

    private ButtonElement[] OKButtonElement;
    private ButtonComponent OKButtonComponent;
    // Vertrag button?


    public GUIKunde(JFrame frame, Kunde kunde){
        this.frame = frame;
        gbl = new GridBagLayout();
        jp.setLayout(gbl);


        gbcLeftSide = new GridBagConstraints();
        gbcLeftSide.weighty = 1;
        gbcLeftSide.anchor = GridBagConstraints.NORTHWEST;
        gbcLeftSide.fill = GridBagConstraints.BOTH;
        gbcLeftSide.insets = new Insets(5, 5, 5, 5);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 0;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelVorname = new Label("Vorname");
        gbl.setConstraints(labelVorname, gbcLeftSide);
        jp.add(labelVorname);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 0;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        textVorname = TextComponent.builder("textVorname").initialText(kunde.getKontaktdaten().getVorname()).build();
        gbl.setConstraints(textVorname, gbcLeftSide);
        jp.add(textVorname);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 1;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelNachname = new Label("Nachname");
        gbl.setConstraints(labelNachname, gbcLeftSide);
        jp.add(labelNachname);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 1;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        textNachname = TextComponent.builder("textNachname").initialText(kunde.getKontaktdaten().getNachname()).build();
        gbl.setConstraints(textNachname, gbcLeftSide);
        jp.add(textNachname);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 2;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelEmail = new Label("Email");
        gbl.setConstraints(labelEmail, gbcLeftSide);
        jp.add(labelEmail);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 2;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        textEmail = TextComponent.builder("textEmail").initialText(kunde.getKontaktdaten().getEmail().getGesamteEmail()).build();
        gbl.setConstraints(textEmail, gbcLeftSide);
        jp.add(textEmail);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 3;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelTelefonnummer = new Label("Telefonnummer");
        gbl.setConstraints(labelTelefonnummer, gbcLeftSide);
        jp.add(labelTelefonnummer);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 3;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        textTelefonnummer = TextComponent.builder("textTelefonnummer").initialText(Long.toString(kunde.getKontaktdaten().getTelefonnummer().getGesamteNummer())).build();
        gbl.setConstraints(textTelefonnummer, gbcLeftSide);
        jp.add(textTelefonnummer);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 4;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelAnschrift = new Label("Anschrift");
        gbl.setConstraints(labelAnschrift, gbcLeftSide);
        jp.add(labelAnschrift);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 4;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        textAnschrift = TextComponent.builder("textAnschrift").initialText(kunde.getKontaktdaten().getAnschrift().getGesamteAdresse()).build();
        gbl.setConstraints(textAnschrift, gbcLeftSide);
        jp.add(textAnschrift);

        gbcLeftSide.gridx = 5;
        gbcLeftSide.gridy = 1;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelBudget = new Label("Budget");
        gbl.setConstraints(labelBudget, gbcLeftSide);
        jp.add(labelBudget);

        gbcLeftSide.gridx = 5;
        gbcLeftSide.gridy = 1;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        textBudget = TextComponent.builder("textBudget").initialText(Double.toString(kunde.getBudget())).build();
        gbl.setConstraints(textBudget, gbcLeftSide);
        jp.add(textBudget);


        gbcLeftSide.gridx = 6;
        gbcLeftSide.gridy = 12;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        OKButtonElement = new ButtonElement[]{ ButtonElement.builder("OKButtonElement")
                .buttonText("OK")
                .type(ButtonElement.Type.BUTTON)
                .build()};

        OKButtonComponent = ButtonComponent
                .builder("OKButtonComponent")
                .buttonElements(OKButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();


        OKButtonComponent.addObserver(this);
        gbl.setConstraints(OKButtonComponent, gbcLeftSide);
        jp.add(OKButtonComponent);

    }

    @Override
    public void processGUIEvent(GUIEvent ge) {
        if (ge.getCmd().equals(ButtonComponent.Commands.BUTTON_PRESSED)) {
            if (((ButtonElement) ge.getData()).getID().equals("OKButtonElement")) {
                frame.dispose();
            }
        }
    }
}
