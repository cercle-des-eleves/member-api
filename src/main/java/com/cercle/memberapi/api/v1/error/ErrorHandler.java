package com.cercle.memberapi.api.v1.error;

import com.cercle.memberapi.business.exception.ResourceNotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Configuration
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomApiError> throwResourceNotFoundException(ResourceNotFoundException e) {
        CustomApiError error = new CustomApiError();
        error.setMessage("Resource not found");
        error.setStatus(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
