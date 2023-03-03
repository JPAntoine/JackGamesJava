package com.xbal.app.jackgames.model;

enum Suite {
    Heart,
    Spade,
    Diamond,
    Clubs
}

public class Card {
    Integer value;
    Suite suite;

    Card(Integer value, Suite suite){
        this.value = value;
        this.suite = suite;
    }

    public int getValue() {
        return 0;
    }

    public Object getRank() {
        return null;
    }
}
