package com.dev;

import com.dev.application.domain.Card;
import com.dev.application.domain.enums.Rank;
import com.dev.application.domain.enums.Suit;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class CardTest {

    @Test
    public void testGetFigureValue() {
        Card card = new Card(Rank.KING, Suit.DIAMONDS);

        int expectedValue = 10;
        int actualValue = card.getFigureValue();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testToString() {
        Card card = new Card(Rank.KING, Suit.HEARTS);

        String expectedString = "King of Hearts";
        String actualString = card.toString();

        assertEquals(expectedString, actualString);
    }

}
