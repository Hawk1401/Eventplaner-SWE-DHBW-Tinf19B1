package com.gui;

import com.model.event.Hauptevent;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import de.dhbwka.swe.utils.gui.*;
import de.dhbwka.swe.utils.gui.TextComponent;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;

import javax.swing.*;
import java.awt.*;

public class GUIHauptevent extends GUIComponent implements IGUIEventListener {

    private JPanel jp = new JPanel();

    public JPanel getOverviewPanel() {
        return jp;
    }

    Hauptevent hauptevent;


    TextComponent textFieldTeileventName;
    TextComponent textFieldStartDatum;
    TextComponent textFieldEndDatum;
    TextComponent EventStatusTextField;
    ButtonElement[] EventKundeButtonElement;
    JTextArea extendetTextFieldBeschreibung;
    TextComponent textFieldKosten;

    public GUIHauptevent(Hauptevent hauptevent) {
        this.hauptevent = hauptevent;

        String Name = hauptevent.getBezeichnung();
        String startTermin =hauptevent.getStart_Termin().getDatum() ;
        String endTermin =hauptevent.getEnd_Termin().getDatum() ;
        String status = hauptevent.getStatus().toString();
        String Beschreibung = hauptevent.getBeschreibung();
        String Kosten = Double.toString(hauptevent.getKosten());
        buildUI(Name, startTermin, endTermin, status, Beschreibung, Kosten);

    }

    public void buildUI(String Name,
    String startTermin,
    String endTermin,
    String status,
    String Beschreibung,
    String Kosten){

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
        Label labelEventName = new Label("Event");
        gbl.setConstraints(labelEventName, gbc);
        jp.add(labelEventName);

        textFieldTeileventName = TextComponent.builder("t").initialText(Name).editable(false).build();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(textFieldTeileventName, gbc);
        jp.add(textFieldTeileventName);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        Label labelDatum = new Label("Datum");
        gbc.gridheight = 1;
        gbl.setConstraints(labelDatum, gbc);
        jp.add(labelDatum);


        textFieldStartDatum = TextComponent.builder("textFieldStartDatum").initialText(startTermin).editable(false).build();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(textFieldStartDatum, gbc);
        jp.add(textFieldStartDatum);


        textFieldEndDatum = TextComponent.builder("textFieldEndDatum").initialText(endTermin).editable(false).build();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(textFieldEndDatum, gbc);
        jp.add(textFieldEndDatum);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        Label labelStatus = new Label("Status");
        gbl.setConstraints(labelStatus, gbc);
        jp.add(labelStatus);


        EventStatusTextField = TextComponent.builder("textFieldStatus").initialText(status).editable(false).build();

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(EventStatusTextField, gbc);
        jp.add(EventStatusTextField);


        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        Label labelKunde = new Label("Kunde");
        gbl.setConstraints(labelKunde, gbc);
        jp.add(labelKunde);


        EventKundeButtonElement = new ButtonElement[]{ButtonElement.builder("EventKundeButtonElement")
                .buttonText("Kunden info")
                .type(ButtonElement.Type.BUTTON)
                .build()};


        ButtonComponent buttonComponentEventKunde = ButtonComponent
                .builder("buttonComponentEventKunde")
                .buttonElements(EventKundeButtonElement)
                .buttonSize(new Dimension(200, 40))
                .position(ButtonComponent.Position.NORTH)
                .build();

        buttonComponentEventKunde.addObserver(this);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbl.setConstraints(buttonComponentEventKunde, gbc);
        jp.add(buttonComponentEventKunde);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 0;
        Label labelBeschreibung = new Label("Beschreibung");
        gbl.setConstraints(labelBeschreibung, gbc);
        jp.add(labelBeschreibung);

        extendetTextFieldBeschreibung = new JTextArea();
        extendetTextFieldBeschreibung.setText(Beschreibung);
        extendetTextFieldBeschreibung.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(extendetTextFieldBeschreibung);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.ipady = 40;
        gbl.setConstraints(scrollPane, gbc);
        jp.add(scrollPane);


        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 0;
        Label labelKosten = new Label("Kosten");
        gbl.setConstraints(labelKosten, gbc);
        jp.add(labelKosten);

        textFieldKosten = TextComponent.builder("textFieldKosten").initialText(Kosten).editable(false).build();
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(textFieldKosten, gbc);
        jp.add(textFieldKosten);


        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;

        JButton btnBerabeiten = new JButton("Event Bearbeiten");

        ButtonElement[] btns = new ButtonElement[]{
                ButtonElement.builder("btnBerabeiten")
                        .buttonText("Event Bearbeiten")
                        .type(ButtonElement.Type.BUTTON)
                        .build()
        };

        ButtonComponent buttonComponentDateTimeSelector = ButtonComponent
                .builder("buttonComponentbtnBerabeiten")
                .buttonElements(btns)
                .buttonSize(new Dimension(200, 40))
                .position(ButtonComponent.Position.NORTH)
                .build();

        buttonComponentDateTimeSelector.addObserver(this);

        gbl.setConstraints(buttonComponentDateTimeSelector, gbc);
        jp.add(buttonComponentDateTimeSelector);
    }

    public GUIHauptevent() {

        String Name = "";
        String startTermin = "" ;
        String endTermin = "";
        String status =  "";
        String Beschreibung =  "";
        String Kosten =  "";
        buildUI(Name, startTermin, endTermin, status, Beschreibung, Kosten);
    }

    @Override
    public void processGUIEvent(GUIEvent ge) {
        if (ge.getCmd().equals(ButtonComponent.Commands.BUTTON_PRESSED)) {
            if (((ButtonElement) ge.getData()).getID().equals("btnBerabeiten") && this.hauptevent != null) {
                JFrame frame = new JFrame();
                GUIHaupteventBearbeiten guiHaupteventBearbeiten = new GUIHaupteventBearbeiten(frame, this.hauptevent);
                frame.add(guiHaupteventBearbeiten.getOverviewPanel());
                frame.pack();
                frame.setMinimumSize(new Dimension(800,    600));
                frame.setVisible(true);
            }
            if (((ButtonElement) ge.getData()).getID().equals("EventKundeButtonElement")) {
                JFrame frame = new JFrame();
                if(this.hauptevent.getVertrag() == null){
                    JOptionPane.showMessageDialog(frame,
                            "Keine Kunden Infos hinterlegt");
                }else{
                    GUIKunde kunde = new GUIKunde(frame, this.hauptevent.getVertrag().getKunde());
                    frame.add(kunde.getOverviewPanel());
                    frame.pack();
                    frame.setMinimumSize(new Dimension(800,    600));
                    frame.setVisible(true);

                }


            }
        }
    }
}
