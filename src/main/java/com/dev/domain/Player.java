package com.dev.domain;


import com.dev.userinterface.BlackjackArts;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Scanner;

@ApplicationScoped
public class Player extends Person {

    Scanner scanner;

    public Player() {
        scanner = new Scanner(System.in);
    }

    public Player(Hand hand) {
        super(hand);
        scanner = new Scanner(System.in);
    }

    public int getChoice() {
        BlackjackArts.displayPlayerChooseAction();
        return scanner.nextInt();
    }

    @Override
    public void playTurn(Deck deck) {

        int choice = getChoice();

        switch (choice) {
            case 1:
                // Player chooses to hit
                Hand hand = getHand();
                Card newCard = deck.drawCard();
                hand.addCard(newCard);

                BlackjackArts.displayPlayerHit(newCard, hand);

                if (hand.getValue() <= 21) {
                    playTurn(deck);
                }
                break;
            case 2:
                // Player chooses to stand
                BlackjackArts.displayPlayerStand();
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
                playTurn(deck);
                break;
        }
    }
}

