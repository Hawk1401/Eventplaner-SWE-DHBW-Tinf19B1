package com.gui;

import com.gui.Interface.GUIDateTimeSelectorInterface;
import de.dhbwka.swe.utils.event.GUIEvent;
import de.dhbwka.swe.utils.event.IGUIEventListener;
import de.dhbwka.swe.utils.gui.ButtonComponent;
import de.dhbwka.swe.utils.gui.ButtonElement;
import de.dhbwka.swe.utils.gui.CalendarComponent;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class GUIDateTimeSelector implements IGUIEventListener {

    private CalendarComponent calendarComponent;
    private JComboBox<Integer> hourList;
    private JComboBox<Integer> minuteList;
    private JFrame frame;
    private String id;
    private GUIDateTimeSelectorInterface src;

    public GUIDateTimeSelector(GUIDateTimeSelectorInterface src, String id){

        this.src = src;
        this.id = id;

        frame = new JFrame();
        JPanel JP = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        JP.setLayout(gbl);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        calendarComponent = new CalendarComponent.CCBuilder().date(LocalDate.now()).build();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbl.setConstraints(calendarComponent, gbc);
        JP.add(calendarComponent);


        //time
        Integer[] hourArray = new Integer[24];
        for (int i = 0; i < 24; i++) {
            hourArray[i] = i;
        }

        Integer[] minuteArray = new Integer[12];
        for (int i = 0; i < 12; i++) {
            minuteArray[i] = i * 5;
        }

        hourList = new JComboBox(hourArray);
        minuteList = new JComboBox(minuteArray);
        JLabel timeLable = new JLabel("Uhrzeit : ");

        JPanel JPTime = new JPanel();
        GridBagLayout gblTime = new GridBagLayout();
        JPTime.setLayout(gblTime);

        GridBagConstraints gbcTime = new GridBagConstraints();
        gbcTime.weighty = 1;
        gbcTime.anchor = GridBagConstraints.NORTHWEST;
        gbcTime.fill = GridBagConstraints.HORIZONTAL;
        gbcTime.insets = new Insets(5, 5, 5, 5);


        gbcTime.gridx = 0;
        gbcTime.gridy = 0;
        gbcTime.gridwidth = 1;
        gbcTime.gridheight = 1;
        gblTime.setConstraints(timeLable, gbcTime);
        JPTime.add(timeLable);

        gbcTime.gridx = 1;
        gbcTime.gridy = 0;
        gbcTime.gridwidth = 1;
        gbcTime.gridheight = 1;
        gblTime.setConstraints(hourList, gbcTime);
        JPTime.add(hourList);

        gbcTime.gridx = 2;
        gbcTime.gridy = 0;
        gbcTime.gridwidth = 1;
        gbcTime.gridheight = 1;
        gblTime.setConstraints(minuteList, gbcTime);
        JPTime.add(minuteList);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbl.setConstraints(JPTime, gbc);
        JP.add(JPTime);
        
       

        ButtonElement[] btns = new ButtonElement[]{
                ButtonElement.builder("Cancel")
                        .buttonText("Abbruch")
                        .type(ButtonElement.Type.BUTTON)
                        .build(),
                ButtonElement.builder("Submit")
                        .buttonText("bestätigen")
                        .type(ButtonElement.Type.BUTTON)
                        .build(),
        };

        ButtonComponent buttonComponentDateTimeSelector = ButtonComponent
                .builder("buttonComponentDateTimeSelector")
                .buttonElements(btns)
                .buttonSize(new Dimension(200,40))
                .position(ButtonComponent.Position.NORTH)
                .build();

        buttonComponentDateTimeSelector.addObserver(this);


        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbl.setConstraints(buttonComponentDateTimeSelector, gbc);
        JP.add(buttonComponentDateTimeSelector);
        

        frame.add(JP);
        frame.pack();
        frame.setMinimumSize(new Dimension(1000,    600));
        frame.setVisible(true);
    }

    @Override
    public void processGUIEvent(GUIEvent ge) {
        if (ge.getCmd().equals(ButtonComponent.Commands.BUTTON_PRESSED)) {
            if (((ButtonElement) ge.getData()).getID().equals("Cancel")) {
                this.frame.dispose();
            }
            if (((ButtonElement) ge.getData()).getID().equals("Submit")) {
                LocalDate date = this.calendarComponent.getSelectedDate();

                Timestamp timestamp = Timestamp.valueOf(date.atStartOfDay());


                int hour =  (int)this.hourList.getSelectedItem();
                int minute = (int)this.minuteList.getSelectedItem();

                timestamp.setTime(timestamp.getTime() + TimeUnit.HOURS.toMillis(hour));
                timestamp.setTime(timestamp.getTime() + TimeUnit.MINUTES.toMillis(minute));

                this.src.SetTimeSeletet(timestamp, this.id);
                this.frame.dispose();
            }
        }
    }
}
