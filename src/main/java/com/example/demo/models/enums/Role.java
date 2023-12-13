package com.example.demo.models.enums;

public enum Role {
    USER("USER",0), ADMIN("ADMIN",1);

    private final String name;
    private final int index;

    Role(String name, int index) {
        this.name = name;
        this.index = index;
    }
}