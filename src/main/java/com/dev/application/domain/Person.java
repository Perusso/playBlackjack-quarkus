package com.dev.application.domain;

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

    public abstract void playTurn(Deck deck);
}
