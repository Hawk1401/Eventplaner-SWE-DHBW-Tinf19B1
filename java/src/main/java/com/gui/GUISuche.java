package com.gui;

import javax.print.attribute.Attribute;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.databaseInterface.Eventverwaltung;
import com.model.dataTypes.Status;
import com.model.person.Mitarbeiter;
import de.dhbwka.swe.utils.*;
import de.dhbwka.swe.utils.gui.AttributeComponent;
import de.dhbwka.swe.utils.gui.AttributeElement;
import de.dhbwka.swe.utils.gui.ButtonElement;

public class GUISuche extends GUIComponent {

    private AttributeComponent attributeComponent;

    public AttributeComponent getAttributeComponent() {
        return attributeComponent;
    }

    public GUISuche() {



        AttributeElement[] elements = new AttributeElement[]{
            AttributeElement.builder("MitarbeiterLabel")
                    .labelName("Mitarbeiter")
                    .actionType(AttributeElement.ActionType.COMBOBOX)
                    .build(),
                    AttributeElement.builder("StatusLabel")
                            .labelName("Status")
                            .actionType(AttributeElement.ActionType.COMBOBOX)
                            .build()
        };

        ArrayList<Mitarbeiter> tempListMitarbeiter = Eventverwaltung.getEventverwaltung().getListeMitarbeiter();
        ArrayList<String> maped = new ArrayList(tempListMitarbeiter.stream().map(x->x.getKontaktdaten().getEmail().getGesamteEmail()).collect(Collectors.toList()));
        maped.add("All");
        ArrayList<String> status = new ArrayList(Arrays.asList(Status.getNames(Status.class)));
        status.add("All");

        elements[0].setData(maped.toArray());
        elements[0].setValue("All");
        elements[1].setData(status.toArray());
        elements[1].setValue("All");

        attributeComponent = AttributeComponent
                .builder("attComp")
                .attributeElements(elements)
                .title("Title")
                .build();
    }
}
