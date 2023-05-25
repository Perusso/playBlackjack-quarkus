package com.dev.domain;


import com.dev.userinterface.BlackjackAscii;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.InputMismatchException;
import java.util.Scanner;

@ApplicationScoped
public class Player extends Person {

    Scanner scanner;

    public Player() {
        scanner = new Scanner(System.in);
    }

    public Player(Hand hand) {
        super(hand);
    }

    public Player(Hand hand, Scanner scanner) {
        super(hand);
        this.scanner = scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getChoice() {
        int choice;
        do {
            BlackjackAscii.displayPlayerChooseAction();
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                choice = -1;
                scanner.nextLine();
            }
            if (choice != 1 && choice != 2) {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 1 && choice != 2);
        return choice;
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

                BlackjackAscii.displayPlayerHit(newCard, hand);

                if (hand.getValue() <= 21) {
                    playTurn(deck);
                }
                break;
            case 2:
                // Player chooses to stand
                BlackjackAscii.displayPlayerStand();
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
                playTurn(deck);
                break;
        }
    }
}

