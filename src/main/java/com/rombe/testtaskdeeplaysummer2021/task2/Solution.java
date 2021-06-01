package com.rombe.testtaskdeeplaysummer2021.task2;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Solution {
    public static int getResult(String mapFields, String raceOfCreature) {
        final var columnsCount = 4;
        final var linesCount = 4;

        if (mapFields.length() != columnsCount * linesCount) {
            // TODO throw exception
        }

        final var creature = Creature.of(raceOfCreature);

        final var chars = mapFields.toCharArray();
        final Map<Integer, Map<Integer, Integer>> graph = new LinkedHashMap<>(linesCount);

        for (int i = 0; i < linesCount; i++) {
            final Map<Integer, Integer> columns = new LinkedHashMap<>(columnsCount);

            for (int j = 0; j < columnsCount; j++) {
                columns.put(j, creature.getCharacteristic(Optional
                        .ofNullable(MapFieldType.of(String.valueOf(chars[i * columnsCount + j])))
                        .orElseThrow(RuntimeException::new)));
            }

            graph.put(i, columns);
        }

        return 0;
    }
}