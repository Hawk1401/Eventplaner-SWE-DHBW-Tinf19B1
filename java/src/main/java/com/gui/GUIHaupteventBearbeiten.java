package com.gui;

import com.databaseInterface.Eventverwaltung;
import com.gui.Interface.GUIDateTimeSelectorInterface;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import de.dhbwka.swe.utils.gui.AttributeElement;
import de.dhbwka.swe.utils.gui.ButtonComponent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.TextComponent;
import de.dhbwka.swe.utils.gui.*;
import com.model.person.*;
import com.model.dataTypes.*;
import com.model.event.*;
import com.model.Vertrag;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GUIHaupteventBearbeiten extends GUIComponent implements GUIDateTimeSelectorInterface, IGUIEventListener {

    private JPanel jp = new JPanel();
    public JPanel getOverviewPanel(){return  jp;}

    private GridBagConstraints gbcLeftSide;
    private GridBagLayout gbl;

    private Label labelHaupteventName;
    private Label labelOrganisator;
    private Label labelVertrag;
    private Label labelDatum;
    private Label labelListeTeilEvents;
    private Label labelBudget;
    private Label labelAnazahl;
    private Label labelBeschreibung;
    private Label labelStatus;
    private Label labelBilder;

    private TextComponent textFieldHaupteventName;
    private TextComponent budget;
    private TextComponent teilnehmerAnazahl;

    private AttributeElement OrganisatorComboboxElement;
    private AttributeElement StatusComboboxElement;

    private ButtonElement[] VertragButtonElement;
    private ButtonElement[] DatumButtonElement;
    private ButtonElement[]  TeilEventAnzeigenButtonElement;
    private ButtonElement[] BildButtonElement;

    private ButtonComponent VertragButtonComponent;
    private ButtonComponent DatumButtonComponent;
    private ButtonComponent TeilEventAnzeigenComponent;
    private ButtonComponent BildButtonComponent;

    private SimpleTableComponent tabelleTeilevents;
    private JTextArea extendetTextFieldBeschreibung;
    private JScrollPane scrollPane;

    //private GUIEventlist guiEventlist = new GUIEventlist(this);
    private JFrame frame;
    private Hauptevent hauptevent;

    public GUIHaupteventBearbeiten(JFrame frame, Hauptevent hauptevent){
        this.hauptevent = hauptevent;
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
        labelHaupteventName = new Label("Hauptevent");
        gbl.setConstraints(labelHaupteventName, gbcLeftSide);
        jp.add(labelHaupteventName);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 0;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;

   String HaupteventName = hauptevent.getBezeichnung();
        textFieldHaupteventName = TextComponent.builder("textFieldHaupteventName").initialText(HaupteventName).build();
        gbl.setConstraints(textFieldHaupteventName, gbcLeftSide);
        jp.add(textFieldHaupteventName);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 1;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelOrganisator = new Label("Organisator");
        gbl.setConstraints(labelOrganisator, gbcLeftSide);
        jp.add(labelOrganisator);


        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 1;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;
        OrganisatorComboboxElement = AttributeElement.builder("OrganisatorComboboxElement")
                .labelName(" ")
                .actionType(AttributeElement.ActionType.COMBOBOX)
                .build();
        ArrayList<Mitarbeiter> mitarbeiter = Eventverwaltung.getInstance().getListeMitarbeiter();
        ArrayList<String> organisatorenName = new ArrayList<>();

        for (int i = 0; i < mitarbeiter.size(); i++) {
            if(mitarbeiter.get(i).getRolle() == Rolle.ORGANISATOR){
                organisatorenName.add(mitarbeiter.get(i).getKontaktdaten().getEmail().getAdresse());
            }
        }
        OrganisatorComboboxElement.setData(organisatorenName);
        gbl.setConstraints(OrganisatorComboboxElement, gbcLeftSide);
        jp.add(OrganisatorComboboxElement);


        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 2;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelVertrag = new Label("Vertrag mit Kunden");
        gbl.setConstraints(labelVertrag, gbcLeftSide);
        jp.add(labelVertrag);



        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 2;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;
        VertragButtonElement = new ButtonElement[]{ ButtonElement.builder("VertragSpeichernButtonElement")
                .buttonText("Vertrag Speichern")
                .type(ButtonElement.Type.BUTTON)
                .build(),
                ButtonElement.builder("VertragAnsehnButtonElement")
                        .buttonText("Vertrag anzeigen")
                        .type(ButtonElement.Type.BUTTON)
                        .build()};

        VertragButtonComponent = ButtonComponent
                .builder("VertragButtonComponent")
                .buttonElements(VertragButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();

        VertragButtonComponent.addObserver(this);
        gbl.setConstraints(VertragButtonComponent, gbcLeftSide);
        jp.add(VertragButtonComponent);



        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 3;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelDatum = new Label("Start/End Datum");
        gbl.setConstraints(labelDatum, gbcLeftSide);
        jp.add(labelDatum);



        String StartDatum = hauptevent.getStart_Termin().getDatum();
        String EndDatum = hauptevent.getEnd_Termin().getDatum();
        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 3;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;
        DatumButtonElement = new ButtonElement[]{ ButtonElement.builder("StartDatumButtonElement")
                .buttonText(StartDatum)
                .type(ButtonElement.Type.BUTTON)
                .build(),
                ButtonElement.builder("EndDatumButtonElement")
                        .buttonText(EndDatum)
                        .type(ButtonElement.Type.BUTTON)
                        .build()};

        DatumButtonComponent = ButtonComponent
                .builder("StartDatumButtonComponent")
                .buttonElements(DatumButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();


        DatumButtonComponent.addObserver(this);
        gbl.setConstraints(DatumButtonComponent, gbcLeftSide);
        jp.add(DatumButtonComponent);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 4;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelListeTeilEvents = new Label("Liste der TeilEvents");
        gbl.setConstraints(labelListeTeilEvents, gbcLeftSide);
        jp.add(labelListeTeilEvents);


        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 4;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;
        //gbcLeftSide.ipady = 40;
        TeilEventAnzeigenButtonElement = new ButtonElement[]{ ButtonElement.builder("TeilEventAnzeigenButtonElement")
                .buttonText("TeilEvent Anzeigen")
                .type(ButtonElement.Type.BUTTON)
                .build()};

        TeilEventAnzeigenComponent = ButtonComponent
                .builder("TeileventListeButtonComponent")
                .buttonElements(TeilEventAnzeigenButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();


        TeilEventAnzeigenComponent.addObserver(this);
        gbl.setConstraints(TeilEventAnzeigenComponent, gbcLeftSide);
        jp.add(TeilEventAnzeigenComponent);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 5;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        gbcLeftSide.ipady = 0;
        labelBudget = new Label("Budget");
        gbl.setConstraints(labelBudget, gbcLeftSide);
        jp.add(labelBudget);


        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 5;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;
        String budeged = Double.toString(hauptevent.getKosten());
        budget = TextComponent.builder("textFieldBudget").initialText(budeged).build();
        gbl.setConstraints(budget, gbcLeftSide);
        jp.add(budget);


        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 7;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelAnazahl = new Label("Anzahl der Teilnehmer");
        gbl.setConstraints(labelAnazahl, gbcLeftSide);
        jp.add(labelAnazahl);


        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 7;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;
        String anzahl = Integer.toString(hauptevent.getTeilnehmeranzahl());
        teilnehmerAnazahl = TextComponent.builder("textFieldAnzahl").initialText(anzahl).build();
        gbl.setConstraints(teilnehmerAnazahl, gbcLeftSide);
        jp.add(teilnehmerAnazahl);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 8;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelBeschreibung = new Label("Beschreibung");
        gbl.setConstraints(labelBeschreibung, gbcLeftSide);
        jp.add(labelBeschreibung);


        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 9;
        gbcLeftSide.gridwidth = 3;
        gbcLeftSide.gridheight = 1;
        extendetTextFieldBeschreibung = new JTextArea();
        String beschreibung = hauptevent.getBeschreibung();
        extendetTextFieldBeschreibung.setText(beschreibung);
        scrollPane = new JScrollPane(extendetTextFieldBeschreibung);
        gbl.setConstraints(scrollPane, gbcLeftSide);
        jp.add(scrollPane);


        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 10;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelStatus = new Label("Status");
        gbl.setConstraints(labelStatus, gbcLeftSide);
        jp.add(labelStatus);


        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 10;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;
        StatusComboboxElement = AttributeElement.builder("StatusComboboxElement")
                .labelName(" ")
                .actionType(AttributeElement.ActionType.COMBOBOX)
                .build();

        StatusComboboxElement.setData(Status.getNames(Status.class));
        StatusComboboxElement.setValue(hauptevent.getStatus());
        gbl.setConstraints(StatusComboboxElement, gbcLeftSide);
        jp.add(StatusComboboxElement);


        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 11;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelBilder = new Label("Bilder");
        gbl.setConstraints(labelBilder, gbcLeftSide);
        jp.add(labelBilder);


        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 11;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;
        BildButtonElement = new ButtonElement[]{ ButtonElement.builder("BildHochladenButtonElement")
                .buttonText("Bild Hochladen")
                .type(ButtonElement.Type.BUTTON)
                .build(),
                ButtonElement.builder("BildAnzeiheigenButtonElement")
                        .buttonText("Bild anzeigen")
                        .type(ButtonElement.Type.BUTTON)
                        .build()};

        BildButtonComponent = ButtonComponent
                .builder("StartDatumButtonComponent")
                .buttonElements(BildButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();


        BildButtonComponent.addObserver(this);
        gbl.setConstraints(BildButtonComponent, gbcLeftSide);
        jp.add(BildButtonComponent);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 12;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;
        ButtonElement[] CancleSubmitButtonElement = new ButtonElement[]{ ButtonElement.builder("CancleButtonElement")
                .buttonText("Abbrechen")
                .type(ButtonElement.Type.BUTTON)
                .build(),
                ButtonElement.builder("SubmitButtonElement")
                        .buttonText("Bestätigen")
                        .type(ButtonElement.Type.BUTTON)
                        .build()};

        ButtonComponent CancleSubmitButtonComponent = ButtonComponent
                .builder("CancleSubmitButtonComponent")
                .buttonElements(CancleSubmitButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();


        CancleSubmitButtonComponent.addObserver(this);
        gbl.setConstraints(CancleSubmitButtonComponent, gbcLeftSide);
        jp.add(CancleSubmitButtonComponent);
    }



    @Override
    public void processGUIEvent(GUIEvent ge) {
        if (ge.getCmd().equals(ButtonComponent.Commands.BUTTON_PRESSED)) {
            try {
                if (((ButtonElement) ge.getData()).getID().equals("StartDatumButtonElement")) {
                    GUIDateTimeSelector g = new GUIDateTimeSelector(this, "Start");
                }
                if (((ButtonElement) ge.getData()).getID().equals("EndDatumButtonElement")) {
                    GUIDateTimeSelector g = new GUIDateTimeSelector(this, "End");
                }
                if (((ButtonElement) ge.getData()).getID().equals("BildHochladenButtonElement")) {

                }
                if (((ButtonElement) ge.getData()).getID().equals("BildAnzeiheigenButtonElement")) {

                }
                if (((ButtonElement) ge.getData()).getID().equals("VertragSpeichernButtonElement")) {

                }
                if (((ButtonElement) ge.getData()).getID().equals("VertragAnsehnButtonElement")) {

                }

                if (((ButtonElement) ge.getData()).getID().equals("TeilEventAnzeigenButtonElement")) {
                    GUITeileventOverview list = new GUITeileventOverview(hauptevent.getListeTeilevent());
                }
                if (((ButtonElement) ge.getData()).getID().equals("CancleButtonElement")) {
                    this.frame.dispose();
                }
                if (((ButtonElement) ge.getData()).getID().equals("SubmitButtonElement")) {

                    String name = textFieldHaupteventName.getText();
                    //Mitarbeiter organisator = OrganisatorComboboxElement.getValue();
                    String organisatorname = OrganisatorComboboxElement.getValueAsString();
                    ArrayList<Mitarbeiter> mitarbeiter = Eventverwaltung.getInstance().getListeMitarbeiter();
                    for (int i = 0; i < mitarbeiter.size(); i++) {
                        if(organisatorname == mitarbeiter.get(i).getKontaktdaten().getEmail().getGesamteEmail()){
                            this.hauptevent.setOrganisator(mitarbeiter.get(i));
                        }
                    }
                    // Vertrag
                    // Teileventeliste

                    double bbudget = Double.parseDouble(budget.getText());
                    int teilnehmeranzahl = Integer.parseInt(teilnehmerAnazahl.getText());
                    String beschreibungen = extendetTextFieldBeschreibung.getText();
                    Status status = Status.valueOf(StatusComboboxElement.getValueAsString());
                    // bilder


                    this.hauptevent.setEnd_Termin(new Datum(DatumButtonElement[0].getButtonText()));
                    this.hauptevent.setStart_Termin(new Datum(DatumButtonElement[1].getButtonText()));
                    this.hauptevent.setStatus(status);
                    this.hauptevent.setStatus(status);
                    this.hauptevent.setBeschreibung(beschreibungen);
                    this.hauptevent.setTeilnehmeranzahl(teilnehmeranzahl);
                    this.hauptevent.setKosten(bbudget);
                    this.hauptevent.setBezeichnung(name);

                    this.frame.dispose();
                }
            }catch (Exception e){

                int i = 0;
            }
            try {
                if (((AttributeElement) ge.getData()).getID().equals("OrganisatorComboboxElement")) {
                    // wie bekomme ich das selektierte Element??
                }
            }
            catch (Exception e) {

            }
        }
    }

    @Override
    public void SetTimeSeletet(Timestamp timestamp, String id) {
        String s = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(timestamp);
        if(id.equals("Start")){
            DatumButtonElement[0].setButtonText(s);
        }
        if(id.equals("End")){
            DatumButtonElement[0].setButtonText(s);
        }
    }
}
