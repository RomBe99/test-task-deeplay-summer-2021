package com.rombe.testtaskdeeplaysummer2021.task2;

import java.util.Objects;

public class MapFieldType {
    private String value;

    public MapFieldType(String value) {
        setValue(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapFieldType that = (MapFieldType) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}