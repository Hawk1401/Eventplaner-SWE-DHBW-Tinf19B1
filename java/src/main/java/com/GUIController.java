package com;

import com.gui.GUISuche;
import de.dhbwka.swe.utils.gui.AttributeComponent;
import de.dhbwka.swe.utils.gui.AttributeElement;
import de.dhbwka.swe.utils.gui.ButtonComponent;
import de.dhbwka.swe.utils.gui.ButtonElement;

import javax.swing.*;
import java.awt.*;

public class GUIController {

    private static final GUIController guiController = new GUIController();

    private GUIController(){
        // constructor is private -> no access from outside, no new object -> singleton
        JFrame frame = new JFrame();

        frame.setTitle("Eventplaner Applikation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setMinimumSize(new Dimension(1000,600));
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());

        frame.add(topbar(), BorderLayout.NORTH);


        frame.repaint();
    }

    public static GUIController getGuiController(){
        return guiController;
    }

    public JPanel topbar(){
        JPanel top = new JPanel();

        ButtonElement buttonNeuesHauptevent = ButtonElement.builder("BTN-neuesHauptevent")
                .buttonText("neues Hauptevent erstellen")
                .type(ButtonElement.Type.BUTTON)
                .build();
        ButtonElement buttonNeuesTeilevent = ButtonElement.builder("BTN-neuesTeilevent")
                .buttonText("neues Teilevent erstellen")
                .type(ButtonElement.Type.BUTTON)
                .build();
        ButtonElement buttonHilfsmittelBearbeiten = ButtonElement.builder("BTN-HilfsmittelBearbeiten")
                .buttonText("Hilfsmittel bearbeiten")
                .type(ButtonElement.Type.BUTTON)
                .build();
        ButtonElement buttonKundeBearbeiten = ButtonElement.builder("BTN-KundeBearbeiten")
                .buttonText("Kunde bearbeiten")
                .type(ButtonElement.Type.BUTTON)
                .build();
        ButtonElement buttonMitarbeiterBearbeiten = ButtonElement.builder("BTN-MitarbeiterBearbeiten")
                .buttonText("Mitarbeiter bearbeiten")
                .type(ButtonElement.Type.BUTTON)
                .build();

        top.add(buttonNeuesHauptevent);
        top.add(buttonNeuesTeilevent);
        top.add(buttonHilfsmittelBearbeiten);
        top.add(buttonKundeBearbeiten);
        top.add(buttonMitarbeiterBearbeiten);

        return top;
    }








}
