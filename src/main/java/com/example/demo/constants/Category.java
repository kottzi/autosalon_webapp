package com.example.demo.constants;

public enum Category {
    CAR("CAR",0),
    BUSS("BUSS",1),
    TRUCK("TRUCK",2),
    MOTORCYCLE("MOTORCYCLE",3);

    final String name;
    final int index;
    Category (String name, int index) {
        this.name = name;
        this.index = index;
    }
}