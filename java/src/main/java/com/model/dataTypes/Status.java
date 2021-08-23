package com.model.dataTypes;

import java.util.Arrays;

public enum Status {

    ERSTELLT,
    GEPLANT,
    IN_ARBEIT,
    MONTAGE_BEREIT,
    FERTIG,
    ABGESCHLOSSEN;

    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

}
