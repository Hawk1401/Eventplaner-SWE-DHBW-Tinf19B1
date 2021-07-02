package com.gui;

import javax.print.attribute.Attribute;
import javax.swing.*;
import java.awt.*;
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
                    .build(),
                    AttributeElement.builder("MitarbeiterCombobox")
                            .actionType(AttributeElement.ActionType.COMBOBOX)
                            .build(),
                    AttributeElement.builder("StatusLabel")
                            .labelName("Status")
                            .build(),
                    AttributeElement.builder("StatusCombobox")
                            .actionType(AttributeElement.ActionType.COMBOBOX)
                            .build()
        };

        attributeComponent = AttributeComponent
                .builder("attComp")
                .attributeElements(elements)
                .title("Title")
                .build();
    }


}
