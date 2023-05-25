package com.dev.domain;

import java.util.ArrayList;
import java.util.List;
public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
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

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }
}
