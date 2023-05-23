package com.dev.domain;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Dealer extends Person {

    private static final int DEALER_MIN_VALUE = 17;

    public Dealer() {
    }

    public Dealer(Hand hand) {
        super(hand);
    }

    @Override
    public void playTurn(Deck deck) {
        while (getHand().getValue() < DEALER_MIN_VALUE) {
            Card card = deck.drawCard();
            getHand().addCard(card);
            System.out.println("Dealer drew a card: " + card);
        }
        System.out.println("Dealer's final hand: " + getHand().getCards());
    }
}
