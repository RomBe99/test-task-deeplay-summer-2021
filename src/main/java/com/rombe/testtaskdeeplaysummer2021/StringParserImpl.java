package com.rombe.testtaskdeeplaysummer2021;

import java.util.*;
import java.util.function.Function;

public class StringParserImpl implements StringParser {
    private final Map<MathOperation, Function<Integer, Integer>> operations = Map.of(
            MathOperation.INCREMENT, i -> i + 1,
            MathOperation.DECREMENT, i -> i - 1,
            MathOperation.SQUARE, i -> i * i
    );
    private final int startValue;

    public StringParserImpl(int startValue) {
        this.startValue = startValue;
    }

    @Override
    public List<Integer> getResult(String input) {
        final List<Integer> result = new LinkedList<>();

        Function<Integer, Integer> tempFun = i -> i;

        for (char c : input.toCharArray()) {
            if (c == 'o') {
                result.add(tempFun.apply(startValue));

                continue;
            }

            final var currentOperation = Optional
                    .ofNullable(MathOperation.of(String.valueOf(c)))
                    .orElseThrow();

            tempFun = tempFun.andThen(operations.get(currentOperation));
        }

        return result;
    }
}