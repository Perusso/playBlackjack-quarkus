package com.dev;

import com.dev.domain.Card;
import com.dev.domain.Figure;
import com.dev.domain.Hand;
import com.dev.domain.Suit;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@QuarkusTest
public class HandTest {
    @Test
    public void testAddCard() {
        Hand hand = new Hand();
        Card card = new Card(Figure.ACE, Suit.SPADES);

        hand.addCard(card);

        Assertions.assertEquals(1, hand.getCards().size());
        Assertions.assertEquals(card, hand.getCards().get(0));
    }

    @Test
    public void testClear() {
        Hand hand = new Hand();
        hand.addCard(new Card(Figure.ACE, Suit.SPADES));
        hand.addCard(new Card(Figure.KING, Suit.HEARTS));

        hand.clear();

        Assertions.assertTrue(hand.getCards().isEmpty());
    }

    @Test
    public void testGetValue() {
        Hand hand = new Hand();
        hand.addCard(new Card(Figure.KING, Suit.SPADES));
        hand.addCard(new Card(Figure.QUEEN, Suit.HEARTS));

        int value = hand.getValue();

        Assertions.assertEquals(20, value);
    }

    @Test
    public void testHasBlackjack() {
        Hand hand = new Hand();
        hand.addCard(new Card(Figure.ACE, Suit.SPADES));
        hand.addCard(new Card(Figure.KING, Suit.HEARTS));

        Assertions.assertTrue(hand.hasBlackjack());
    }

    @Test
    public void testHasBusted() {
        Hand hand = new Hand();
        hand.addCard(new Card(Figure.KING, Suit.SPADES));
        hand.addCard(new Card(Figure.QUEEN, Suit.HEARTS));
        hand.addCard(new Card(Figure.JACK, Suit.CLUBS));

        Assertions.assertTrue(hand.hasBusted());
    }

    @Test
    public void testCanSplit() {
        Hand hand = new Hand();
        hand.addCard(new Card(Figure.KING, Suit.SPADES));
        hand.addCard(new Card(Figure.KING, Suit.HEARTS));

        Assertions.assertTrue(hand.canSplit());
    }

    @Test
    public void testSplit() {
        Hand hand = new Hand();
        hand.addCard(new Card(Figure.KING, Suit.SPADES));
        hand.addCard(new Card(Figure.KING, Suit.HEARTS));

        List<Hand> splitHands = hand.split();

        Assertions.assertEquals(2, splitHands.size());
        Assertions.assertEquals(hand.getCards().get(0), splitHands.get(0).getCards().get(0));
        Assertions.assertEquals(hand.getCards().get(1), splitHands.get(1).getCards().get(0));
    }

    @Test
    public void testCannotSplit() {
        Hand hand = new Hand();
        hand.addCard(new Card(Figure.KING, Suit.SPADES));
        hand.addCard(new Card(Figure.QUEEN, Suit.HEARTS));

        Assertions.assertThrows(IllegalStateException.class, hand::split);
    }

    @Test
    public void testCanDoubleDown() {
        Hand hand = new Hand();
        hand.addCard(new Card(Figure.KING, Suit.SPADES));
        hand.addCard(new Card(Figure.QUEEN, Suit.HEARTS));

        Assertions.assertTrue(hand.canDoubleDown());
    }

    @Test
    public void testDoubleDown() {
        Hand hand = new Hand();
        hand.addCard(new Card(Figure.KING, Suit.SPADES));
        hand.addCard(new Card(Figure.QUEEN, Suit.HEARTS));

        Card newCard = new Card(Figure.JACK, Suit.CLUBS);
        hand.doubleDown(newCard);

        Assertions.assertEquals(3, hand.getCards().size());
        Assertions.assertEquals(newCard, hand.getCards().get(2));
    }

    @Test
    public void testCannotDoubleDown() {
        Hand hand = new Hand();
        hand.addCard(new Card(Figure.KING, Suit.SPADES));

        Card newCard = new Card(Figure.JACK, Suit.CLUBS);

        Assertions.assertThrows(IllegalStateException.class, () -> hand.doubleDown(newCard));
    }

    @Test
    public void testGetCards() {
        Hand hand = new Hand();
        Card card1 = new Card(Figure.ACE, Suit.SPADES);
        Card card2 = new Card(Figure.KING, Suit.HEARTS);
        hand.addCard(card1);
        hand.addCard(card2);

        List<Card> cards = hand.getCards();

        Assertions.assertEquals(2, cards.size());
        Assertions.assertEquals(card1, cards.get(0));
        Assertions.assertEquals(card2, cards.get(1));
    }
}
