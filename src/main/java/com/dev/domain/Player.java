package com.dev.domain;


import java.util.List;
import java.util.Scanner;

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
        System.out.println("It's your turn. Choose an action:");
        System.out.println("1. Hit");
        System.out.println("2. Stand");
        System.out.println("Enter your choice: ");

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
                System.out.println("Player drew a card: " + newCard);
                System.out.println("Player's hand: " + hand.getCards());
                if (hand.getValue() <= 21) {
                    playTurn(deck); // Chama o método novamente para permitir nova escolha
                }
                break;
            case 2:
                // Player chooses to stand
                System.out.println("Player stands.");
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
                playTurn(deck); // Chama o método novamente para permitir nova escolha
                break;
        }
    }
}

