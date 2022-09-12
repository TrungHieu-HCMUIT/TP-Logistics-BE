package com.trunnghieu.tplogistics.aspect.error_handling.custom_exception;

public class CannotUpdateException extends RuntimeException {
    public CannotUpdateException(String modelName) {
        super(String.format("Cannot update %s", modelName));
    }
}
