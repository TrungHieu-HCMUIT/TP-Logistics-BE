package com.tplogistics.core.error_handling.custom_error;

public class NotFoundException extends BaseCustomException {
    public NotFoundException(String message) {
        super(message);
    }
}
