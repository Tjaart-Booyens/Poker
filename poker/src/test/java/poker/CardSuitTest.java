package poker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for CardSuit
 */
public class CardSuitTest{

    /**
     * Create Heart
     */
    @Test
    public void shouldCreateSuitNameHeart(){
        CardSuit cs = CardSuit.HEART;
        assertEquals("Failure - CardSuit name not ♥", "♥", cs.getSuitName());
    }

    /**
     * Create Diamond
     */
    @Test
    public void shouldCreateSuitNameDiamond(){
        CardSuit cs = CardSuit.DIAMOND;
        assertEquals("Failure - CardSuit name not ♦", "♦", cs.getSuitName());
    }

    /**
     * Create Spade
     */
    @Test
    public void shouldCreateSuitNameSpade(){
        CardSuit cs = CardSuit.SPADE;
        assertEquals("Failure - CardSuit name not ♠", "♠", cs.getSuitName());
    }

    /**
     * Create Club
     */
    @Test
    public void shouldCreateSuitNameClub(){
        CardSuit cs = CardSuit.CLUB;
        assertEquals("Failure - CardSuit name not ♣", "♣", cs.getSuitName());
    }
}