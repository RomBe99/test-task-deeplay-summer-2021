package com.rombe.testtaskdeeplaysummer2021.task2;

import java.util.Map;

public class CreatureRepository {
    private final Map<String, Creature> creatures;

    public CreatureRepository(Map<String, Creature> creatures) {
        this.creatures = creatures;
    }

    public Creature getCreature(String raceOfCreature) {
        return creatures.get(raceOfCreature);
    }
}