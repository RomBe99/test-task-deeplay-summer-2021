package com.rombe.testtaskdeeplaysummer2021.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SolutionTest {
    @ParameterizedTest
    @MethodSource("correctInputValues")
    public void getResultWithCorrectDataTest(String fieldsMap, String raceOfCreature, int expectedResult) {
        final var actualResult = Solution.getResult(fieldsMap, raceOfCreature);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> correctInputValues() {
        return Stream.of(
                Arguments.arguments("STWSWTPPTPTTPWPP", "Human", 10)
        );
    }
}
