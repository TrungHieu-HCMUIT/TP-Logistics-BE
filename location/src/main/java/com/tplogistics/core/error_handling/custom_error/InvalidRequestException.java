package com.tplogistics.core.error_handling.custom_error;

public class InvalidRequestException extends BaseException {
    public InvalidRequestException(String message) {
        super(message);
    }
}
