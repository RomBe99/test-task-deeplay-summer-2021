package com.rombe.testtaskdeeplaysummer2021;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class StringParserImplTest {
    private final StringParser parser = new StringParserImpl(0);

    @ParameterizedTest
    @MethodSource("correctInputValues")
    public void getResultWithCorrectInputTest(String input, List<Integer> expectedResult) {
        final var actualResult = parser.getResult(input);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> correctInputValues() {
        return Stream.of(
                Arguments.of("", Collections.emptyList()),
                Arguments.of("iiisdoso", List.of(8, 64)),
                Arguments.of("idsoiisdssdo", List.of(0, 80)),
                Arguments.of("iisiisiisdsdo", List.of(2082248)),
                Arguments.of("ioioioiodo", List.of(1, 2, 3, 4, 3)),
                Arguments.of("dddoooiidoso", List.of(-3, -3, -3, -2, 4)),
                Arguments.of("ddddsoddsdsdsoiiidoddo", List.of(16, 1445824576, 1445824578, 1445824576))
        );
    }
}