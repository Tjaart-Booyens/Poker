package poker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for Card
 */
public class CardTest{

    /**
     * Create Card 2♥
     */
    @Test
    public void shouldCreateCardTwoHeart(){
        Card card = new Card(CardRank.TWO, CardSuit.HEART);
        assertEquals("Failure - Card is not 2♥", "2♥", card.getRankName() + card.getSuitName());
    }

    /**
     * Create Card A♦
     */
    @Test
    public void shouldCreateCardAceDiamond(){
        Card card = new Card(CardRank.ACE, CardSuit.DIAMOND);
        assertEquals("Failure - Card is not A♦", "A♦", card.getRankName() + card.getSuitName());
    }

    /**
     * Card toString
     */
    @Test
    public void shouldReturnTwoHeart(){
        Card card = new Card(CardRank.TWO, CardSuit.HEART);
        assertEquals("Failure - String is not 2♥", "2♥", card.toString());
    }

    /**
     * Compare the Ranks of 2♥ and A♦ and show that Ace is greater than Two
     */
    @Test
    public void shouldShowAceIsGreater(){
        Card twoHeart = new Card(CardRank.TWO, CardSuit.HEART);
        Card aceDiamond = new Card(CardRank.ACE, CardSuit.DIAMOND);

        assertEquals("Failure - Two is not greater than Ace", -1, twoHeart.compareTo(aceDiamond));
        assertEquals("Failure - Two is not greater than Ace", 1, aceDiamond.compareTo(twoHeart));
    }
}