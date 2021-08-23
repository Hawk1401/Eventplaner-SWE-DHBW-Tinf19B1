package com.gui;

import javax.swing.*;
import java.awt.*;

import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import de.dhbwka.swe.utils.gui.*;
import de.dhbwka.swe.utils.gui.TextComponent;

public class GUIexternBeauftragter extends GUIComponent implements IGUIEventListener {

    private JPanel jp = new JPanel();
    public JPanel getExternBeauftragtePanel(){return  jp;}
    
    private GridBagLayout gblExternBeauftragte;
    private GridBagConstraints gbcExternBeauftragte;
    
    private Label labelExternBeauftragte;
    private Label labelFirmenName;
    private Label labelAngebot;
    private Label labelAnzahlPersonal;
    private Label labelBeschreibung;
    private Label labelKontaktdaten;
    private Label labelVorname;
    private Label labelNachname;
    private Label labelEmail;
    private Label labelTelefonnummer;
    private Label labelAdresse;
    
    public TextComponent textFieldFirmenname;
    public TextComponent textFieldAngebot;
    public TextComponent textFieldAnzahlPersonen;
    public TextComponent textFieldBeschreibung;
    public TextComponent textFieldVorname;
    public TextComponent textFieldNachname;
    public TextComponent textFieldEmail;
    public TextComponent textFieldTelefonnummer;
    public TextComponent textFieldAdresse;
    
    private ButtonElement[] EventVertragHinzufuegenButtonElement;
    
    private ButtonComponent VertragHinzufuegenButtonComponent;
    
        
    public GUIexternBeauftragter(){
        gblExternBeauftragte = new GridBagLayout();
        jp.setLayout(gblExternBeauftragte);
        gbcExternBeauftragte = new GridBagConstraints();
        gbcExternBeauftragte.weighty = 1;
        gbcExternBeauftragte.anchor = GridBagConstraints.NORTHWEST;
        gbcExternBeauftragte.fill = GridBagConstraints.HORIZONTAL;
        gbcExternBeauftragte.insets = new Insets(5, 5, 5, 5);
        
        gbcExternBeauftragte.gridx = 0;
        gbcExternBeauftragte.gridy = 0;
        gbcExternBeauftragte.gridwidth = 1;
        gbcExternBeauftragte.gridheight = 1;
        labelExternBeauftragte = new Label("ExternBeauftragte");
        gblExternBeauftragte.setConstraints(labelExternBeauftragte, gbcExternBeauftragte);
        jp.add(labelExternBeauftragte);
        
        gbcExternBeauftragte.gridx = 0;
        gbcExternBeauftragte.gridy = 1;
        gbcExternBeauftragte.gridwidth = 1;
        gbcExternBeauftragte.gridheight = 1;
        labelFirmenName = new Label("Firmenname");
        gblExternBeauftragte.setConstraints(labelFirmenName, gbcExternBeauftragte);
        jp.add(labelFirmenName);
        
        gbcExternBeauftragte.gridx = 1;
        gbcExternBeauftragte.gridy = 1;
        gbcExternBeauftragte.gridwidth = 1;
        gbcExternBeauftragte.gridheight = 1;
        textFieldFirmenname = TextComponent.builder("textFieldFirmenname").initialText("new dawn").build();
        gblExternBeauftragte.setConstraints(textFieldFirmenname, gbcExternBeauftragte);
        jp.add(textFieldFirmenname);
       
        gbcExternBeauftragte.gridx = 0;
        gbcExternBeauftragte.gridy = 2;
        gbcExternBeauftragte.gridwidth = 1;
        gbcExternBeauftragte.gridheight = 1;
        labelAngebot = new Label("Angebot");
        gblExternBeauftragte.setConstraints(labelAngebot, gbcExternBeauftragte);
        jp.add(labelAngebot);
        
        gbcExternBeauftragte.gridx = 1;
        gbcExternBeauftragte.gridy = 2;
        gbcExternBeauftragte.gridwidth = 1;
        gbcExternBeauftragte.gridheight = 1;
        textFieldAngebot = TextComponent.builder("textFieldAngebot").initialText("new dawn").build();
        gblExternBeauftragte.setConstraints(textFieldAngebot, gbcExternBeauftragte);
        jp.add(textFieldAngebot);

       gbcExternBeauftragte.gridx = 0;
        gbcExternBeauftragte.gridy = 3;
        gbcExternBeauftragte.gridwidth = 1;
        gbcExternBeauftragte.gridheight = 1;
        labelAnzahlPersonal = new Label("Anzahl Personal");
        gblExternBeauftragte.setConstraints(labelAnzahlPersonal, gbcExternBeauftragte);
        jp.add(labelAnzahlPersonal);

        gbcExternBeauftragte.gridx = 1;
        gbcExternBeauftragte.gridy = 3;
        gbcExternBeauftragte.gridwidth = 1;
        gbcExternBeauftragte.gridheight = 1;
        textFieldAnzahlPersonen = TextComponent.builder("textFieldAnzahlPersonen").initialText("new dawn").build();
        gblExternBeauftragte.setConstraints(textFieldAnzahlPersonen, gbcExternBeauftragte);
        jp.add(textFieldAnzahlPersonen);

         gbcExternBeauftragte.gridx = 0;
         gbcExternBeauftragte.gridy = 4;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         labelBeschreibung = new Label("Beschreibung");
         gblExternBeauftragte.setConstraints(labelBeschreibung, gbcExternBeauftragte);
         jp.add(labelBeschreibung);

         gbcExternBeauftragte.gridx = 1;
         gbcExternBeauftragte.gridy = 4;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         textFieldBeschreibung = TextComponent.builder("textFieldBeschreibung").initialText("new dawn").build();
         gblExternBeauftragte.setConstraints(textFieldBeschreibung, gbcExternBeauftragte);
         jp.add(textFieldBeschreibung);

         gbcExternBeauftragte.gridx = 2;
         gbcExternBeauftragte.gridy = 0;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         labelKontaktdaten = new Label("Kontaktdaten");
         gblExternBeauftragte.setConstraints(labelKontaktdaten, gbcExternBeauftragte);
         jp.add(labelKontaktdaten);

         gbcExternBeauftragte.gridx = 2;
         gbcExternBeauftragte.gridy = 1;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         labelVorname = new Label("Vorname");
         gblExternBeauftragte.setConstraints(labelVorname, gbcExternBeauftragte);
         jp.add(labelVorname);

         gbcExternBeauftragte.gridx = 3;
         gbcExternBeauftragte.gridy = 1;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         textFieldVorname = TextComponent.builder("textFieldVorname").initialText("new dawn").build();
         gblExternBeauftragte.setConstraints(textFieldVorname, gbcExternBeauftragte);
         jp.add(textFieldVorname);

         gbcExternBeauftragte.gridx = 2;
         gbcExternBeauftragte.gridy = 2;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         labelNachname = new Label("Nachname");
         gblExternBeauftragte.setConstraints(labelNachname, gbcExternBeauftragte);
         jp.add(labelNachname);

         gbcExternBeauftragte.gridx = 3;
         gbcExternBeauftragte.gridy = 2;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         textFieldNachname = TextComponent.builder("textFieldNachname").initialText("new dawn").build();
         gblExternBeauftragte.setConstraints(textFieldNachname, gbcExternBeauftragte);
         jp.add(textFieldNachname);

         gbcExternBeauftragte.gridx = 2;
         gbcExternBeauftragte.gridy = 3;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         labelEmail = new Label("Email");
         gblExternBeauftragte.setConstraints(labelEmail, gbcExternBeauftragte);
         jp.add(labelEmail);

         gbcExternBeauftragte.gridx = 3;
         gbcExternBeauftragte.gridy = 3;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         textFieldEmail = TextComponent.builder("textFieldEmail").initialText("new dawn").build();
         gblExternBeauftragte.setConstraints(textFieldEmail, gbcExternBeauftragte);
         jp.add(textFieldEmail);

         gbcExternBeauftragte.gridx = 2;
         gbcExternBeauftragte.gridy = 4;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         labelTelefonnummer = new Label("Telefonnummer");
         gblExternBeauftragte.setConstraints(labelTelefonnummer, gbcExternBeauftragte);
         jp.add(labelTelefonnummer);

         gbcExternBeauftragte.gridx = 3;
         gbcExternBeauftragte.gridy = 4;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         textFieldTelefonnummer = TextComponent.builder("textFieldTelefonnummer").initialText("new dawn").build();
         gblExternBeauftragte.setConstraints(textFieldTelefonnummer, gbcExternBeauftragte);
         jp.add(textFieldTelefonnummer);

         gbcExternBeauftragte.gridx = 2;
         gbcExternBeauftragte.gridy = 5;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         labelAdresse = new Label("Adresse");
         gblExternBeauftragte.setConstraints(labelAdresse, gbcExternBeauftragte);
         jp.add(labelAdresse);

         gbcExternBeauftragte.gridx = 3;
         gbcExternBeauftragte.gridy = 5;
         gbcExternBeauftragte.gridwidth = 1;
         gbcExternBeauftragte.gridheight = 1;
         textFieldAdresse = TextComponent.builder("textFieldAdresse").initialText("new dawn").build();
         gblExternBeauftragte.setConstraints(textFieldAdresse, gbcExternBeauftragte);
         jp.add(textFieldAdresse);

         gbcExternBeauftragte.gridx = 0;
         gbcExternBeauftragte.gridy = 6;
         gbcExternBeauftragte.gridwidth = 2;
         gbcExternBeauftragte.gridheight = 1;
         EventVertragHinzufuegenButtonElement = new ButtonElement[]{ ButtonElement.builder("VertragHinzufuegenButtonElement")
                                                                                           .buttonText("Vertrag Hinzufügen")
                                                                                           .type(ButtonElement.Type.BUTTON)
                                                                                           .build()};
        VertragHinzufuegenButtonComponent = ButtonComponent
                .builder("VertragHinzufuegenButtonComponent")
                .buttonElements(EventVertragHinzufuegenButtonElement)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();
        VertragHinzufuegenButtonComponent.addObserver(this);
         gblExternBeauftragte.setConstraints(VertragHinzufuegenButtonComponent, gbcExternBeauftragte);
         jp.add(VertragHinzufuegenButtonComponent);

    }



    @Override
    public void processGUIEvent(GUIEvent ge) {
        if (ge.getCmd().equals(ButtonComponent.Commands.BUTTON_PRESSED)) {
            if (((ButtonElement) ge.getData()).getID().equals("EventVertragHinzufuegenButtonElement")) {

            }
        }
    }
}
