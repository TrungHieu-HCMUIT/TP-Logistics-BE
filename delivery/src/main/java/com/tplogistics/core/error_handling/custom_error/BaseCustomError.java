package com.tplogistics.core.error_handling.custom_error;

public class BaseCustomError extends RuntimeException {
    protected BaseCustomError(String message) {
        super(message);
    }
}
