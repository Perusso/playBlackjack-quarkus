package com.dev.application.domain;

import com.dev.application.userinterface.BlackjackAscii;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class Dealer extends Person {

    private static final int DEALER_MIN_VALUE = 17;

    public Dealer() {
    }

    public Dealer(Hand hand) {
        super(hand);
    }

    public void playTurn(Deck deck) {
        while (getHand().getValue() < DEALER_MIN_VALUE) {
            Card card = deck.drawCard();
            if (card == null) {
                break;
            }
            getHand().addCard(card);
            BlackjackAscii.displayDealerDrawACard(card);
        }
        BlackjackAscii.displayDealerFinalHand(getHand());
    }
}
