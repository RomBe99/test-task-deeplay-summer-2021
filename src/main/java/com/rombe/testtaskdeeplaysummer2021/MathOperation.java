package com.rombe.testtaskdeeplaysummer2021;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MathOperation {
    INCREMENT("i"),
    DECREMENT("d"),
    SQUARE("s");

    private final String value;
    private static final Map<String, MathOperation> operations = Stream.of(values())
            .collect(Collectors.toMap(o -> o.value, o -> o));

    public static MathOperation of(final String value) {
        return operations.get(value);
    }

    MathOperation(String value) {
        this.value = value;
    }
}
