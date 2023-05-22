package com.dev.domain;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void clear() {
        cards.clear();
    }

    public int getValue() {
        int value = 0;
        int numOfAces = 0;

        for (Card card : cards) {
            if (card.getFigure() == Figure.ACE) {
                numOfAces++;
            }
            value += card.getFigureValue();
        }

        while (value > 21 && numOfAces > 0) {
            value -= 10;
            numOfAces--;
        }

        return value;
    }

    public boolean hasBlackjack() {
        return cards.size() == 2 && getValue() == 21;
    }

    public boolean hasBusted() {
        return getValue() > 21;
    }

    public boolean canSplit() {
        return cards.size() == 2 && cards.get(0).getFigure() == cards.get(1).getFigure();
    }

    public List<Hand> split() {
        if (!canSplit()) {
            throw new IllegalStateException("Hand cannot be split");
        }

        Hand hand1 = new Hand();
        Hand hand2 = new Hand();
        hand1.addCard(cards.get(0));
        hand2.addCard(cards.get(1));

        return List.of(hand1, hand2);
    }

    public boolean canDoubleDown() {
        return cards.size() == 2;
    }

    public void doubleDown(Card card) {
        if (!canDoubleDown()) {
            throw new IllegalStateException("Cannot double down on current hand");
        }

        cards.add(card);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }
}
