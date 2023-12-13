package com.example.demo.web.exceptions;

import java.util.UUID;

public class UserRoleNotFoundException extends RuntimeException {
    public UserRoleNotFoundException(UUID id) {
        super("Could not find role: " + id);
    }
}
