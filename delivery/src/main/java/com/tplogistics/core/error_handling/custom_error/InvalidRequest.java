package com.tplogistics.core.error_handling.custom_error;

public class InvalidRequest extends BaseCustomException {
    public InvalidRequest(String message) {
        super(message);
    }
}
