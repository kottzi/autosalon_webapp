package com.example.demo.controllers.exceptions;

import java.util.UUID;

public class ModelNotFoundException extends RuntimeException {
    public ModelNotFoundException(UUID id) {
        super("Could not find model: " + id);
    }
}
