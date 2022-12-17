package com.tplogistics.core.error_handling.custom_error;

public class BaseException extends RuntimeException {
    protected BaseException(String message) {
        super(message);
    }
}
