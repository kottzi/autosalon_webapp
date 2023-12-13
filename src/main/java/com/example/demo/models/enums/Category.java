package com.example.demo.models.enums;

public enum Category {
    CAR(1), BUSS(2), TRUCK(3), MOTORCYCLE(4);

    private final int index;
    Category (int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }
}