package com.dev.usecase;

import com.dev.domain.Dealer;
import com.dev.domain.Deck;
import com.dev.domain.Player;

public class Blackjack {

    public void startGame() {

        System.out.println("-----------------------------------");
        System.out.println("Welcome to Blackjack!");

        Player player = new Player();
        Dealer dealer = new Dealer();
        Deck deck = new Deck(true);

        System.out.println("Player's hand: " + player.getHand());
        System.out.println("Dealer's hand: " + dealer.getHand());
        System.out.println("Cards in Deck: " + deck.getDeck().size());
    }
}
