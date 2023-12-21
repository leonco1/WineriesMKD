package com.example.diansdomasna3.Model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WineNotFoundException extends RuntimeException{

    public WineNotFoundException(Long id) {
        super(String.format("Wine with id: %d was not found", id));
    }
}

