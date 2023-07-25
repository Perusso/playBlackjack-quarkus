package com.dev.application.domain;

import com.dev.application.domain.enums.Rank;
import com.dev.application.domain.enums.Suit;

public class Card {

    private Rank rank;

    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getFigure() {
        return rank;
    }

    public int getFigureValue() {
        return rank.getFigureValue();
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "" +
                rank + " of " + suit +
                "";
    }
}
