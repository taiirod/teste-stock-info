package com.teste.stockinfo.model.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum TipoContaEnum {
    Normal(0), Eventual(1);

    private final int value;
    private static final Map<Integer, TipoContaEnum> map;

    TipoContaEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    static {
        map = Arrays.stream(values()).collect(Collectors.toMap(e -> e.value, e -> e));
    }

    public static TipoContaEnum fromInt(int value) {
        return map.get(value);
    }
}