package com.example.demo.constants;

public enum Engine {
    GASOLIN("GASOLIN",0),
    DIESEL("DIESEL",1),
    ELECTRIC("ELECTRIC",2),
    HYBRID("HYBRID",3);

    final String name;
    final int index;
    Engine (String name, int index) {
        this.name = name;
        this.index = index;
    }
}
