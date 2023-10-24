package com.example.demo.constants;

public enum Role {
    USER("USER",0),
    ADMIN("ADMIN",1);

    final String name;
    final int index;
    Role (String name, int index) {
        this.name = name;
        this.index = index;
    }
};