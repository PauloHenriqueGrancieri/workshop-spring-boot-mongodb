package com.paulohenriquegrancieri.workshopmongo.resources.exception;

import com.paulohenriquegrancieri.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandardError error =
                new StandardError(System.currentTimeMillis(),
                        HttpStatus.NOT_FOUND.value(),
                        "Nao encontrado",
                        e.getMessage(),
                        request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
