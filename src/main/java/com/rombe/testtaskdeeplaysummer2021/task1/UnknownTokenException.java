package com.rombe.testtaskdeeplaysummer2021.task1;

public class UnknownTokenException extends RuntimeException {
    private final String unknownToken;

    public UnknownTokenException(String unknownToken) {
        super(String.format("Unknown token: %s", unknownToken));

        this.unknownToken = unknownToken;
    }

    public String getUnknownToken() {
        return unknownToken;
    }
}