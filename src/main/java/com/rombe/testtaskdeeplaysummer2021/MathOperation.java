package com.rombe.testtaskdeeplaysummer2021;

import java.util.Objects;
import java.util.function.Function;

public class MathOperation<T, R> {
    private String token;
    private Function<T, R> operation;

    public MathOperation(String token, Function<T, R> operation) {
        setToken(token);
        setOperation(operation);
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setOperation(Function<T, R> operation) {
        this.operation = operation;
    }

    public String getToken() {
        return token;
    }

    public Function<T, R> getOperation() {
        return operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathOperation<?, ?> that = (MathOperation<?, ?>) o;
        return Objects.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token);
    }
}