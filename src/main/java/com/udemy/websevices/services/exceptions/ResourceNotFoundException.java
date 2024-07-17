package com.udemy.websevices.services.exceptions;


import java.io.Serializable;

public class ResourceNotFoundException extends RuntimeException {
    private final static long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found for id: " + id);
    }
}
