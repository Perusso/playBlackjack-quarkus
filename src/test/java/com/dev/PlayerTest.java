package com.dev;

import com.dev.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Mock
    Deck deck;

    @BeforeEach
    public void setup() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Figure.ACE, Suit.CLUBS));
        cards.add(new Card(Figure.KING, Suit.SPADES));
        cards.add(new Card(Figure.QUEEN, Suit.HEARTS));
        deck = new Deck(false);
        deck.addCards(cards);
    }

    @Test
    public void testGetChoice_InputValidChoice_ReturnsChoice() {
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(1);
        Player player = new Player();
        player.setScanner(scannerMock);

        int choice = player.getChoice();

        assertEquals(1, choice);
    }

    @Test
    public void testGetChoice_InputInvalidChoiceThenValidChoice_ReturnsValidChoice() {
        Hand hand = new Hand();
        Scanner scanner = new Scanner("invalid\n2\n");
        Player player = new Player(hand, scanner);

        int choice = player.getChoice();

        assertEquals(2, choice);
    }

    @Test
    public void testPlayTurn_ChoiceHit_AddsCardToHand() {
        Deck deck = new Deck(true);
        Hand hand = new Hand();
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(1);
        Player player = new Player(hand);

        player.setScanner(scannerMock);
        player.playTurn(deck);

        assertEquals(7, hand.getCards().size());
    }

    @Test
    public void testPlayTurn_ChoiceStand_DoesNotAddCardToHand() {
        Deck deck = new Deck(true);
        Hand hand = new Hand();
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(2);
        Player player = new Player(hand);
        player.setScanner(scannerMock);

        player.playTurn(deck);

        assertEquals(0, hand.getCards().size());
    }
}



