package com.rombe.testtaskdeeplaysummer2021.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Creature {
    private String race;
    private Map<MapFieldType, Double> characteristics;

    public Creature(String race, Map<MapFieldType, Double> characteristics) {
        setRace(race);
        setCharacteristics(characteristics);
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setCharacteristics(Map<MapFieldType, Double> characteristics) {
        this.characteristics = characteristics == null ? new HashMap<>() : characteristics;
    }

    public String getRace() {
        return race;
    }

    public Double getCharacteristic(MapFieldType fieldType) {
        return characteristics.get(fieldType);
    }
}