package com.teste.stockinfo.model.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum SexoEnum {
    USE(0), MAINTENANCE(1), ASCENSION(2);

    private final int value;
    private static final Map<Integer, SexoEnum> map;

    SexoEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    static {
        map = Arrays.stream(values()).collect(Collectors.toMap(e -> e.value, e -> e));
    }

    public static SexoEnum fromInt(int value) {
        return map.get(value);
    }
}