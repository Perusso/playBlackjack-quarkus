package com.dev;

import com.dev.application.domain.Card;
import com.dev.application.domain.Dealer;
import com.dev.application.domain.Deck;
import com.dev.application.domain.Player;
import com.dev.application.domain.enums.Choice;
import com.dev.application.domain.enums.Figure;
import com.dev.application.domain.enums.Suit;
import com.dev.application.resource.ThreadUtils;
import com.dev.application.usecase.Blackjack;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@QuarkusTest
public class BlackjackTest {

    @Mock
    Deck deck;


    @BeforeEach
    public void setup() throws InterruptedException {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Figure.ACE, Suit.CLUBS));
        cards.add(new Card(Figure.KING, Suit.SPADES));
        cards.add(new Card(Figure.QUEEN, Suit.HEARTS));
        deck = new Deck(false);
        deck.addCards(cards);
    }

    @Test
    public void testStartGame_PlayerChoosesToStand_DealerPlaysTurn_GameIsExited() {
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(2);
        when(scannerMock.nextLine()).thenReturn("N");

        Player player = new Player();
        player.setScanner(scannerMock);
        Dealer dealer = new Dealer();
        Blackjack blackjack = new Blackjack(deck, player, dealer, 0, 0, 0);
        blackjack.setScanner(scannerMock);

        blackjack.startGame(true);

        assertEquals(2, player.getHand().getCards().size());
    }

    @Test
    public void testStartGame_PlayerHasBlackjack_PlayerWins() {
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(1);
        when(scannerMock.nextLine()).thenReturn("N");

        Player player = new Player();
        player.setScanner(scannerMock);

        Dealer dealer = new Dealer();

        Deck deck = new Deck(false);
        deck.addCard(new Card(Figure.ACE, Suit.CLUBS));
        deck.addCard(new Card(Figure.KING, Suit.SPADES));
        deck.addCard(new Card(Figure.TEN, Suit.HEARTS));
        deck.addCard(new Card(Figure.NINE, Suit.SPADES));
        deck.addCard(new Card(Figure.EIGHT, Suit.SPADES));
        deck.addCard(new Card(Figure.SEVEN, Suit.SPADES));

        Blackjack blackjack = new Blackjack(deck, player, dealer, 0, 0, 0);
        blackjack.setScanner(scannerMock);

        blackjack.startGame(true);

        System.out.println(player.getHand().getCards());
        System.out.println(dealer.getHand().getCards());

        assertEquals(2, player.getHand().getCards().size());
        assertEquals(2, dealer.getHand().getCards().size());
        assertEquals(1, blackjack.getWins());
    }

    @Test
    public void testStartGame_DealerHasBlackjack_DealerWins() {
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(1);
        when(scannerMock.nextLine()).thenReturn("N");

        Player player = new Player();
        player.setScanner(scannerMock);
        Dealer dealer = new Dealer();
        Deck deck = new Deck(false);
        deck.addCard(new Card(Figure.NINE, Suit.SPADES));
        deck.addCard(new Card(Figure.EIGHT, Suit.SPADES));
        deck.addCard(new Card(Figure.SEVEN, Suit.SPADES));
        deck.addCard(new Card(Figure.ACE, Suit.CLUBS));
        deck.addCard(new Card(Figure.KING, Suit.SPADES));
        deck.addCard(new Card(Figure.TEN, Suit.HEARTS));

        Blackjack blackjack = new Blackjack(deck, player, dealer, 0, 0, 0);
        blackjack.setScanner(scannerMock);

        blackjack.startGame(false);

        assertEquals(3, player.getHand().getCards().size());
        assertEquals(2, dealer.getHand().getCards().size());
        assertEquals(1, blackjack.getLosses());
    }

    @Test
    public void testStartGame_PlayerBusts_DealerWins() {
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(1);
        when(scannerMock.nextLine()).thenReturn("N");

        Player player = new Player();
        player.setScanner(scannerMock);
        Dealer dealer = new Dealer();
        Deck deck = new Deck(false);
        deck.addCard(new Card(Figure.KING, Suit.CLUBS));
        deck.addCard(new Card(Figure.KING, Suit.SPADES));
        deck.addCard(new Card(Figure.KING, Suit.HEARTS));
        deck.addCard(new Card(Figure.NINE, Suit.SPADES));
        deck.addCard(new Card(Figure.EIGHT, Suit.SPADES));
        deck.addCard(new Card(Figure.SEVEN, Suit.SPADES));
        Blackjack blackjack = new Blackjack(deck, player, dealer, 0, 0, 0);
        blackjack.setScanner(scannerMock);

        blackjack.startGame(true);

        assertTrue(player.getHand().getValue() > 21);
        assertEquals(2, dealer.getHand().getCards().size());
        assertEquals(1, blackjack.getLosses());
    }
}
