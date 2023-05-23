package com.dev.domain;

import java.util.List;

public abstract class Person {

    protected Hand hand;

    public Person(){
        this.hand = new Hand();
    }

    public Person(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public List<Card> getCardsInHand() {
        return hand.getCards();
    }

    public abstract void playTurn(Deck deck);
}
