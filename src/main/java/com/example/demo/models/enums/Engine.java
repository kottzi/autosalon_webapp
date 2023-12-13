package com.example.demo.models.enums;

public enum Engine {
    GASOLIN(1), DIESEL(2), ELECTRIC(3), HYBRID(4);

    private final int index;
    Engine (int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }
}
