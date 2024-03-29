package com.example.demo.exceptions;

import java.util.UUID;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(UUID id) {
        super("Could not find brand: " + id);
    }
}
