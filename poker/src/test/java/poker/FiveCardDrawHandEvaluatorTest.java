package poker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit tests for FiveCardDrawHandEvaluator
 */
public class FiveCardDrawHandEvaluatorTest{

    HandEvaluator he = new FiveCardDrawHandEvaluator();

    /**
     * Evaluate a High Card
     */
    @Test
    public void shouldEvaluateHighCard(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.TWO, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.FIVE, CardSuit.DIAMOND));
        pl.addCard(new Card(CardRank.ACE, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.JACK, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.FOUR, CardSuit.CLUB));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> High Card", "High Card", he.evaluateHand(pl.getCards()));
    }

    /**
     * Evaluate a One Pair
     */
    @Test
    public void shouldEvaluateOnePair(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.TWO, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.FIVE, CardSuit.DIAMOND));
        pl.addCard(new Card(CardRank.ACE, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.JACK, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.FIVE, CardSuit.CLUB));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> One Pair", "One Pair", he.evaluateHand(pl.getCards()));
    }

    /**
     * Evaluate a Two Pair
     */
    @Test
    public void shouldEvaluateTwoPair(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.TWO, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.FIVE, CardSuit.DIAMOND));
        pl.addCard(new Card(CardRank.ACE, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.TWO, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.FIVE, CardSuit.CLUB));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> Two Pair", "Two Pair", he.evaluateHand(pl.getCards()));
    }

    /**
     * Evaluate a Three of a Kind
     */
    @Test
    public void shouldEvaluateThreeKind(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.TWO, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.FIVE, CardSuit.DIAMOND));
        pl.addCard(new Card(CardRank.ACE, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.TWO, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.TWO, CardSuit.HEART));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> Three of a Kind", "Three of a Kind", he.evaluateHand(pl.getCards()));
    }

    /**
     * Evaluate a Straight with A - 5
     */
    @Test
    public void shouldEvaluateStraightAceToFive(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.TWO, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.THREE, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.FOUR, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.FIVE, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.ACE, CardSuit.CLUB));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> Straight", "Straight", he.evaluateHand(pl.getCards()));
    }

    /**
     * Evaluate a Straight with 10 - A
     */
    @Test
    public void shouldEvaluateStraightTenToAce(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.TEN, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.JACK, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.KING, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.QUEEN, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.ACE, CardSuit.CLUB));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> Straight", "Straight", he.evaluateHand(pl.getCards()));
    }

    /**
     * Evaluate a Straight any other
     */
    @Test
    public void shouldEvaluateStraightAnyOther(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.SEVEN, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.EIGHT, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.NINE, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.TEN, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.JACK, CardSuit.CLUB));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> Straight", "Straight", he.evaluateHand(pl.getCards()));
    }

    /**
     * Evaluate a Flush
     */
    @Test
    public void shouldEvaluateFlush(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.TWO, CardSuit.HEART));
        pl.addCard(new Card(CardRank.FIVE, CardSuit.HEART));
        pl.addCard(new Card(CardRank.SEVEN, CardSuit.HEART));
        pl.addCard(new Card(CardRank.TEN, CardSuit.HEART));
        pl.addCard(new Card(CardRank.JACK, CardSuit.HEART));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> Flush", "Flush", he.evaluateHand(pl.getCards()));
    }

    /**
     * Evaluate a Full House
     */
    @Test
    public void shouldEvaluateFullHouse(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.TWO, CardSuit.HEART));
        pl.addCard(new Card(CardRank.TWO, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.TWO, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.TEN, CardSuit.HEART));
        pl.addCard(new Card(CardRank.TEN, CardSuit.SPADE));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> Full House", "Full House", he.evaluateHand(pl.getCards()));
    }

    /**
     * Evaluate a Four of a Kind
     */
    @Test
    public void shouldEvaluateFourKind(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.TWO, CardSuit.HEART));
        pl.addCard(new Card(CardRank.TWO, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.TWO, CardSuit.CLUB));
        pl.addCard(new Card(CardRank.TWO, CardSuit.SPADE));
        pl.addCard(new Card(CardRank.TEN, CardSuit.SPADE));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> Four of a Kind", "Four of a Kind", he.evaluateHand(pl.getCards()));
    }

    /**
     * Evaluate a Straight Flush
     */
    @Test
    public void shouldEvaluateStraightFlush(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.TWO, CardSuit.HEART));
        pl.addCard(new Card(CardRank.THREE, CardSuit.HEART));
        pl.addCard(new Card(CardRank.FOUR, CardSuit.HEART));
        pl.addCard(new Card(CardRank.FIVE, CardSuit.HEART));
        pl.addCard(new Card(CardRank.ACE, CardSuit.HEART));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> Srtraight Flush", "Straight Flush", he.evaluateHand(pl.getCards()));
    }

    /**
     * Evaluate a Royal Flush
     */
    @Test
    public void shouldEvaluateRoyalFlush(){
        Player pl = new Player("Tjaart");
        pl.addCard(new Card(CardRank.TEN, CardSuit.HEART));
        pl.addCard(new Card(CardRank.JACK, CardSuit.HEART));
        pl.addCard(new Card(CardRank.QUEEN, CardSuit.HEART));
        pl.addCard(new Card(CardRank.KING, CardSuit.HEART));
        pl.addCard(new Card(CardRank.ACE, CardSuit.HEART));
        pl.sortCards();
        assertEquals("Failure - Evaluation should be -> Royal Flush", "Royal Flush", he.evaluateHand(pl.getCards()));
    }
}