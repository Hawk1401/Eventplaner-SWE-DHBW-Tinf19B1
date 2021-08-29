package com.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import com.databaseInterface.Eventverwaltung;
import org.javatuples.Pair;

import com.model.dataTypes.Anschrift;
import com.model.event.*;

import com.gui.Interface.GUIDateTimeSelectorInterface;
import com.model.dataTypes.Datum;
import com.model.dataTypes.Status;
import com.model.dataTypes.Rolle;
import com.model.event.Teilevent;
import com.model.person.ExternBeauftragter;
import com.model.person.Mitarbeiter;
import com.model.person.Kunde;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import de.dhbwka.swe.utils.gui.*;
import de.dhbwka.swe.utils.gui.TextComponent;
import de.dhbwka.swe.utils.model.IDepictable;
import de.dhbwka.swe.utils.model.Attribute;


public class GUITeilEventBearbeiten extends GUIComponent implements GUIDateTimeSelectorInterface, IGUIEventListener {
    private JPanel jp = new JPanel();
    public JPanel getOverviewPanel(){return  jp;}
    private GUIexternBeauftragter gUIexternBeauftragter = new GUIexternBeauftragter();

    private Label labelTeileventName;
    private Label labelZugehoerigeHauptevent;
    private Label labelKunde;
    private Label labelStartDatum;
    private Label labelEndDatum;
    private Label labelMitarbeiter;
    private Label labelHilfsmittel;
    private Label labelHilfsmittelAnzahl;
    private Label labelKosten;
    private Label labelBeschreibung;
    private Label labelStandort;
    private Label labelMontageLeiter;
    private Label labelGruppenLeiter;
    private Label labelStatus;
    private Label labelTeilnehmerzahl;

    private TextComponent textFieldTeileventName;
    private TextComponent textFieldKosten;
    private TextComponent textFieldStandort;
    private TextComponent textFieldTeilnehmerzahl;
    private TextComponent textFieldHilfsmittelAnzahl;
    private JTextArea extendetTextFieldBeschreibung;

    private AttributeElement ZugeoerigeHaupteventComboboxElement;
    private AttributeElement KundeComboboxElement;
    private AttributeElement MitarbeiterComboboxElement;
    private AttributeElement HilfsmittelComboboxElement;
    private AttributeElement MontageLeiterComboboxElement;
    private AttributeElement GruppenLeiterComboboxElement;
    private AttributeElement StatusComboboxElement;

    private SimpleTableComponent tableMitarbeiter;
    private SimpleTableComponent tableHilfsmittel;



    private ButtonElement[] StartDatumButtonElement;
    private ButtonElement[] EndDatumButtonElement;
    private ButtonElement[] SubmitButtonElement;
    private ButtonElement[] CancleButtonElement;
    private ButtonElement[] EventMitarbiterHinzufuegenButtonElement;
    private ButtonElement[] EventMitarbiterEntfernenButtonElement;
    private ButtonElement[] EventHilfsmittelHinzufuegenButtonElement;
    private ButtonElement[] EventHilfsmittelEntfernenButtonElement;
    private JScrollPane scrollPane;

    private ButtonComponent StartDatumButtonComponent;
    private ButtonComponent EndDatumButtonComponent;
    private ButtonComponent SubmitButtonComponent;
    private ButtonComponent CancleButtonComponent;
    private ButtonComponent MitarbiterHinzufuegenButtonComponent;
    private ButtonComponent MitarbiterEntfernenButtonComponent;
    private ButtonComponent HilfsmittelHinzufuegenButtonComponent;
    private ButtonComponent HilfsmittelEntfernenButtonComponent;

    private Mitarbeiter selectedMitarbeiter;
    IDepictable[] elemsMitarbeiter;
    IDepictable[] elemsHilfsmittel;

    private Teilevent _teilevent;
    private JFrame _frame;

    public GUITeilEventBearbeiten(Teilevent teilevent, JFrame frame ){
        this._teilevent = teilevent;
        this._frame = frame;

        String bezeichnung = teilevent.getBezeichnung();
        Datum startTermin = teilevent.getStart_Termin();
        Datum endTermin = teilevent.getEnd_Termin();
        String beschreibung = teilevent.getBeschreibung();
        Status status = teilevent.getStatus();
        double kosten = teilevent.getKosten();
        int teilnehmer = teilevent.getTeilnehmeranzahl();
        ExternBeauftragter externbeauftragter = teilevent.getExternBeauftragter();
        Anschrift anschrift = teilevent.getStandort();
        ArrayList<Angebot> angebotslist = teilevent.getAngebotslist();
        Mitarbeiter montageLeiter = teilevent.getMontageLeiter();
        ArrayList<Mitarbeiter> montagePersonal = teilevent.getMontagePersonal();
        Mitarbeiter gruppenleiterBeschaffung = teilevent.getGruppenleiterBeschaffung();
        ArrayList<Mitarbeiter> beschaffungsPersonal = teilevent.getBeschaffungsPersonal();
        ArrayList<Pair<Hilfsmittel, Integer>> hilfsmittelMitAnzahl = teilevent.getHilfsmittel();
        Hauptevent hauptevent = teilevent.getHauptevent();





        GridLayout experimentLayout = new GridLayout(0,2);
        jp.setLayout(experimentLayout);
        JPanel jpLeftSide = new JPanel();
        GridBagLayout gblLeftSide = new GridBagLayout();
        jpLeftSide.setLayout(gblLeftSide);

        GridBagConstraints gbcLeftSide = new GridBagConstraints();
        gbcLeftSide.weighty = 1;
        gbcLeftSide.anchor = GridBagConstraints.NORTHWEST;
        gbcLeftSide.fill = GridBagConstraints.BOTH;
        gbcLeftSide.insets = new Insets(5, 5, 5, 5);


        JPanel jpRightSide = new JPanel();
        GridBagLayout gblRightSide = new GridBagLayout();
        jpRightSide.setLayout(gblRightSide);


        GridBagConstraints gbcRightSide = new GridBagConstraints();
        gbcRightSide.weighty = 1;
        gbcRightSide.anchor = GridBagConstraints.NORTHWEST;
        gbcRightSide.fill = GridBagConstraints.BOTH;
        gbcRightSide.insets = new Insets(5, 5, 5, 5);


        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 0;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelTeileventName = new Label("Teilevent");
        gblLeftSide.setConstraints(labelTeileventName, gbcLeftSide);
        jpLeftSide.add(labelTeileventName);


        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 0;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        textFieldTeileventName = TextComponent.builder("textFieldTeileventName").initialText(bezeichnung).build();
        gblLeftSide.setConstraints(textFieldTeileventName, gbcLeftSide);
        jpLeftSide.add(textFieldTeileventName);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 1;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelZugehoerigeHauptevent = new Label("ZuGehöriges HauptEvent");
        gblLeftSide.setConstraints(labelZugehoerigeHauptevent, gbcLeftSide);
        jpLeftSide.add(labelZugehoerigeHauptevent);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 1;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        ZugeoerigeHaupteventComboboxElement = AttributeElement.builder("ZugeoerigeHaupteventComboboxElement")
                        .labelName("  ")
                        .actionType(AttributeElement.ActionType.COMBOBOX)
                        .build();

        ArrayList<Hauptevent> hauptevents = Eventverwaltung.getInstance().getListeHauptevent();
        ArrayList<String> Names = new ArrayList<String>();

        for (int i = 0; i < hauptevents.size(); i++) {
            Names.add(hauptevents.get(i).getBezeichnung());
        }

        ZugeoerigeHaupteventComboboxElement.setData(Names.toArray());
        if(Names.contains(hauptevent.getBezeichnung())){
            ZugeoerigeHaupteventComboboxElement.setValue(hauptevent.getBezeichnung());
        }
        gblLeftSide.setConstraints(ZugeoerigeHaupteventComboboxElement, gbcLeftSide);
        jpLeftSide.add(ZugeoerigeHaupteventComboboxElement);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 2;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelKunde = new Label("Kunde");
        gblLeftSide.setConstraints(labelKunde, gbcLeftSide);
        jpLeftSide.add(labelKunde);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 2;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        KundeComboboxElement = AttributeElement.builder("KundeComboboxElement")
                        .labelName(" ")
                        .actionType(AttributeElement.ActionType.COMBOBOX)
                        .build();
        ArrayList<Kunde> kunden = Eventverwaltung.getInstance().getListeKunde();
        ArrayList<String> kundeName = new ArrayList<>();

        for (int i = 0; i < kunden.size(); i++) {
            kundeName.add(kunden.get(i).getKontaktdaten().getNachname());
        }
        KundeComboboxElement.setData(kundeName.toArray());
        if(hauptevent.getVertrag() != null){
            KundeComboboxElement.setValue(hauptevent.getVertrag().getKunde().getKontaktdaten().getNachname());

        }

        gblLeftSide.setConstraints(KundeComboboxElement, gbcLeftSide);
        jpLeftSide.add(KundeComboboxElement);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 3;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelStartDatum = new Label("Start Datum");
        gblLeftSide.setConstraints(labelStartDatum, gbcLeftSide);
        jpLeftSide.add(labelStartDatum);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 3;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        StartDatumButtonElement = new ButtonElement[]{ ButtonElement.builder("StartDatumButtonElement")
                .buttonText(startTermin.getDatum())
                .type(ButtonElement.Type.BUTTON)
                .build()};

        StartDatumButtonComponent = ButtonComponent
                .builder("StartDatumButtonComponent")
                .buttonElements(StartDatumButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();


        StartDatumButtonComponent.addObserver(this);
        gblLeftSide.setConstraints(StartDatumButtonComponent, gbcLeftSide);
        jpLeftSide.add(StartDatumButtonComponent);


        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 4;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelEndDatum = new Label("End Datum");
        gblLeftSide.setConstraints(labelEndDatum, gbcLeftSide);
        jpLeftSide.add(labelEndDatum);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 4;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        EndDatumButtonElement = new ButtonElement[] {ButtonElement.builder("EndDatumButtonElement")
                .buttonText(endTermin.getDatum())
                .type(ButtonElement.Type.BUTTON)
                .build()};

        EndDatumButtonComponent = ButtonComponent
                .builder("EndDatumButtonComponent")
                .buttonElements(EndDatumButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();

        EndDatumButtonComponent.addObserver(this);
        gblLeftSide.setConstraints(EndDatumButtonComponent, gbcLeftSide);
        jpLeftSide.add(EndDatumButtonComponent);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 8;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        gbcLeftSide.ipady = 0;
        labelMitarbeiter = new Label("Mitarbeiter");
        gblLeftSide.setConstraints(labelMitarbeiter, gbcLeftSide);
        jpLeftSide.add(labelMitarbeiter);


        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 8;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        MitarbeiterComboboxElement = AttributeElement.builder("MitarbeiterComboboxElement")
                .labelName(" ")
                .actionType(AttributeElement.ActionType.COMBOBOX)
                .build();
        ArrayList<Mitarbeiter> mitarbeiter = Eventverwaltung.getInstance().getListeMitarbeiter();
        ArrayList<String> mitarbieterName = new ArrayList<>();

        for (int i = 0; i < mitarbeiter.size(); i++) {
            if(mitarbeiter.get(i).getRolle() == Rolle.BESCHAFFUNGSPERSONAL || mitarbeiter.get(i).getRolle() == Rolle.MITARBEITER){
                mitarbieterName.add(mitarbeiter.get(i).getKontaktdaten().getEmail().getGesamteEmail());
            }

        }
        MitarbeiterComboboxElement.setData(mitarbieterName.toArray());
        gblLeftSide.setConstraints(MitarbeiterComboboxElement, gbcLeftSide);
        jpLeftSide.add(MitarbeiterComboboxElement);


        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 9;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;
        tableMitarbeiter = SimpleTableComponent.builder("tableMitarbeiter").selectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ).columnNames(new String[]{"Mitarbeiter"}).build();

        ArrayList<Mitarbeiter> mitarbeiters = _teilevent.getBeschaffungsPersonal();
        mitarbeiters.addAll(_teilevent.getMontagePersonal());
        // mitarbeiters.add(_teilevent.getMontageLeiter());
        // mitarbeiters.add(_teilevent.getGruppenleiterBeschaffung());

        elemsMitarbeiter = new IDepictable[mitarbeiters.size()];
        for (int i = 0; i < elemsMitarbeiter.length ; i++) {
           Mitarbeiter mitarbeiterString = mitarbeiters.get(i);
           elemsMitarbeiter[i] = new tableClassMitarbeiter(mitarbeiterString.getKontaktdaten().getEmail().getGesamteEmail());
        }

        tableMitarbeiter.setData(elemsMitarbeiter, new String[]{"eMail"});
        gblLeftSide.setConstraints(tableMitarbeiter, gbcLeftSide);
        jpLeftSide.add(tableMitarbeiter);


        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 10;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        EventMitarbiterHinzufuegenButtonElement = new ButtonElement[]{ ButtonElement.builder("EventMitarbiterHinzufuegenButtonElement")
                        .buttonText("Mitarbiter Hinzufuegen")
                        .type(ButtonElement.Type.BUTTON)
                        .build()};
        MitarbiterHinzufuegenButtonComponent = ButtonComponent
                .builder("MitarbiterHinzufuegenButtonComponent")
                .buttonElements(EventMitarbiterHinzufuegenButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();
        MitarbiterHinzufuegenButtonComponent.addObserver(this);
        gblLeftSide.setConstraints(MitarbiterHinzufuegenButtonComponent, gbcLeftSide);
        jpLeftSide.add(MitarbiterHinzufuegenButtonComponent);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 10;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        EventMitarbiterEntfernenButtonElement = new ButtonElement[]{ ButtonElement.builder("EventMitarbiterEntfernenButtonElement")
                        .buttonText("Mitarbiter Entfernen")
                        .type(ButtonElement.Type.BUTTON)
                        .build()};
        MitarbiterEntfernenButtonComponent = ButtonComponent
                .builder("MitarbiterEntfernenButtonComponent")
                .buttonElements(EventMitarbiterEntfernenButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();
        MitarbiterEntfernenButtonComponent.addObserver(this);
        gblLeftSide.setConstraints(MitarbiterEntfernenButtonComponent, gbcLeftSide);
        jpLeftSide.add(MitarbiterEntfernenButtonComponent);


        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 11;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelHilfsmittel = new Label("Hilfsmittel");
        gblLeftSide.setConstraints(labelHilfsmittel, gbcLeftSide);
        jpLeftSide.add(labelHilfsmittel);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 11;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        HilfsmittelComboboxElement = AttributeElement.builder("HilfsmittelComboboxElement")
                .labelName(" ")
                .actionType(AttributeElement.ActionType.COMBOBOX)
                .build();
        ArrayList<Hilfsmittel> hilfsmittel = Eventverwaltung.getInstance().getListeHilfsmittel();
        ArrayList<String> hilfsmittelName = new ArrayList<>();

        for (int i = 0; i < hilfsmittel.size(); i++) {
            hilfsmittelName.add(hilfsmittel.get(i).getBezeichnung());
        }
        HilfsmittelComboboxElement.setData(hilfsmittelName.toArray());
        gblLeftSide.setConstraints(HilfsmittelComboboxElement, gbcLeftSide);
        jpLeftSide.add(HilfsmittelComboboxElement);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 12;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        labelHilfsmittelAnzahl = new Label("Anzahl");
        gblLeftSide.setConstraints(labelHilfsmittelAnzahl, gbcLeftSide);
        jpLeftSide.add(labelHilfsmittelAnzahl);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 12;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;

        int count = 0;
        for (Pair<Hilfsmittel, Integer> Hilfsmittel:
        _teilevent.getHilfsmittel()) {
            count += Hilfsmittel.getValue1();
        }

        textFieldHilfsmittelAnzahl = TextComponent.builder("textFieldHilfsmittelAnzahl").initialText(Integer.toString(count)).build();
        gblLeftSide.setConstraints(textFieldHilfsmittelAnzahl, gbcLeftSide);
        jpLeftSide.add(textFieldHilfsmittelAnzahl);

        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 13;
        gbcLeftSide.gridwidth = 2;
        gbcLeftSide.gridheight = 1;
        tableHilfsmittel = SimpleTableComponent.builder("tableHilfsmittel").selectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ).columnNames(new String[]{"Hilfsmittel"}).build();
        ArrayList<Pair<Hilfsmittel, Integer>> hilfsmittelTeilevent = _teilevent.getHilfsmittel();

        elemsHilfsmittel = new IDepictable[hilfsmittelTeilevent.size()];
        for (int i = 0; i < elemsHilfsmittel.length ; i++) {
           Pair<Hilfsmittel, Integer> hilfsmittelAnzahlString = hilfsmittelTeilevent.get(i);
           elemsHilfsmittel[i] = new tableClassHilfsmittel(hilfsmittelAnzahlString.getValue0().getBezeichnung(), hilfsmittelAnzahlString.getValue1());
        }

        tableMitarbeiter.setData(elemsHilfsmittel, new String[]{"Bezeichnung", "Anzahl"});
        gblLeftSide.setConstraints(tableHilfsmittel, gbcLeftSide);
        jpLeftSide.add(tableHilfsmittel);


        gbcLeftSide.gridx = 0;
        gbcLeftSide.gridy = 14;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        EventHilfsmittelHinzufuegenButtonElement = new ButtonElement[]{ ButtonElement.builder("EventHilfsmittelHinzufuegenButtonElement")
                        .buttonText("Hilfsmittel Hinzufuegen")
                        .type(ButtonElement.Type.BUTTON)
                        .build()};
        HilfsmittelHinzufuegenButtonComponent = ButtonComponent
                .builder("HilfsmittelHinzufuegenButtonComponent")
                .buttonElements(EventHilfsmittelHinzufuegenButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();
        HilfsmittelHinzufuegenButtonComponent.addObserver(this);
        gblLeftSide.setConstraints(HilfsmittelHinzufuegenButtonComponent, gbcLeftSide);
        jpLeftSide.add(HilfsmittelHinzufuegenButtonComponent);

        gbcLeftSide.gridx = 1;
        gbcLeftSide.gridy = 14;
        gbcLeftSide.gridwidth = 1;
        gbcLeftSide.gridheight = 1;
        EventHilfsmittelEntfernenButtonElement = new ButtonElement[]{ ButtonElement.builder("EventHilfmittelEntfernenButtonElement")
                        .buttonText("Hilfsmittel Entfernen")
                        .type(ButtonElement.Type.BUTTON)
                        .build()};
        HilfsmittelEntfernenButtonComponent = ButtonComponent
                .builder("HilfsmittelEntfernenButtonComponent")
                .buttonElements(EventHilfsmittelEntfernenButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();
        HilfsmittelEntfernenButtonComponent.addObserver(this);
        gblLeftSide.setConstraints(HilfsmittelEntfernenButtonComponent, gbcLeftSide);
        jpLeftSide.add(HilfsmittelEntfernenButtonComponent);

        gbcRightSide.gridx = 0;
        gbcRightSide.gridy = 0;
        gbcRightSide.gridwidth = 2;
        gbcRightSide.gridheight = 5;
        gblRightSide.setConstraints(gUIexternBeauftragter.getExternBeauftragtePanel(), gbcRightSide);
        jpRightSide.add(gUIexternBeauftragter.getExternBeauftragtePanel());

        gbcRightSide.gridx = 0;
        gbcRightSide.gridy = 5;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        labelKosten = new Label("Kosten");
        gblRightSide.setConstraints(labelKosten, gbcRightSide);
        jpRightSide.add(labelKosten);

        gbcRightSide.gridx = 1;
        gbcRightSide.gridy = 5;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        textFieldKosten = TextComponent.builder("textFieldKosten").initialText(Double.toString(kosten)).build();
        gblRightSide.setConstraints(textFieldKosten, gbcRightSide);
        jpRightSide.add(textFieldKosten);

        gbcRightSide.gridx = 0;
        gbcRightSide.gridy = 6;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        labelTeilnehmerzahl = new Label("Teilnehmer Zahl");
        gblRightSide.setConstraints(labelTeilnehmerzahl, gbcRightSide);
        jpRightSide.add(labelTeilnehmerzahl);

        gbcRightSide.gridx = 1;
        gbcRightSide.gridy = 6;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        textFieldTeilnehmerzahl = TextComponent.builder("textFieldTeilnehmerzahl").initialText(Integer.toString(teilnehmer)).build();
        gblRightSide.setConstraints(textFieldTeilnehmerzahl, gbcRightSide);
        jpRightSide.add(textFieldTeilnehmerzahl);


        gbcRightSide.gridx = 0;
        gbcRightSide.gridy = 7;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        labelBeschreibung = new Label("Beschreibung");
        gblRightSide.setConstraints(labelBeschreibung, gbcRightSide);
        jpRightSide.add(labelBeschreibung);

        gbcRightSide.gridx = 1;
        gbcRightSide.gridy = 7;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        extendetTextFieldBeschreibung = new JTextArea();
        extendetTextFieldBeschreibung.setText(System.lineSeparator()+ " Some text"+ System.lineSeparator());
        scrollPane = new JScrollPane(extendetTextFieldBeschreibung);
        gblRightSide.setConstraints(scrollPane, gbcRightSide);
        jpRightSide.add(scrollPane);

        gbcRightSide.gridx = 0;
        gbcRightSide.gridy = 8;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        labelStandort = new Label("Standort");
        gblRightSide.setConstraints(labelStandort, gbcRightSide);
        jpRightSide.add(labelStandort);

        gbcRightSide.gridx = 1;
        gbcRightSide.gridy = 8;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        textFieldStandort = TextComponent.builder("textFieldStandort").initialText(this._teilevent.getStandort().getGesamteAdresse()).build();
        gblRightSide.setConstraints(textFieldStandort, gbcRightSide);
        jpRightSide.add(textFieldStandort);

        gbcRightSide.gridx = 0;
        gbcRightSide.gridy = 9;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        labelMontageLeiter = new Label("Montageleiter");
        gblRightSide.setConstraints(labelMontageLeiter, gbcRightSide);
        jpRightSide.add(labelMontageLeiter);

        gbcRightSide.gridx = 1;
        gbcRightSide.gridy = 9;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        MontageLeiterComboboxElement = AttributeElement.builder("MontageLeiterComboboxElement")
                        .labelName(" ")
                        .actionType(AttributeElement.ActionType.COMBOBOX)
                        .build();

        ArrayList<String> mitarbieterMontageName = new ArrayList<>();

        for (int i = 0; i < mitarbeiter.size(); i++) {
            if(mitarbeiter.get(i).getRolle() == Rolle.MONTAGELEITER){
                mitarbieterMontageName.add(mitarbeiter.get(i).getKontaktdaten().getEmail().getGesamteEmail());
            }

        }
        MontageLeiterComboboxElement.setData(mitarbieterMontageName.toArray());
        gblRightSide.setConstraints(MontageLeiterComboboxElement, gbcRightSide);
        jpRightSide.add(MontageLeiterComboboxElement);


        gbcRightSide.gridx = 0;
        gbcRightSide.gridy = 10;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        labelGruppenLeiter = new Label("Gruppenleiter");
        gblRightSide.setConstraints(labelGruppenLeiter, gbcRightSide);
        jpRightSide.add(labelGruppenLeiter);

        gbcRightSide.gridx = 1;
        gbcRightSide.gridy = 10;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        GruppenLeiterComboboxElement = AttributeElement.builder("GruppenLeiterComboboxElement")
                        .labelName(" ")
                        .actionType(AttributeElement.ActionType.COMBOBOX)
                        .build();
        ArrayList<String> mitarbieterGruppenLeiterName = new ArrayList<>();

        for (int i = 0; i < mitarbeiter.size(); i++) {
            if(mitarbeiter.get(i).getRolle() == Rolle.GRUPPENLEITER){
                mitarbieterGruppenLeiterName.add(mitarbeiter.get(i).getKontaktdaten().getEmail().getGesamteEmail());
            }

        }
        GruppenLeiterComboboxElement.setData(mitarbieterGruppenLeiterName.toArray());
        gblRightSide.setConstraints(GruppenLeiterComboboxElement, gbcRightSide);
        jpRightSide.add(GruppenLeiterComboboxElement);

        gbcRightSide.gridx = 0;
        gbcRightSide.gridy = 11;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        labelStatus = new Label("Status");
        gblRightSide.setConstraints(labelStatus, gbcRightSide);
        jpRightSide.add(labelStatus);

        gbcRightSide.gridx = 1;
        gbcRightSide.gridy = 11;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        StatusComboboxElement = AttributeElement.builder("StatusComboboxElement")
                        .labelName(" ")
                        .actionType(AttributeElement.ActionType.COMBOBOX)
                        .build();
        StatusComboboxElement.setData(com.model.dataTypes.Status.getNames(Status.class));
        gblRightSide.setConstraints(StatusComboboxElement, gbcRightSide);
        jpRightSide.add(StatusComboboxElement);

        gbcRightSide.gridx = 1;
        gbcRightSide.gridy = 12;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;
        SubmitButtonElement = new ButtonElement[]{ ButtonElement.builder("SubmitButtonElement")
                        .buttonText("Bestätigen")
                        .type(ButtonElement.Type.BUTTON)
                        .build()};

        SubmitButtonComponent = ButtonComponent
                .builder("SubmitButtonComponent")
                .buttonElements(SubmitButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();

        SubmitButtonComponent.addObserver(this);
        gblRightSide.setConstraints(SubmitButtonComponent, gbcRightSide);
        jpRightSide.add(SubmitButtonComponent);

        gbcRightSide.gridx = 0;
        gbcRightSide.gridy = 12;
        gbcRightSide.gridwidth = 1;
        gbcRightSide.gridheight = 1;

        CancleButtonElement = new ButtonElement[]{ ButtonElement.builder("CancleButtonElement")
                        .buttonText("Abbruch")
                        .type(ButtonElement.Type.BUTTON)
                        .build()};

        CancleButtonComponent = ButtonComponent
                .builder("CancleButtonComponent")
                .buttonElements(CancleButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();
        CancleButtonComponent.addObserver(this);


        gblRightSide.setConstraints(CancleButtonComponent, gbcRightSide);
        jpRightSide.add(CancleButtonComponent);


        jp.add(jpLeftSide);
        jp.add(jpRightSide);

    }

    @Override
    public void SetTimeSeletet(Timestamp timestamp, String id) {
        String s = new SimpleDateFormat("dd.MM.yyyy HH:mm").format(timestamp);
        if(id.equals("Start")){
            StartDatumButtonElement[0].setButtonText(s);
        }
        if(id.equals("End")){
            EndDatumButtonElement[0].setButtonText(s);
        }
    }

    @Override
    public void processGUIEvent(GUIEvent ge) {
        if (ge.getCmd().equals(ButtonComponent.Commands.BUTTON_PRESSED)) {
            if (((ButtonElement) ge.getData()).getID().equals("StartDatumButtonElement")) {
                GUIDateTimeSelector g = new GUIDateTimeSelector(this, "Start");
            }
            if (((ButtonElement) ge.getData()).getID().equals("EndDatumButtonElement")) {
                GUIDateTimeSelector g = new GUIDateTimeSelector(this, "End");
            }
            if (((ButtonElement) ge.getData()).getID().equals("EventMitarbiterHinzufuegenButtonElement")) {
                String emailMitarbeiter = (String) MitarbeiterComboboxElement.getValue();

                // Hinzufügen des Mitarbeiters zu teilevent in die entsprechende Liste anhand seiner Rolle
                ArrayList<Mitarbeiter> mitarbeiter = Eventverwaltung.getInstance().getListeMitarbeiter();
                for (int i = 0; i < mitarbeiter.size(); i++) {
                    if(mitarbeiter.get(i).getRolle() == Rolle.BESCHAFFUNGSPERSONAL
                        && mitarbeiter.get(i).getKontaktdaten().getEmail().getGesamteEmail() == emailMitarbeiter){
                        _teilevent.getBeschaffungsPersonal().add(mitarbeiter.get(i));
                    }
                    else if(mitarbeiter.get(i).getRolle() == Rolle.MITARBEITER
                        && mitarbeiter.get(i).getKontaktdaten().getEmail().getGesamteEmail() == emailMitarbeiter){
                        _teilevent.getMontagePersonal().add(mitarbeiter.get(i));
                    }
                }
                updateTableMitarbeiter();
            }
            if (((ButtonElement) ge.getData()).getID().equals("EventMitarbiterEntfernenButtonElement")) {
                String emailMitarbeiter = (String) MitarbeiterComboboxElement.getValue();

                // Entfernen des Mitarbeiters von teilevent von der entsprechende Liste anhand seiner Rolle
                ArrayList<Mitarbeiter> mitarbeiter = Eventverwaltung.getInstance().getListeMitarbeiter();
                for (int i = 0; i < mitarbeiter.size(); i++) {
                    if(mitarbeiter.get(i).getKontaktdaten().getEmail().getGesamteEmail() == emailMitarbeiter){
                        if(mitarbeiter.get(i).getRolle() == Rolle.BESCHAFFUNGSPERSONAL){
                            _teilevent.getBeschaffungsPersonal().remove(mitarbeiter.get(i));
                        }
                        else if(mitarbeiter.get(i).getRolle() == Rolle.MITARBEITER){
                            _teilevent.getMontagePersonal().remove(mitarbeiter.get(i));
                        }
                    }
                }
                updateTableMitarbeiter();
            }
            if (((ButtonElement) ge.getData()).getID().equals("EventHilfsmittelHinzufuegenButtonElement")) {
                String name = (String) HilfsmittelComboboxElement.getValue();
                int anzahl = Integer.parseInt(textFieldHilfsmittelAnzahl.getText());
                ArrayList<Hilfsmittel> hilfsmittel = Eventverwaltung.getInstance().getListeHilfsmittel();
                for(int i = 0; i < hilfsmittel.size(); i++){
                    if(name == hilfsmittel.get(i).getBezeichnung()){
                        _teilevent.getHilfsmittel().add(new Pair<Hilfsmittel, Integer>(hilfsmittel.get(i), anzahl));
                    }
                }
                updateTableHilfsmittel();
            }
            if (((ButtonElement) ge.getData()).getID().equals("EventHilfmittelEntfernenButtonElement")) {
                String name = (String) HilfsmittelComboboxElement.getValue();
                int anzahl = Integer.parseInt(textFieldHilfsmittelAnzahl.getText());
                ArrayList<Hilfsmittel> hilfsmittel = Eventverwaltung.getInstance().getListeHilfsmittel();
                for(int i = 0; i < hilfsmittel.size(); i++){
                    if(name == hilfsmittel.get(i).getBezeichnung()){
                        _teilevent.getHilfsmittel().remove(new Pair<Hilfsmittel, Integer>(hilfsmittel.get(i), anzahl));
                    }
                }
                updateTableHilfsmittel();
            }
            if (((ButtonElement) ge.getData()).getID().equals("SubmitButtonElement")) {
                String externBeauffirmenname = gUIexternBeauftragter.textFieldFirmenname.getText();
                String externBeaufangebot = gUIexternBeauftragter.textFieldAngebot.getText();
                String externBeaufAnzahlPersonen = gUIexternBeauftragter.textFieldAnzahlPersonen.getText();
                String externBeaufBeschreibung = gUIexternBeauftragter.textFieldBeschreibung.getText();
                String externBeaufVorname = gUIexternBeauftragter.textFieldVorname.getText();
                String externBeaufNachname = gUIexternBeauftragter.textFieldNachname.getText();
                String externBeaufEmail = gUIexternBeauftragter.textFieldEmail.getText();
                int externBeaufTelefonnummer = Integer.parseInt(gUIexternBeauftragter.textFieldTelefonnummer.getText());
                String externBeaufAdresse = gUIexternBeauftragter.textFieldAdresse.getText();
                _teilevent.setBezeichnung(textFieldTeileventName.getText());
                _teilevent.setStart_Termin(new Datum(StartDatumButtonElement[0].getButtonText()));
                _teilevent.setEnd_Termin(new Datum(EndDatumButtonElement[0].getButtonText()));
                _teilevent.setBeschreibung(extendetTextFieldBeschreibung.getText());
                _teilevent.setKosten(Double.parseDouble(textFieldKosten.getText()));
                _teilevent.setTeilnehmeranzahl(Integer.parseInt(textFieldTeilnehmerzahl.getText()));
                _teilevent.setExternBeauftragter(new ExternBeauftragter(externBeauffirmenname, externBeaufangebot, externBeaufAnzahlPersonen,
                            externBeaufBeschreibung, externBeaufVorname, externBeaufNachname,
                            externBeaufEmail, externBeaufTelefonnummer, externBeaufAdresse));
                _teilevent.setStandort(new Anschrift(textFieldStandort.getText()));
                setMontageleiterObjectToTeilevent();
                setGruppenleiterObjectToTeilevent();
                setHaupteventObjectToTeilevent();
                setStatusObjectToTeilevent();

          }
            if (((ButtonElement) ge.getData()).getID().equals("CancleButtonElement")) {
                _frame.dispose();
            }
        }
    }

    private void setHaupteventObjectToTeilevent(){
        String name = ZugeoerigeHaupteventComboboxElement.getValueAsString();
        ArrayList<Hauptevent> hauptevents = Eventverwaltung.getInstance().getListeHauptevent();
        for (int i = 0; i < hauptevents.size(); i++) {
            if(name == hauptevents.get(i).getBezeichnung()){
                _teilevent.setHauptevent(hauptevents.get(i));
            }
        }
    }
    private void setGruppenleiterObjectToTeilevent(){
        String name = GruppenLeiterComboboxElement.getValueAsString();
        ArrayList<Mitarbeiter> mitarbeiter = Eventverwaltung.getInstance().getListeMitarbeiter();
        for (int i = 0; i < mitarbeiter.size(); i++) {
            if(name == mitarbeiter.get(i).getKontaktdaten().getEmail().getGesamteEmail()){
                _teilevent.setGruppenleiterBeschaffung(mitarbeiter.get(i));
            }
        }
    }
    private void setMontageleiterObjectToTeilevent(){
        String name = MontageLeiterComboboxElement.getValueAsString();
        ArrayList<Mitarbeiter> mitarbeiter = Eventverwaltung.getInstance().getListeMitarbeiter();
        for (int i = 0; i < mitarbeiter.size(); i++) {
            if(name == mitarbeiter.get(i).getKontaktdaten().getEmail().getGesamteEmail()){
                _teilevent.setMontageLeiter(mitarbeiter.get(i));
            }
        }
    }
    private void setStatusObjectToTeilevent(){
        String status = StatusComboboxElement.getValueAsString();
        _teilevent.setStatus(Status.valueOf(status));
    }

    private void updateTableMitarbeiter(){
        // GUI Mitarbeiter liste aktualisieren
        ArrayList<Mitarbeiter> mitarbeiters = new ArrayList<Mitarbeiter>(_teilevent.getBeschaffungsPersonal());
        mitarbeiters.addAll(_teilevent.getMontagePersonal());

        elemsMitarbeiter = new IDepictable[mitarbeiters.size()];
        for (int i = 0; i < elemsMitarbeiter.length ; i++) {
            Mitarbeiter mitarbeiterString = mitarbeiters.get(i);
            elemsMitarbeiter[i] = new tableClassMitarbeiter(mitarbeiterString.getKontaktdaten().getEmail().getGesamteEmail());
        }
        tableMitarbeiter.setData(elemsMitarbeiter, new String[]{"eMail"});

    }

    private void updateTableHilfsmittel(){
        // GUI Hilfsmittel liste aktualisieren
        ArrayList<Pair<Hilfsmittel, Integer>> hilfsmittelTeilevent = _teilevent.getHilfsmittel();

        elemsHilfsmittel = new IDepictable[hilfsmittelTeilevent.size()];
        for (int i = 0; i < elemsHilfsmittel.length ; i++) {
           Pair<Hilfsmittel, Integer> hilfsmittelAnzahlString = hilfsmittelTeilevent.get(i);
           elemsHilfsmittel[i] = new tableClassHilfsmittel(hilfsmittelAnzahlString.getValue0().getBezeichnung(), hilfsmittelAnzahlString.getValue1());
        }

        tableHilfsmittel.setData(elemsHilfsmittel, new String[]{"Bezeichnung", "Anzahl"});
    }

    public class tableClassMitarbeiter implements IDepictable {

            String eMail;

            public tableClassMitarbeiter(String eMail){
                this.eMail = eMail;
            }
            @Override
            public String getElementID() {
                return this.eMail;
            }

            @Override
            public Attribute[] getAttributeArray() {
                return new Attribute[] { new Attribute("eMail",
                        this.eMail,
                        String.class,
                        this.eMail,
                        "name",
                        true,
                        true,
                        true
                )};
            }
            //Attribute(String name, Object dedicatedInstance, Class<?> clazz, Object value, Object defaultValue, boolean visible, boolean modifiable, boolean editable)
        }


    public class tableClassHilfsmittel implements IDepictable {

            String bezeichnung;
            int anzahl;

            public tableClassHilfsmittel(String bezeichnung, int anzahl){
                this.bezeichnung = bezeichnung;
                this.anzahl = anzahl;
            }
            @Override
            public String getElementID() {
                return this.bezeichnung;
            }

            @Override
            public Attribute[] getAttributeArray() {
                return new Attribute[] {
                        new Attribute("bezeichnung",
                        this.bezeichnung,
                        String.class,
                        this.bezeichnung,
                        "bezeichnung",
                        true,
                        true,
                        true ),

                    new Attribute("anzahl", this.anzahl,
                    String.class,
                    this.anzahl,
                    "anzahl",
                    true,
                    true,
                    true
                )};
            }
            //Attribute(String name, Object dedicatedInstance, Class<?> clazz, Object value, Object defaultValue, boolean visible, boolean modifiable, boolean editable)
    }

}
