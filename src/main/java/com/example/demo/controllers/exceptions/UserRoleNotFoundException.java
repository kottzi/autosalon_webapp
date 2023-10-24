package com.example.demo.controllers.exceptions;

import java.util.UUID;

public class UserRoleNotFoundException extends RuntimeException {
    public UserRoleNotFoundException(UUID id) {
        super("Could not find role: " + id);
    }
}
