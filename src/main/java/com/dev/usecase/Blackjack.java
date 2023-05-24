package com.dev.usecase;

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

    //Constructor for Blackjack that do not create a full deck, for purpose of using the same deck for multiple game rounds
    public Blackjack(Deck deck) {
        this.player = new Player();
        this.dealer = new Dealer();
        this.deck = deck;
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

    public void startGame(boolean isFirstTime) {

        if (isFirstTime) {
            BlackjackArts.displayStartGameArt();
        }

        checkDeckSize();

        BlackjackArts.displayNewGame();

        this.distributeCards();

        BlackjackArts.displayPersonHands(player, dealer);

        checkIfPersonHasBlackjackOrContinueGame();
    }

    private void checkDeckSize() {
        //check if the deck contains at least 4 cards to play a new game, otherwise, a new full deck is created
        if (deck.getDeck().size() < 4) {
            deck.reset();
            deck.addCards(new Deck(true).getDeck());
            deck.shuffleDeck();
        }
    }

    private void checkIfPersonHasBlackjackOrContinueGame() {
        if (player.getHand().hasBlackjack()) {
            System.out.println("Player has a blackjack! Player wins! \n" + player.getHand().getCards().toString());
            BlackjackArts.displayWinArt();
            playAgain();
        } else if (dealer.getHand().hasBlackjack()) {
            System.out.println("Dealer has a blackjack! Dealer wins! \n" + dealer.getHand().getCards().toString());
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

        if (playerHandValue > 21) {
            gameWinner = "Player busted! Dealer wins!";
            BlackjackArts.displayLoseArt();
        } else if (dealerHandValue > 21) {
            gameWinner = "Dealer busted! Player wins!";
            BlackjackArts.displayWinArt();
        } else if (playerHandValue == dealerHandValue) {
            gameWinner = "It's a tie!";
            BlackjackArts.displayTieArt();
        } else if (playerHandValue > dealerHandValue) {
            gameWinner = "Player wins!";
            BlackjackArts.displayWinArt();
        } else {
            gameWinner = "Dealer wins!";
            BlackjackArts.displayLoseArt();
        }
        System.out.println(gameWinner + "\n");
    }

    private void playAgain() {
        BlackjackArts.displayWannaPlayAgain();

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            player.getHand().clear();
            dealer.getHand().clear();

            deck.shuffleDeck();

            Blackjack blackjack = new Blackjack(deck);
            blackjack.startGame(false);
        } else if (choice.equalsIgnoreCase("N")) {
            BlackjackArts.displayExitMessage();
        } else {
            System.out.println("Invalid choice. Please choose a valid option.");
            playAgain();
        }
    }
}
