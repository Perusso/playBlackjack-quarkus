package com.dev.application.domain;

import com.dev.application.domain.enums.Rank;

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
        int value = calculateHandValue(cards);
        int numOfAces = countAces(cards);

        value = reduceValueIfBusted(value, numOfAces);

        return value;
    }

    private int calculateHandValue(List<Card> cards) {
        return cards.stream()
                .mapToInt(Card::getFigureValue)
                .sum();
    }

    private int countAces(List<Card> cards) {
        return (int) cards.stream()
                .filter(card -> card.getFigure() == Rank.ACE)
                .count();
    }

    private int reduceValueIfBusted(int value, int numOfAces) {
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
