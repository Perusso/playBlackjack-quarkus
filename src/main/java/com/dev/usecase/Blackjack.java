package com.dev.usecase;

import com.dev.domain.Dealer;
import com.dev.domain.Deck;
import com.dev.domain.Player;

import java.util.Scanner;

public class Blackjack {

    private Player player;
    private Dealer dealer;
    private Deck deck;

    public Blackjack() {
        player = new Player();
        dealer = new Dealer();
        deck = new Deck(true);
        deck.shuffleDeck();
    }

    public void startGame() {
        System.out.println("-----------------------------------");
        System.out.println("Welcome to Blackjack!");

        // Distribuir as cartas iniciais para o jogador e o dealer
        player.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());
        player.getHand().addCard(deck.drawCard());
        dealer.getHand().addCard(deck.drawCard());

        System.out.println("Player's hand: " + player.getHand().getCards());
        System.out.println("Dealer's hand: " + dealer.getHand().getCards().get(0));
        //System.out.println("Cards in Deck: " + deck.getDeck().size());

        // Verificar se algum dos participantes já possui um blackjack
        if (player.getHand().hasBlackjack()) {
            // O jogador tem um blackjack, realizar a lógica para esse caso
            System.out.println("Player has a blackjack! Player wins!");
            playAgain();
        } else if (dealer.getHand().hasBlackjack()) {
            // O dealer tem um blackjack, realizar a lógica para esse caso
            System.out.println("Dealer has a blackjack! Dealer wins!");
            playAgain();
        } else {
            // Nenhum dos participantes tem um blackjack, continuar o jogo
            player.playTurn(deck); // Jogador faz suas jogadas
            // Verificar se o jogador já estourou (valor da mão maior que 21)
            if (player.getHand().getValue() <= 21) {
                dealer.playTurn(deck); // Dealer faz suas jogadas
            }

            // Realizar a lógica de comparação das mãos e determinar o vencedor
            int playerHandValue = player.getHand().getValue();
            int dealerHandValue = dealer.getHand().getValue();

            System.out.println("Player's hand value: " + playerHandValue);
            System.out.println("Dealer's hand value: " + dealerHandValue);

            if (playerHandValue > 21) {
                System.out.println("Player busted! Dealer wins!");
            } else if (dealerHandValue > 21) {
                System.out.println("Dealer busted! Player wins!");
            } else if (playerHandValue == dealerHandValue) {
                System.out.println("It's a tie!");
            } else if (playerHandValue > dealerHandValue) {
                System.out.println("Player wins!");
            } else {
                System.out.println("Dealer wins!");
            }

            playAgain();
        }
    }

    private void playAgain() {
        System.out.println("Do you want to play again? (Y/N)");

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
            System.out.println("Thank you for playing Blackjack! Goodbye!");
        }
    }
}
