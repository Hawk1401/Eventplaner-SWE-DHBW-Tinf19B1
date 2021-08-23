package com.model.dataTypes;

import java.util.Arrays;

public enum Kapaziteat{
    KLEIN,
    MITTEL,
    GROSS,
    NON;
    
    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }
    
}
