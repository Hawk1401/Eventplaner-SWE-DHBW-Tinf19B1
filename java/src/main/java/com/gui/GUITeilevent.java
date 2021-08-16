package com.gui;

import de.dhbwka.swe.utils.gui.*;
import de.dhbwka.swe.utils.gui.TextComponent;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;

import javax.swing.*;
import java.awt.*;

public class GUITeilevent extends GUIComponent{
    private JPanel jp = new JPanel();
    public JPanel getOverviewPanel(){return  jp;}

    public GUITeilevent(){
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

        TextComponent textFieldTeileventName = TextComponent.builder("t").initialText("Drunking sailer").build();
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


        TextComponent textFieldHaupteventName = TextComponent.builder("HaupteventTextField").initialText("Test Hauptevent").build();
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


        TextComponent textFieldStartDatum = TextComponent.builder("textFieldStartDatum").initialText("Datum 1").build();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(textFieldStartDatum, gbc);
        jp.add(textFieldStartDatum);


        TextComponent textFieldEndDatum = TextComponent.builder("textFieldEndDatum").initialText("Datum 2").build();
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


        AttributeElement EventStatusComboboxElement = AttributeElement.builder("EventStatusComboboxElement")
                .labelName(" ")
                .actionType(AttributeElement.ActionType.COMBOBOX)
                .build();


        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbl.setConstraints(EventStatusComboboxElement, gbc);
        jp.add(EventStatusComboboxElement);


        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        Label labelKunde = new Label("Kunde");
        gbl.setConstraints(labelKunde, gbc);
        jp.add(labelKunde);


        ButtonElement EventKundeButtonElement = ButtonElement.builder("EventKundeButtonElement")
                .buttonText("Kunden info")
                .type(ButtonElement.Type.BUTTON)
                .build();
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        gbl.setConstraints(EventKundeButtonElement, gbc);
        jp.add(EventKundeButtonElement);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipady =0;
        Label labelBeschreibung = new Label("Beschreibung");
        gbl.setConstraints(labelBeschreibung, gbc);
        jp.add(labelBeschreibung);


        JTextArea extendetTextFieldBeschreibung = new JTextArea();
        extendetTextFieldBeschreibung.setText(System.lineSeparator()+ " Some text"+ System.lineSeparator());
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


        SimpleTableComponent tableMitarbeiter = SimpleTableComponent.builder("tableMitarbeiter").selectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ).columnNames(new String[]{"eMail"}).build();

        IDepictable[] elems = new IDepictable[]{
                        new tableclass2("michi@web.de"),
                        new tableclass2("alex@test.com")
                };

        tableMitarbeiter.setData(elems, new String[]{"eMail"});


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


        SimpleTableComponent tableHilfsmittel = SimpleTableComponent.builder("tableHilfsmittel").selectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ).columnNames(new String[]{"Name", "Beschreibung", "Anzahl"}).build();

        IDepictable[] elemsHilfsmittel = new IDepictable[]{
                        new tableclass3("Stuhl", "modern", "5"),
                        new tableclass3("Tisch", "Größe: 6, altmodisch", "2")
                };

        //tableHilfsmittel.setData(elemsHilfsmittel, new String[]{"Name", "Beschreibung", "Anzahl"});
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


        TextComponent textFieldKosten = TextComponent.builder("textFieldKosten").initialText("4000").build();
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

        JButton btnBerabeiten = new JButton("Event Bearbeiten");


        gbl.setConstraints(btnBerabeiten, gbc);
        jp.add(btnBerabeiten);
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

            public tableclass3(String eMail, String Beschreibung, String Anzahl){
                this.Name = Name;
                this.Beschreibung = Beschreibung;
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
