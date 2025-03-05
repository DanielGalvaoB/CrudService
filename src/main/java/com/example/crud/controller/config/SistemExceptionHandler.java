package com.example.crud.controller.config;

import com.example.crud.model.ParameterNotValidException;
import com.example.crud.model.PreconditionException;
import com.example.crud.model.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class SistemExceptionHandler {

    @ExceptionHandler(value = {ParameterNotValidException.class})
    public ResponseEntity<ErrorMessage> parameterNotValidException(ParameterNotValidException e, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                e.getCode(),
                e.getMessage(),
                LocalDateTime.now(),
                "Qualquer coisa por hora");

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ErrorMessage> parameterNotValidException(ResourceNotFoundException e, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                e.getCode(),
                e.getMessage(),
                LocalDateTime.now(),
                "Qualquer coisa por hora");

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {PreconditionException.class})
    public ResponseEntity<ErrorMessage> parameterNotValidException(PreconditionException e, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                e.getCode(),
                e.getMessage(),
                LocalDateTime.now(),
                "Qualquer coisa por hora");

        return new ResponseEntity<ErrorMessage>(message, HttpStatus.PRECONDITION_FAILED);
    }
}
