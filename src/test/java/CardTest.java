import com.dev.domain.Card;
import com.dev.domain.Figure;
import com.dev.domain.Suit;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class CardTest {


    @Test
    public void testGetFigureValue() {
        Card card = new Card(Figure.KING, Suit.DIAMOND);

        int expectedValue = 10;
        int actualValue = card.getFigureValue();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testToString() {
        Card card = new Card(Figure.KING, Suit.HEART);

        String expectedString = "Card{King of Hearts}";
        String actualString = card.toString();

        assertEquals(expectedString, actualString);
    }

}
