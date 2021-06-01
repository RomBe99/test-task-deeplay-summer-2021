package com.rombe.testtaskdeeplaysummer2021.task2;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MapFieldType {
    SWAMP("S"),
    WATER("W"),
    BUSHES("T"),
    PLAIN("P");

    private final String value;
    private static final Map<String, MapFieldType> valuesToMapFieldType = Stream.of(values())
            .collect(Collectors.toMap(MapFieldType::getValue, mapFieldType -> mapFieldType));

    MapFieldType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MapFieldType of(String value) {
        return valuesToMapFieldType.get(value);
    }
}