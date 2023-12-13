package com.example.demo.models.enums;

public enum Transmission {
    MANUAL(0), AUTOMATIC(1);

    private final int index;
    Transmission (int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }
}
