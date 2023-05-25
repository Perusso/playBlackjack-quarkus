package com.dev;

import com.dev.application.domain.*;
import com.dev.application.domain.enums.Figure;
import com.dev.application.domain.enums.Suit;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class DealerTest {

    @Inject
    Dealer dealer;
    @Mock
    Deck deck;

    @BeforeEach
    public void setup() {
        dealer = new Dealer();
        deck = Mockito.mock(Deck.class);
    }

    @Test
    public void testPlayTurn_DealerStopsAtDealerMinValue() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Figure.KING, Suit.HEARTS));
        cards.add(new Card(Figure.SIX, Suit.CLUBS));

        when(deck.drawCard()).thenReturn(cards.get(0), cards.get(1), null);

        dealer.playTurn(deck);

        verify(deck, times(3)).drawCard();

        assertEquals(cards.subList(0, 2), dealer.getHand().getCards());
    }

    @Test
    public void testPlayTurn_DealerContinuesDrawingUntilMinValue() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Figure.TWO, Suit.DIAMONDS));
        cards.add(new Card(Figure.FOUR, Suit.SPADES));
        cards.add(new Card(Figure.THREE, Suit.HEARTS));

        when(deck.drawCard()).thenReturn(cards.get(0), cards.get(1), cards.get(2), null);

        dealer.playTurn(deck);

        verify(deck, times(4)).drawCard();

        assertEquals(cards.subList(0, 3), dealer.getHand().getCards());
    }
}

