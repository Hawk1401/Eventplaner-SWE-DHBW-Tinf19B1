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


        //temp
        GUISuche guiSuche = new GUISuche();
        frame.add(guiSuche.getAttributeComponent(), BorderLayout.SOUTH);
        //temp

        frame.repaint();
    }

    public static GUIController getGuiController(){
        return guiController;
    }

    public JPanel topbar(){
        JPanel top = new JPanel();

        ButtonElement[] btns = new ButtonElement[]{
                ButtonElement.builder("BTN-neuesHauptevent")
                .buttonText("neues Hauptevent erstellen")
                .type(ButtonElement.Type.BUTTON)
                .build(),
        ButtonElement.builder("BTN-neuesTeilevent")
                .buttonText("neues Teilevent erstellen")
                .type(ButtonElement.Type.BUTTON)
                .build(),
        ButtonElement.builder("BTN-HilfsmittelBearbeiten")
                .buttonText("Hilfsmittel bearbeiten")
                .type(ButtonElement.Type.BUTTON)
                .build(),
        ButtonElement.builder("BTN-KundeBearbeiten")
                .buttonText("Kunde bearbeiten")
                .type(ButtonElement.Type.BUTTON)
                .build(),
        ButtonElement.builder("BTN-MitarbeiterBearbeiten")
                .buttonText("Mitarbeiter bearbeiten")
                .type(ButtonElement.Type.BUTTON)
                .build()
        };

        ButtonComponent topBarButtons = ButtonComponent.builder("").buttonElements(btns).position(ButtonComponent.Position.NORTH).build();
        top.add(topBarButtons);

        return top;
    }









}
