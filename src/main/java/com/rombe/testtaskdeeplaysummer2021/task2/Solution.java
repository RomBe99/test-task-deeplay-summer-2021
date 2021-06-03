package com.rombe.testtaskdeeplaysummer2021.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public static int getResult(String mapFields, String raceOfCreature) {
        final var columnsCount = 4;
        final var linesCount = 4;

        if (mapFields.length() != columnsCount * linesCount) {
            throw new IllegalArgumentException("Map size must be " + columnsCount * linesCount);
        }

        final var mapRepository = new MapRepository(Set.of(
                new MapFieldType("S"),
                new MapFieldType("W"),
                new MapFieldType("T"),
                new MapFieldType("P")
        ));
        final var creatureRepository = new CreatureRepository(List.of(
                new Creature("Human", Map.of(
                        mapRepository.getByValue("S").orElseThrow(), 5.0,
                        mapRepository.getByValue("W").orElseThrow(), 2.0,
                        mapRepository.getByValue("T").orElseThrow(), 3.0,
                        mapRepository.getByValue("P").orElseThrow(), 1.0
                )),
                new Creature("Swamper", Map.of(
                        mapRepository.getByValue("S").orElseThrow(), 2.0,
                        mapRepository.getByValue("W").orElseThrow(), 2.0,
                        mapRepository.getByValue("T").orElseThrow(), 5.0,
                        mapRepository.getByValue("P").orElseThrow(), 2.0
                )),
                new Creature("Woodman", Map.of(
                        mapRepository.getByValue("S").orElseThrow(), 3.0,
                        mapRepository.getByValue("W").orElseThrow(), 3.0,
                        mapRepository.getByValue("T").orElseThrow(), 2.0,
                        mapRepository.getByValue("P").orElseThrow(), 2.0
                ))
        ).stream().collect(Collectors.toMap(Creature::getRace, c -> c)));

        final var creature = creatureRepository.getCreature(raceOfCreature);

        final var chars = mapFields.toCharArray();
        final List<Double> weights = new ArrayList<>(mapFields.length());

        for (int i = 0; i < mapFields.length(); i++) {
            weights.add(creature
                    .getCharacteristic(mapRepository
                            .getByValue(String.valueOf(chars[i]))
                            .orElseThrow(IllegalArgumentException::new)));
        }

        return 0;
    }
}