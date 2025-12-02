package com.example.pokedex.exception;

import com.example.pokedex.dto.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErroResponse> handleRuntimeException(RuntimeException ex) {
        String errorMessage = ex.getMessage();

        return new ResponseEntity<>(new ErroResponse(errorMessage), HttpStatus.CONFLICT);
    }
}
