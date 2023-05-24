package com.dev.userinterface;

import com.dev.domain.Card;
import com.dev.domain.Dealer;
import com.dev.domain.Hand;
import com.dev.domain.Player;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BlackjackArts {

    public static void displayStartGameArt(){
        System.out.println("----------------------------------------------\n");
        System.out.println();
        System.out.println("----------------------------------------------\n");
        System.out.println( "\n" +
                "  ____  _            _    _            _    \n" +
                " |  _ \\| |          | |  (_)          | |   \n" +
                " | |_) | | __ _  ___| | ___  __ _  ___| | __\n" +
                " |  _ <| |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n" +
                " | |_) | | (_| | (__|   <| | (_| | (__|   < \n" +
                " |____/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n" +
                "                        _/ |                \n" +
                "                       |__/                 \n" +
                "----------------------------------------------\n" +
                "       Welcome to Blackjack! Let's play!\n" +
                "----------------------------------------------\n");

    }

    public static void displayEndGameArt() {
        System.out.println("   _____                        ");
        System.out.println("  / ____|                       ");
        System.out.println(" | |  __  __ _ _ __ ___   ___   ");
        System.out.println(" | | |_ |/ _` | '_ ` _ \\ / _ \\  | __|");
        System.out.println(" | |__| | (_| | | | | | |  __/  | |_ ");
        System.out.println("  \\_____|\\__,_|_| |_| |_|\\___|   \\__|");
        System.out.println("                                      ");
        System.out.println("--------------------------------------");
        System.out.println();
        System.out.println("Thank you for playing Blackjack! Goodbye!");
        System.out.println();
        System.out.println();
    }

    public static void displayPersonHands(Player player, Dealer dealer) {
        System.out.println("Player's hand: " + player.getHand().getCards());
        System.out.println();
        System.out.println("Dealer's hand: " + dealer.getHand().getCards().get(0) + ", {Hidden Card}");
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    public static void displayPlayerHit(Card card, Hand hand) {
        System.out.println("-------------------------------------------------");
        System.out.println("Player drew a card: " + card);
        System.out.println("Player's hand: " + hand.getCards());
        System.out.println("-------------------------------------------------");
    }

    public static void displayPlayerStand() {
        System.out.println("-------------------------------------------------");
        System.out.println("Player stands.");
        System.out.println("-------------------------------------------------");

    }

    public static void displayCompareHands(int playerHandValue, int dealerHandValue) {
        System.out.println();
        System.out.println("Player's hand value: " + playerHandValue);
        System.out.println("Dealer's hand value: " + dealerHandValue);
        System.out.println();
    }

    public static void displayPlayerChooseAction() {
        System.out.println("-------------------------------------------------");
        System.out.println("It's your turn. Choose an action (1/2):");
        System.out.println();
        System.out.println("1. Hit");
        System.out.println("2. Stand");
        System.out.println();
        System.out.println("Enter your choice: ");
    }

    public static void displayWannaPlayAgain() {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("Do you want to play again? (Y/N)");
        System.out.println();
    }

    public static void displayWinArt() {
        System.out.println("\n" +
                " __          _______ _   _ _ \n" +
                " \\ \\        / /_   _| \\ | | |\n" +
                "  \\ \\  /\\  / /  | | |  \\| | |\n" +
                "   \\ \\/  \\/ /   | | | . ` | |\n" +
                "    \\  /\\  /   _| |_| |\\  |_|\n" +
                "     \\/  \\/   |_____|_| \\_(_)\n" +
                "                             \n");
    }

    public static void displayLoseArt() {
        System.out.println("\n" +
                "  _      ____   _____ ______ _ \n" +
                " | |    / __ \\ / ____|  ____| |\n" +
                " | |   | |  | | (___ | |__  | |\n" +
                " | |   | |  | |\\___ \\|  __| | |\n" +
                " | |___| |__| |____) | |____|_|\n" +
                " |______\\____/|_____/|______(_)\n" +
                "                               \n");
    }

    public static void displayTieArt() {
        System.out.println("\n" +
                "  _______ _____ ______ _ \n" +
                " |__   __|_   _|  ____| |\n" +
                "    | |    | | | |__  | |\n" +
                "    | |    | | |  __| | |\n" +
                "    | |   _| |_| |____|_|\n" +
                "    |_|  |_____|______(_)\n" +
                "                         \n" +
                "                         \n");
    }
}
