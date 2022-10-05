package com.tplogistics.core.error_handling.custom_error;

public class BaseCustomException extends RuntimeException {
    protected BaseCustomException(String message) {
        super(message);
    }
}
