package com.dev.application.domain.enums;

public enum Suit {
    SPADES("Spades"),
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts");

    private final String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }

    @Override
    public String toString() {
        return suitName;
    }
}
