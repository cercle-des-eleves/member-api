package com.cercle.memberapi.api.v1.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
public class CustomApiError {
    private Instant date = Instant.now();
    private HttpStatus status;
    private String message;

}
