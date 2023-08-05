package com.TPI2Spring.GameDevTaskManager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.TPI2Spring.GameDevTaskManager.exceptions.ValidationErrorResponse;
import com.TPI2Spring.GameDevTaskManager.exceptions.Violation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ValidationErrorHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e){
        ValidationErrorResponse error = new ValidationErrorResponse();
        for(ConstraintViolation violation: e.getConstraintViolations()){
            error.getViolations().add(
                new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
        }
        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e){
        ValidationErrorResponse error = new ValidationErrorResponse();
        for(FieldError fieldError:e.getBindingResult().getFieldErrors()){
            error.getViolations().add(
                new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return error;        
    }

}
