package com.tplogistics.core.error_handling;

import com.tplogistics.core.error_handling.custom_error.InvalidRequest;
import com.tplogistics.core.error_handling.custom_error.NotFoundException;
import controller.base.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> errorResponse(HttpStatus statusCode, String message) {
        return ResponseEntity.status(statusCode).body(BaseResponse.error(statusCode, message));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return errorResponse(HttpStatus.BAD_REQUEST, message);
    }

    @ExceptionHandler(InvalidRequest.class)
    public ResponseEntity<Object> handleNotFoundException(
            InvalidRequest ex, WebRequest request) {
        return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleLocationNotFoundException(
            NotFoundException ex, WebRequest request) {
        return errorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        return errorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

}
