package com.dev;

import com.dev.application.domain.Card;
import com.dev.application.domain.enums.Figure;
import com.dev.application.domain.Hand;
import com.dev.application.domain.enums.Suit;
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
