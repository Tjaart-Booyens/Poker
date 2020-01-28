package poker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;;

/**
 * Unit tests for CardRank
 */
public class CardRankTest{

    /**
     * Create Two
     */
    @Test
    public void shouldCreateRankValueTwo(){
        CardRank cr = CardRank.TWO;
        assertEquals("Failure - CardRank value not 2 bytes", (byte)2, cr.getRankValue());
    }

    @Test
    public void shouldCreateRankNameTwo(){
        CardRank cr = CardRank.TWO;
        assertEquals("Failure - CardRank name not 2", "2", cr.getRankName());
    }

    /**
     * Create Ace
     */
    @Test
    public void shouldCreateRankValueAce(){
        CardRank cr = CardRank.ACE;
        assertEquals("Failure - CardRank value not 14 bytes", (byte)14, cr.getRankValue());
    }

    @Test
    public void shouldCreateRankNameAce(){
        CardRank cr = CardRank.ACE;
        assertEquals("Failure - CardRank name not A", "A", cr.getRankName());
    }
}