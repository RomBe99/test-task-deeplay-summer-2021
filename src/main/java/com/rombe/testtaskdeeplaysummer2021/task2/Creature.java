package com.rombe.testtaskdeeplaysummer2021.task2;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Creature {
    HUMAN("Human", Map.of(
            MapFieldType.SWAMP, 5,
            MapFieldType.WATER, 2,
            MapFieldType.BUSHES, 3,
            MapFieldType.PLAIN, 1
    )),
    SWAMPER("Swamper", Map.of(
            MapFieldType.SWAMP, 2,
            MapFieldType.WATER, 2,
            MapFieldType.BUSHES, 5,
            MapFieldType.PLAIN, 2
    )),
    WOODMAN("Woodman", Map.of(
            MapFieldType.SWAMP, 3,
            MapFieldType.WATER, 3,
            MapFieldType.BUSHES, 2,
            MapFieldType.PLAIN, 2
    ));

    private final String raceOfCreature;
    private final Map<MapFieldType, Integer> characteristics;
    private static final Map<String, Creature> creatureRaceToCreature = Stream.of(values())
            .collect(Collectors.toMap(Creature::getRaceOfCreature, creature -> creature));

    Creature(String raceOfCreature, Map<MapFieldType, Integer> characteristics) {
        this.raceOfCreature = raceOfCreature;
        this.characteristics = characteristics;
    }

    public Integer getCharacteristic(MapFieldType type) {
        return characteristics.get(type);
    }

    public String getRaceOfCreature() {
        return raceOfCreature;
    }

    public static Creature of(String raceOfCreature) {
        return creatureRaceToCreature.get(raceOfCreature);
    }
}