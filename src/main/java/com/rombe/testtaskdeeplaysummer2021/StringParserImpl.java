package com.rombe.testtaskdeeplaysummer2021;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringParserImpl implements StringParser {
    private final Map<String, Function<Integer, Integer>> operations;
    private final int startValue;

    public StringParserImpl(final int startValue, final List<MathOperation<Integer, Integer>> operations) {
        this.startValue = startValue;
        this.operations = operations.stream()
                .collect(Collectors.toMap(MathOperation::getToken, MathOperation::getOperation));
    }

    @Override
    public List<Integer> getResult(String input) {
        if (input == null) {
            return Collections.emptyList();
        }

        final List<Integer> result = new LinkedList<>();

        Function<Integer, Integer> tempFun = i -> i;

        for (char c : input.toCharArray()) {
            if (c == 'o') {
                result.add(tempFun.apply(startValue));

                continue;
            }

            final String currentToken = String.valueOf(c);

            tempFun = tempFun.andThen(
                    Optional.ofNullable(operations.get(currentToken))
                            .orElseThrow(() -> new UnknownTokenException(currentToken)));
        }

        return result;
    }
}