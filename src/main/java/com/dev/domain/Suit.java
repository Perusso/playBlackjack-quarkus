package com.dev.domain;

public enum Suit {
    SPADE("Spades"),
    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts");

    private String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }

    @Override
    public String toString() {
        return suitName;
    }
}
