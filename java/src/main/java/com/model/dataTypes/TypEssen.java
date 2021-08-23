package com.model.dataTypes;

import java.util.Arrays;

public enum TypEssen {

    VEGAN,
    VEGETARISCH,
    FLEISCH_FISCH;

    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

}
