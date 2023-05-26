package com.dev.application.usecase;

import com.dev.application.domain.Dealer;
import com.dev.application.domain.Deck;
import com.dev.application.domain.Player;
import com.dev.application.domain.enums.Choice;
import com.dev.application.userinterface.BlackjackAscii;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Scanner;

@ApplicationScoped
public class Blackjack {

    private final Player player;
    private final Dealer dealer;
    private final Deck deck;
    private int wins, losses, ties;
    private Scanner scanner = new Scanner(System.in);

    public Blackjack() {
        this.player = new Player();
        this.dealer = new Dealer();
        this.deck = new Deck(true);
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
        deck.shuffleDeck();
    }

    public Blackjack(Deck deck, Player player, Dealer dealer, int wins, int losses, int ties) {
        this.player = player;
        this.dealer = dealer;
        this.deck = deck;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getLosses() {
        return losses;
    }

    public int getWins() {
        return wins;
    }

    public void startGame(boolean isFirstTime) {

        if (isFirstTime) {
            BlackjackAscii.displayStartGameArt();
        }

        checkDeckSize();

        BlackjackAscii.displayNewGame();

        this.distributeCards();

        BlackjackAscii.displayPersonHands(player, dealer);

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
            BlackjackAscii.displayWinArt();
            wins++;
            playAgain();
        } else if (dealer.getHand().hasBlackjack()) {
            System.out.println("Dealer has a blackjack! Dealer wins! \n" + dealer.getHand().getCards().toString());
            BlackjackAscii.displayLoseArt();
            losses++;
            playAgain();
        } else {
            pause(500);
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

        BlackjackAscii.displayCompareHands(playerHandValue, dealerHandValue);

        String gameWinner;

        if (playerHandValue > 21) {
            gameWinner = "Player busted! Dealer wins!";
            BlackjackAscii.displayLoseArt();
            losses++;
        } else if (dealerHandValue > 21) {
            gameWinner = "Dealer busted! Player wins!";
            BlackjackAscii.displayWinArt();
            wins++;
        } else if (playerHandValue == dealerHandValue) {
            gameWinner = "It's a tie!";
            BlackjackAscii.displayTieArt();
            ties++;
        } else if (playerHandValue > dealerHandValue) {
            gameWinner = "Player wins!";
            BlackjackAscii.displayWinArt();
            wins++;
        } else {
            gameWinner = "Dealer wins!";
            BlackjackAscii.displayLoseArt();
            losses++;
        }
        System.out.println(gameWinner + "\n");
    }

    private void playAgain() {
        BlackjackAscii.displayWannaPlayAgain();

        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase(Choice.YES.getOption())) {
            pause(1000);
            restartGame();

        } else if (choice.equalsIgnoreCase(Choice.NO.getOption())) {
            BlackjackAscii.displayExitMessage();

        } else if (choice.equalsIgnoreCase(Choice.REPORT.getOption())) {
            BlackjackAscii.displayGameStatistics(wins, losses, ties);
            playAgain();

        } else {
            System.out.println("Invalid choice. Please choose a valid option.");
            playAgain();
        }
    }

    private void restartGame() {
        player.getHand().clear();
        dealer.getHand().clear();

        deck.shuffleDeck();

        Blackjack blackjack = new Blackjack(deck, player, dealer, wins, losses, ties);
        blackjack.startGame(false);
    }

    public static void pause(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
