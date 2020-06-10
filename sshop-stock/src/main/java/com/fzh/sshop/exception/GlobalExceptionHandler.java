package com.fzh.sshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity handle(MethodArgumentNotValidException e) {
        if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            if (bindingResult.hasErrors() && bindingResult.hasFieldErrors()) {
                FieldError fieldError = bindingResult.getFieldError();
                BodyValidStatus bodyValidStatus = new BodyValidStatus.Builder().code("-9999")
                        .message(fieldError.getDefaultMessage())
                        .field(fieldError.getField()).build();
                return new ResponseEntity<>(bodyValidStatus, HttpStatus.OK);
            }
        }

        return ResponseEntity.ok(e);
    }
}