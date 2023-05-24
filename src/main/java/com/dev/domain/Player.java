package com.dev.domain;


import com.dev.userinterface.BlackjackArts;
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

    public int getChoice() {
        int choice;
        do {
            BlackjackArts.displayPlayerChooseAction();
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                choice = -1; // Valor inválido para indicar uma opção inválida
                scanner.nextLine(); // Limpar o buffer do scanner
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

