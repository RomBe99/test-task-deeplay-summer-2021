package com.rombe.testtaskdeeplaysummer2021;

public class UnknownTokenException extends RuntimeException {
    private final String unknownToken;

    public UnknownTokenException(String unknownToken) {
        super("Unknown token: ".concat(unknownToken));

        this.unknownToken = unknownToken;
    }

    public String getUnknownToken() {
        return unknownToken;
    }
}