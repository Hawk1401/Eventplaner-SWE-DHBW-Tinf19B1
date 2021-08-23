package com;

import com.databaseInterface.Eventverwaltung;
import com.gui.*;
import com.model.event.Hauptevent;
import com.model.event.Teilevent;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import de.dhbwka.swe.utils.gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class GUIController implements IGUIEventListener {

    private static final GUIController guiController = new GUIController();
    private ButtonElement[] btns;
    JFrame frame;
    JPanel Center;
    GUIOverview ov;
    private GUIController(){
        // constructor is private -> no access from outside, no new object -> singleton
        frame = new JFrame();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        frame.add(mainPanel);

        frame.setTitle("Eventplaner Applikation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setMinimumSize(new Dimension(1000,    600));
        frame.setVisible(true);

        frame.setLayout(new BorderLayout());

        mainPanel.add(topbar());

        Center = new JPanel();
        Center.setLayout(new BoxLayout(Center, BoxLayout.X_AXIS));
        mainPanel.add(Center);

        //temp
        ov = new GUIOverview(this);
        Center.add(ov.getOverviewPanel());
        //temp


        GUIHauptevent HauptEvent = new GUIHauptevent();
        Center.add(HauptEvent.getOverviewPanel());
        //frame.add(new Button("test"), BorderLayout.CENTER);

        frame.pack();
        frame.repaint();
    }

    public static GUIController getGuiController(){
        return guiController;
    }

    public JPanel topbar(){
        JPanel top = new JPanel();

        btns = new ButtonElement[]{
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

        ButtonComponent topBarButtons = ButtonComponent
                .builder("ComponentTopbar")
                .buttonElements(btns)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();

        topBarButtons.addObserver(this);
        top.add(topBarButtons);

        return top;
    }



    @Override
    public void processGUIEvent(GUIEvent ge) {

        if (ge.getCmd().equals(ButtonComponent.Commands.BUTTON_PRESSED)) {
            if (((ButtonElement) ge.getData()).getID().equals("BTN-neuesHauptevent")) {
                JFrame frame = new JFrame();
                GUIHaupteventBearbeiten guiHaupteventBearbeiten = new GUIHaupteventBearbeiten(frame, new Hauptevent());
                frame.add(guiHaupteventBearbeiten.getOverviewPanel());
                frame.pack();
                frame.setMinimumSize(new Dimension(800,    600));
                frame.setVisible(true);
            }
            if (((ButtonElement) ge.getData()).getID().equals("BTN-neuesTeilevent")) {
                JFrame frame = new JFrame();
                GUITeilEventBearbeiten guiTeileventBearbeiten = new GUITeilEventBearbeiten(new Teilevent(), frame);
                frame.add(guiTeileventBearbeiten.getOverviewPanel());
                frame.pack();
                frame.setMinimumSize(new Dimension(800,    600));
                frame.setVisible(true);
            }
            if (((ButtonElement) ge.getData()).getID().equals("BTN-HilfsmittelBearbeiten")) {

            }
            if (((ButtonElement) ge.getData()).getID().equals("BTN-KundeBearbeiten")) {

            }
            if (((ButtonElement) ge.getData()).getID().equals("BTN-MitarbeiterBearbeiten")) {

            }
        }

        if(ge.getCmd().equals(SimpleTableComponent.Commands.MULTIPLE_ROWS_SELECTED)){
            String t = ((List<GUIEventlist.tableclass>)ge.getData()).get(0).getName();

            ArrayList<Hauptevent> hauptEvents = Eventverwaltung.getEventverwaltung().getListeHauptevent();
            for (int i = 0; i < hauptEvents.size(); i++) {
                if(hauptEvents.get(i).getBezeichnung() == t){
                    GUIHauptevent HauptEvent = new GUIHauptevent(hauptEvents.get(i));
                    Center.remove(1);
                    Center.add(HauptEvent.getOverviewPanel());
                    frame.pack();
                }
            }
        }
    }
}
