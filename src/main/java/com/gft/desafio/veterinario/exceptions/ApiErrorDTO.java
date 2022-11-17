package com.gft.desafio.veterinario.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ApiErrorDTO {

    private String message;
    private List<String> errors;
    private HttpStatus status;

    public ApiErrorDTO() {

    }
    public ApiErrorDTO(String message, List<String> errors, HttpStatus status) {
        super();
        this.message = message;
        this.errors = errors;
        this.status = status;
    }
    public ApiErrorDTO(String message, String error, HttpStatus status) {
        super();
        this.message = message;
        this.errors = Arrays.asList(error);
        this.status = status;
    }

}

