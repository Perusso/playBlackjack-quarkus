package com.dev.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Deck {

    private ArrayList<Card> deck;


    public Deck(){
        this.deck = new ArrayList<Card>();
    }

    public Deck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public void addCard(Card card) {
        deck.add(card);

    }

    public void addCards(ArrayList<Card> cards) {
        deck.addAll(cards);
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        if (isEmpty()) {
            return null;
        }
        return deck.remove(0);
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public void reset() {
        deck.clear();
    }

    public String toString() {
        return deck.stream()
                .map(Card::toString)
                .collect(Collectors.joining("\n"));
    }

}
