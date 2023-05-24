package com.dev.domain;

public class Card {

    private Figure figure;

    private Suit suit;

    public Card(Figure figure, Suit suit) {
        this.figure = figure;
        this.suit = suit;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getFigureValue() {
        return figure.getFigureValue();
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "" +
                figure + " of " + suit +
                //+ " (" + figure.getFigureValue() + ")" +
                "";
    }
}
