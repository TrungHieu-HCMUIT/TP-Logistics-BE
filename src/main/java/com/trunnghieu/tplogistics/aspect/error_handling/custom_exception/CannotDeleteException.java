package com.trunnghieu.tplogistics.aspect.error_handling.custom_exception;

public class CannotDeleteException extends RuntimeException {
    public CannotDeleteException(String modelName) {
        super(String.format("Cannot delete %s", modelName));
    }
}
