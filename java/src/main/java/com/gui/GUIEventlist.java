package com.gui;

import de.dhbwka.swe.utils.*;
import de.dhbwka.swe.utils.gui.SimpleTableComponent;
import de.dhbwka.swe.utils.model.Attribute;
import de.dhbwka.swe.utils.model.IDepictable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUIEventlist extends GUIComponent{

    //TODO still nothing there
    SimpleTableComponent table;

    public GUIEventlist() {
        IDepictable[] elems = new IDepictable[]{
                new tableclass("michi", 52),
                new tableclass("alex", 21)
        };

        table = SimpleTableComponent.builder("tableEvents").selectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ).columnNames(new String[]{"name", "age"}).build();

        table.setData(elems, new String[]{"name", "age"});
    }

    public SimpleTableComponent getTable(){return table;}

    //temp
    public class tableclass implements IDepictable{

        String name;
        int age;

        public tableclass(String name, int age){
            this.name = name;
            this.age = age;
        }
        @Override
        public String getElementID() {
            return this.name;
        }

        @Override
        public Attribute[] getAttributeArray() {
            return new Attribute[] { new Attribute("name",
                    this.name,
                    String.class,
                    this.name,
                    "name",
                    true,
                    true,
                    true
            ),
                    new Attribute("age",
                            this.age,
                            int.class,
                            this.age,
                            "age",
                            true,
                            true,
                            true
                    )};
        }

        //Attribute(String name, Object dedicatedInstance, Class<?> clazz, Object value, Object defaultValue, boolean visible, boolean modifiable, boolean editable)
    }
    //temp
}
