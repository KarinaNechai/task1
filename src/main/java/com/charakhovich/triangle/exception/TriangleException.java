package com.charakhovich.triangle.exception;

public class TriangleException extends Throwable {
    public TriangleException() {
    }

    public TriangleException(String message) {
        super(message);
    }

    public TriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleException(Throwable cause) {
        super(cause);
    }
}
