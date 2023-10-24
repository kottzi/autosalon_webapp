package com.example.demo.constants;

public enum Transmission {
    MANUAL("MANUAL",0),
    AUTOMATIC("AUTOMATIC",1);

    final String name;
    final int index;
    Transmission (String name, int index) {
        this.name = name;
        this.index = index;
    }
}
