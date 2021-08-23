package com.model.dataTypes;

import java.util.Arrays;

public enum Rolle {

    ADMINISTRATOR,
    PERSONALMITARBEITER,
    MONTAGELEITER,
    GRUPPENLEITER,
    BESCHAFFUNGSPERSONAL,
    ORGANISATOR,
    MITARBEITER;

    public static String[] getNames(Class<? extends Enum<?>> e) {
        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
    }

}
