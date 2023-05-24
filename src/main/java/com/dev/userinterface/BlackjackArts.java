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
        System.out.println("-------------------------------------------------");
        System.out.println( "\n" +
                "  ____  _            _    _            _    \n" +
                " |  _ \\| |          | |  (_)          | |   \n" +
                " | |_) | | __ _  ___| | ___  __ _  ___| | __\n" +
                " |  _ <| |/ _` |/ __| |/ / |/ _` |/ __| |/ /\n" +
                " | |_) | | (_| | (__|   <| | (_| | (__|   < \n" +
                " |____/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\n" +
                "                        _/ |                \n" +
                "                       |__/                 \n" +
                "-------------------------------------------------\n" +
                "              Welcome to Blackjack!\n" +
                "-------------------------------------------------");

    }

    public static void displayNewGame() {
        System.out.println();
        System.out.println("-------------------------------------------------");
        System.out.println("            Starting a new game...");
        System.out.println();

    }
    public static void displayPersonHands(Player player, Dealer dealer) {
        System.out.println("Player's hand: " + player.getHand().getCards() + " (" + player.getHand().getValue() + ")");
        System.out.println();
        System.out.println("Dealer's hand: " + dealer.getHand().getCards().get(0) + ", {Hidden Card}");
        System.out.println("-------------------------------------------------");
        System.out.println();
    }

    public static void displayMainMenu() {
        System.out.println("Welcome to Blackjack!");
        System.out.println("Please choose an option:");
        System.out.println("1. Start playing");
        System.out.println("2. View game rules");
        System.out.println("3. Exit");
    }

    public static void displayGameRules() {
        System.out.println("\n" +
                "   _____          __  __ ______   _____  _    _ _      ______  _____ \n" +
                "  / ____|   /\\   |  \\/  |  ____| |  __ \\| |  | | |    |  ____|/ ____|\n" +
                " | |  __   /  \\  | \\  / | |__    | |__) | |  | | |    | |__  | (___  \n" +
                " | | |_ | / /\\ \\ | |\\/| |  __|   |  _  /| |  | | |    |  __|  \\___ \\ \n" +
                " | |__| |/ ____ \\| |  | | |____  | | \\ \\| |__| | |____| |____ ____) |\n" +
                "  \\_____/_/    \\_\\_|  |_|______| |_|  \\_\\\\____/|______|______|_____/ \n" +
                "                                                                     \n" +
                "                                                                     \n" +
                "---------------------------------------------------------------------\n" );
        System.out.println();
        System.out.println("Welcome to Blackjack!");
        System.out.println();
        System.out.println("The objective of blackjack is to beat the dealer by getting as close as possible to 21 without going over.");
        System.out.println("The dealer also receives two cards: one face-up and one face-down.");
        System.out.println("Players then choose to 'Hit' or 'Stand' their hands.");
        System.out.println("After all players have taken their turn, the dealer reveals their cards.");
        System.out.println("The winners are any players with a total greater than the dealer's or with cards that add up to exactly 21!");

    }

    public static void displayExitMessage() {
        System.out.println("\n" +
                "   _____  ____   ____  _____    ______     ________   _ \n" +
                "  / ____|/ __ \\ / __ \\|  __ \\  |  _ \\ \\   / /  ____| | |\n" +
                " | |  __| |  | | |  | | |  | | | |_) \\ \\_/ /| |__    | |\n" +
                " | | |_ | |  | | |  | | |  | | |  _ < \\   / |  __|   | |\n" +
                " | |__| | |__| | |__| | |__| | | |_) | | |  | |____  |_|\n" +
                "  \\_____|\\____/ \\____/|_____/  |____/  |_|  |______| (_)\n" +
                "                                                        \n" +
                "                                                        \n");
        System.out.println("-------------------------------------------------");
        System.out.println();
        System.out.println("Thank you for playing Blackjack! Goodbye!");
        System.out.println();
        System.out.println();
    }

    public static void displayPlayerHit(Card card, Hand hand) {
        System.out.println("-------------------------------------------------");
        System.out.println("Player drew a card: " + card + "\n");
        System.out.println("Player's hand: " + hand.getCards() + " (" + hand.getValue() + ")");
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
                " __          _______ _   _   _ \n" +
                " \\ \\        / /_   _| \\ | | | |\n" +
                "  \\ \\  /\\  / /  | | |  \\| | | |\n" +
                "   \\ \\/  \\/ /   | | | . ` | | |\n" +
                "    \\  /\\  /   _| |_| |\\  | |_|\n" +
                "     \\/  \\/   |_____|_| \\_| (_)\n" +
                "                               \n");
    }

    public static void displayLoseArt() {
        System.out.println("\n" +
                "  _      ____   _____ ______   _ \n" +
                " | |    / __ \\ / ____|  ____| | |\n" +
                " | |   | |  | | (___ | |__    | |\n" +
                " | |   | |  | |\\___ \\|  __|   | |\n" +
                " | |___| |__| |____) | |____  |_|\n" +
                " |______\\____/|_____/|______| (_)\n" +
                "                                 \n");
    }

    public static void displayTieArt() {
        System.out.println("\n" +
                "  _______ _____ ______   _ \n" +
                " |__   __|_   _|  ____| | |\n" +
                "    | |    | | | |__    | |\n" +
                "    | |    | | |  __|   | |\n" +
                "    | |   _| |_| |____  |_|\n" +
                "    |_|  |_____|______| (_)\n" +
                "                           \n" +
                "                           \n");
    }
}
