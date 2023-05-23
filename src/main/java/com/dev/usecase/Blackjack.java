package com.dev.usecase;

import com.dev.domain.Card;
import com.dev.domain.Dealer;
import com.dev.domain.Deck;
import com.dev.domain.Player;
import com.dev.userinterface.BlackjackArts;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Scanner;

@ApplicationScoped
public class Blackjack {

    private final Player player;
    private final Dealer dealer;
    private final Deck deck;

    private String gameResult;

    @Inject
    public Blackjack() {
        this.player = new Player();
        this.dealer = new Dealer();
        this.deck = new Deck(true);
        deck.shuffleDeck();
    }

    public Player getPlayer() {
        return player;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Deck getDeck() {
        return deck;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void startGame() {
        BlackjackArts.displayStartGameArt();

        this.distributeCards();

        BlackjackArts.displayPersonHands(player, dealer);

        checkIfPersonHasBlackjackOrContinueGame();
    }

    private void checkIfPersonHasBlackjackOrContinueGame() {
        if (player.getHand().hasBlackjack()) {
            System.out.println("Player has a blackjack! Player wins!" + player.getHand().getCards().toString());
            BlackjackArts.displayWinArt();
            playAgain();
        } else if (dealer.getHand().hasBlackjack()) {
            System.out.println("Dealer has a blackjack! Dealer wins!" + dealer.getHand().getCards().toString());
            BlackjackArts.displayLoseArt();
            playAgain();
        } else {
            player.playTurn(deck);

            if (player.getHand().getValue() <= 21) {
                dealer.playTurn(deck);
            }

            compareHands();

            playAgain();
        }
    }

    private void distributeCards() {
        player.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
    }

    private void compareHands() {
        int playerHandValue = player.getHand().getValue();
        int dealerHandValue = dealer.getHand().getValue();

        BlackjackArts.displayCompareHands(playerHandValue, dealerHandValue);

        String gameWinner;
        boolean isPlayerWinner = false;

        if (playerHandValue > 21) {
            gameWinner = "Player busted! Dealer wins!";
        } else if (dealerHandValue > 21) {
            gameWinner = "Dealer busted! Player wins!";
            isPlayerWinner = true;
        } else if (playerHandValue == dealerHandValue) {
            gameWinner = "It's a tie!";
        } else if (playerHandValue > dealerHandValue) {
            gameWinner = "Player wins!";
            isPlayerWinner = true;
        } else {
            gameWinner = "Dealer wins!";
        }

        System.out.println(gameWinner + "\n");
        if (isPlayerWinner) {
            BlackjackArts.displayWinArt();
        } else {
            BlackjackArts.displayLoseArt();
        }
    }

    private void playAgain() {
        BlackjackArts.displayWannaPlayAgain();

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            player.getHand().clear();
            dealer.getHand().clear();

            deck.reset();
            deck.shuffleDeck();

            Blackjack blackjack = new Blackjack();
            blackjack.startGame();
        } else {
            BlackjackArts.displayEndGameArt();
        }
    }
}
