package com.dev;

import com.dev.application.domain.Card;
import com.dev.application.domain.Deck;
import com.dev.application.domain.enums.Rank;
import com.dev.application.domain.enums.Suit;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

@QuarkusTest
public class DeckTest {

    @Inject
    Deck deck;

    @BeforeEach
    public void setUp() {
        deck.reset();
    }

    @Test
    public void testDeckCreation() {
        Assertions.assertTrue(deck.isEmpty());
    }

    @Test
    public void testAddCard() {
        Card card = new Card(Rank.ACE, Suit.SPADES);
        deck.addCard(card);

        Assertions.assertFalse(deck.isEmpty());
        Assertions.assertEquals(1, deck.getDeck().size());
        Assertions.assertEquals(card, deck.getDeck().get(0));
    }

    @Test
    public void testAddCards() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(Rank.TWO, Suit.DIAMONDS));
        cards.add(new Card(Rank.KING, Suit.HEARTS));

        deck.addCards(cards);

        Assertions.assertFalse(deck.isEmpty());
        Assertions.assertEquals(2, deck.getDeck().size());
        Assertions.assertTrue(deck.getDeck().containsAll(cards));
    }

    @Test
    public void testShuffleDeck() {
        deck.reset();

        Card card1 = new Card(Rank.ACE, Suit.CLUBS);
        Card card2 = new Card(Rank.KING, Suit.SPADES);
        Card card3 = new Card(Rank.QUEEN, Suit.HEARTS);
        Card card4 = new Card(Rank.TEN, Suit.DIAMONDS);
        Card card5 = new Card(Rank.NINE, Suit.CLUBS);
        Card card6 = new Card(Rank.EIGHT, Suit.SPADES);
        Card card7 = new Card(Rank.SEVEN, Suit.HEARTS);
        Card card8 = new Card(Rank.SIX, Suit.DIAMONDS);
        Card card9 = new Card(Rank.FIVE, Suit.CLUBS);
        Card card10 = new Card(Rank.FOUR, Suit.SPADES);
        Card card11 = new Card(Rank.THREE, Suit.HEARTS);
        Card card12 = new Card(Rank.TWO, Suit.DIAMONDS);

        deck.addCards(new ArrayList<>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12)));

        ArrayList<Card> originalDeck = new ArrayList<>(deck.getDeck());

        deck.shuffleDeck();

        Assertions.assertNotEquals(deck.getDeck(), originalDeck);
        Assertions.assertTrue(deck.getDeck().containsAll(originalDeck));
    }

    @Test
    public void testDrawCard() {
        Card card1 = new Card(Rank.TWO, Suit.SPADES);
        Card card2 = new Card(Rank.FOUR, Suit.HEARTS);
        Card card3 = new Card(Rank.SIX, Suit.DIAMONDS);

        deck.addCards(new ArrayList<>(Arrays.asList(card1, card2, card3)));

        Card drawnCard = deck.drawCard();

        Assertions.assertEquals(card1, drawnCard);
        Assertions.assertEquals(2, deck.getDeck().size());
        Assertions.assertFalse(deck.getDeck().contains(drawnCard));
    }

    @Test
    public void testIsEmpty() {
        Assertions.assertTrue(deck.isEmpty());

        deck.addCard(new Card(Rank.JACK, Suit.CLUBS));

        Assertions.assertFalse(deck.isEmpty());
    }

    @Test
    public void testReset() {
        deck.addCard(new Card(Rank.ACE, Suit.DIAMONDS));
        deck.addCard(new Card(Rank.TEN, Suit.HEARTS));

        deck.reset();

        Assertions.assertTrue(deck.isEmpty());
    }
}
