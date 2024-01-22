package com.example.demo.models.enums;

public enum UserRole {
    USER("USER",0), ADMIN("ADMIN",1);

    private final String name;
    private final int index;

    UserRole(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }
}