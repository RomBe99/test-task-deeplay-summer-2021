package com.rombe.testtaskdeeplaysummer2021.task2;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class MapRepository {
    private final Set<MapFieldType> fieldTypes;

    public MapRepository(Set<MapFieldType> fieldTypes) {
        this.fieldTypes = fieldTypes;
    }

    public Optional<MapFieldType> getByValue(String value) {
        return fieldTypes.stream()
                .filter(t -> t.getValue().equals(value))
                .findFirst();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapRepository that = (MapRepository) o;
        return Objects.equals(fieldTypes, that.fieldTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldTypes);
    }
}
