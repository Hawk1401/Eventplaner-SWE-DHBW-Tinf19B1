package com.gui;

import com.databaseInterface.Eventverwaltung;
import com.model.event.Hauptevent;
import com.model.event.Hilfsmittel;
import com.model.person.*;
import com.model.event.Teilevent;
import de.dhbwka.swe.utils.gui.*;
import de.dhbwka.swe.utils.gui.TextComponent;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import org.javatuples.Pair;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.EventListener;

public class GUITeilevent extends GUIComponent implements IGUIEventListener, EventListener {
    private JPanel jp = new JPanel();
    public JPanel getOverviewPanel(){return  jp;}
    private Teilevent _teilevent;



    TextComponent textFieldTeileventName;
    TextComponent textFieldHaupteventName;
    TextComponent textFieldStartDatum;
    TextComponent textFieldEndDatum;
    AttributeElement EventStatusComboboxElement;
    ButtonElement[] EventKundeButtonElement;
    JTextArea extendetTextFieldBeschreibung;
    SimpleTableComponent tableMitarbeiter;
    SimpleTableComponent tableHilfsmittel;
    TextComponent textFieldKosten;
    private ButtonComponent KundeButtonComponent;

    public GUITeilevent(Teilevent teilevent){
        this._teilevent = teilevent;

        String name =  _teilevent.getBezeichnung();
        String HauptEventName = _teilevent.getHauptevent();
        String StartDatum = _teilevent.getStart_Termin().getDatum();
        String EndDatum = _teilevent.getEnd_Termin().getDatum();
        String status = _teilevent.getStatus().toString();
        String beschreibung = _teilevent.getBeschreibung();
        String kosten = Double.toString(_teilevent.getKosten());

        ArrayList<Object[]> hilfsmittels = _teilevent.getHilfsmittel();

        IDepictable[] elemsHilfsmittel = new IDepictable[hilfsmittels.size()];
        for (int i = 0; i < elemsHilfsmittel.length ; i++) {
            Hilfsmittel hilfsmittel = (Hilfsmittel) hilfsmittels.get(i)[0];
            elemsHilfsmittel[i] = new tableclass3(hilfsmittel.getBezeichnung(), hilfsmittel.getBeschreibung(), Integer.toString((int)hilfsmittels.get(i)[1]));
        }

        ArrayList<Mitarbeiter> mitarbeiters = _teilevent.getBeschaffungsPersonal();
        mitarbeiters.addAll(_teilevent.getMontagePersonal());
        mitarbeiters.add(_teilevent.getMontageLeiter());
        mitarbeiters.add(_teilevent.getGruppenleiterBeschaffung());

        IDepictable[] elemsMitarbeiter = new IDepictable[mitarbeiters.size()];
        for (int i = 0; i < elemsMitarbeiter.length ; i++) {
            Mitarbeiter mitarbeiter = mitarbeiters.get(i);
            elemsMitarbeiter[i] = new tableclass2(mitarbeiter.getKontaktdaten().getEmail().getGesamteEmail());
        }
        BuildUI(name, HauptEventName, StartDatum, EndDatum, status, beschreibung, kosten,elemsHilfsmittel ,elemsMitarbeiter);

    }

    public GUITeilevent(){
        String buffer = "";
        for (int i = 0; i < 15; i++) {
            buffer +=  "A";
        }
        BuildUI(buffer, "", "", "", "", "", "", new tableclass3[0] , new tableclass2[0]);
    }


    public void BuildUI(String name, String HauptEventName, String StartDatum, String EndDatum, String status, String beschreibung, String kosten, IDepictable[] elemsHilfsmittel, IDepictable[] elemsMitarbeiter){
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
        Label labelEventName = new Label("Event/Teil Event");
        gbl.setConstraints(labelEventName, gbc);
        jp.add(labelEventName);

        textFieldTeileventName = TextComponent.builder("t").initialText(name).editable(false).build();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(textFieldTeileventName, gbc);
        jp.add(textFieldTeileventName);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        Label labelHaupteventName = new Label("Hauptevent");
        gbl.setConstraints(labelHaupteventName, gbc);
        jp.add(labelHaupteventName);


        textFieldHaupteventName = TextComponent.builder("HaupteventTextField").initialText(HauptEventName).editable(false).build();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(textFieldHaupteventName, gbc);
        jp.add(textFieldHaupteventName);


        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        Label labelDatum = new Label("Datum");
        gbc.gridheight = 1;
        gbl.setConstraints(labelDatum, gbc);
        jp.add(labelDatum);


        textFieldStartDatum = TextComponent.builder("textFieldStartDatum").initialText(StartDatum).editable(false).build();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(textFieldStartDatum, gbc);
        jp.add(textFieldStartDatum);


        textFieldEndDatum = TextComponent.builder("textFieldEndDatum").initialText(EndDatum).editable(false).build();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(textFieldEndDatum, gbc);
        jp.add(textFieldEndDatum);


        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        Label labelStatus = new Label("Status");
        gbl.setConstraints(labelStatus, gbc);
        jp.add(labelStatus);


        TextComponent textFieldStatus = TextComponent.builder("textFieldStatus").initialText(status).editable(false).build();



        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(textFieldStatus, gbc);
        jp.add(textFieldStatus);


        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        Label labelKunde = new Label("Kunde");
        gbl.setConstraints(labelKunde, gbc);
        jp.add(labelKunde);


        EventKundeButtonElement = new ButtonElement[]{ ButtonElement.builder("KundeButtonElement")
                .buttonText("Kunde")
                .type(ButtonElement.Type.BUTTON)
                .build()};

        KundeButtonComponent = ButtonComponent
                .builder("KundeButtonComponent")
                .buttonElements(EventKundeButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();


        KundeButtonComponent.addObserver(this);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbl.setConstraints(KundeButtonComponent, gbc);
        jp.add(KundeButtonComponent);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady =0;
        Label labelBeschreibung = new Label("Beschreibung");
        gbl.setConstraints(labelBeschreibung, gbc);
        jp.add(labelBeschreibung);


        extendetTextFieldBeschreibung = new JTextArea();
        extendetTextFieldBeschreibung.setText(beschreibung);
        JScrollPane scrollPane = new JScrollPane(extendetTextFieldBeschreibung);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.ipady = 40;
        gbl.setConstraints(scrollPane, gbc);
        jp.add(scrollPane);


        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 0;
        Label labelMitarbeiter = new Label("Mitarbeiter");
        gbl.setConstraints(labelMitarbeiter, gbc);
        jp.add(labelMitarbeiter);


        tableMitarbeiter = SimpleTableComponent.builder("tableMitarbeiter").selectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ).columnNames(new String[]{"eMail"}).build();



        tableMitarbeiter.setData(elemsMitarbeiter, new String[]{"eMail"});


        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.ipady = 40;
        gbl.setConstraints(tableMitarbeiter, gbc);
        jp.add(tableMitarbeiter);


        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 0;
        Label labelHilfsmittel = new Label("Hilfsmittel");
        gbl.setConstraints(labelHilfsmittel, gbc);
        jp.add(labelHilfsmittel);



        tableHilfsmittel = SimpleTableComponent.builder("tableHilfsmittel").selectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ).columnNames(new String[]{"Name", "Beschreibung", "Anzahl"}).build();




        tableHilfsmittel.setData(elemsHilfsmittel, new String[]{"Name", "Beschreibung", "Anzahl"});
        gbc.gridx = 1;
        gbc.gridy = 12;
        gbc.gridwidth = 1;
        gbc.gridheight = 3;
        gbc.ipady = 40;
        gbl.setConstraints(tableHilfsmittel, gbc);
        jp.add(tableHilfsmittel);


        gbc.gridx = 0;
        gbc.gridy = 15;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady = 0;
        Label labelKosten = new Label("Kosten");
        gbl.setConstraints(labelKosten, gbc);
        jp.add(labelKosten);


        textFieldKosten = TextComponent.builder("textFieldKosten").initialText(kosten).build();
        gbc.gridx = 1;
        gbc.gridy = 15;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(textFieldKosten, gbc);
        jp.add(textFieldKosten);



        gbc.gridx = 0;
        gbc.gridy = 18;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;

        //JButton btnBerabeiten = new JButton("Event Bearbeiten");
        //btnBerabeiten.addActionListener();


        ButtonElement[] EventButtonElement = new ButtonElement[]{ ButtonElement.builder("EventButtonElement")
                .buttonText("Event Bearbeiten")
                .type(ButtonElement.Type.BUTTON)
                .build()};

        ButtonComponent EventButtonComponent = ButtonComponent
                .builder("EventButtonComponent")
                .buttonElements(EventButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();


        EventButtonComponent.addObserver(this);

        gbl.setConstraints(EventButtonComponent, gbc);
        jp.add(EventButtonComponent);
    }
    @Override
    public void processGUIEvent(GUIEvent ge) {
        if (ge.getCmd().equals(ButtonComponent.Commands.BUTTON_PRESSED)) {
            if (((ButtonElement) ge.getData()).getID().equals("KundeButtonElement")) {
                JFrame frameKunde = new JFrame();

                ArrayList<Hauptevent> events = Eventverwaltung.getInstance().getListeHauptevent();
                Hauptevent hauptevent = null;
                for (int i = 0; i < events.size(); i++) {
                    if(events.get(i).getBezeichnung() == _teilevent.getHauptevent()){
                        hauptevent = events.get(i);
                    }
                }

                Kunde kunde = hauptevent.getVertrag().getKunde();
                frameKunde.add(new GUIKunde(frameKunde, kunde));
                frameKunde.show();
            }
        }
    }


    public class tableclass2 implements IDepictable {

        String eMail;

        public tableclass2(String eMail){
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
    public class tableclass3 implements IDepictable {

            String Name;
            String Beschreibung;
            String Anzahl;

            public tableclass3(String name, String Beschreibung, String Anzahl){
                this.Name = name;

                this.Beschreibung = Beschreibung;
                if(this.Beschreibung == null){
                    this.Beschreibung = " ";
                }
                this.Anzahl = Anzahl;
            }
            @Override
            public String getElementID() {
                return this.Name;
            }

            @Override
            public Attribute[] getAttributeArray() {
                return new Attribute[] { new Attribute("Name",
                        this.Name,
                        String.class,
                        this.Name,
                        "Name",
                        true,
                        true,
                        true
                ),
                new Attribute("Beschreibung",
                                        this.Beschreibung,
                                        String.class,
                                        this.Beschreibung,
                                        "Beschreibung",
                                        true,
                                        true,
                                        true
                ),
                new Attribute("Anzahl",
                                        this.Anzahl,
                                        String.class,
                                        this.Anzahl,
                                        "Anzahl",
                                        true,
                                        true,
                                        true
                )};
            //Attribute(String name, Object dedicatedInstance, Class<?> clazz, Object value, Object defaultValue, boolean visible, boolean modifiable, boolean editable)
            }
    //TODO still nothing there
    }
}
