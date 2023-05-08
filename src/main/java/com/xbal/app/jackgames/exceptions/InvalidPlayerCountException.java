package com.xbal.app.jackgames.exceptions;

public class InvalidPlayerCountException extends RuntimeException {

    public InvalidPlayerCountException() {
        super("Number of Players must be at least 1");
    }

    public InvalidPlayerCountException(String message) {
        super(message);
    }
}
