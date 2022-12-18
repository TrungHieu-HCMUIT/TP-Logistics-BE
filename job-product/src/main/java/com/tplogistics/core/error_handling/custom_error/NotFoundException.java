package com.tplogistics.core.error_handling.custom_error;

public class NotFoundException extends BaseException {
    public NotFoundException(String message) {
        super(message);
    }
}
