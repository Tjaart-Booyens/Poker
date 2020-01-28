package poker;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit tests for Player
 */
public class PlayerTest{

    /**
     * Create a Player and get the name
     */
    @Test
    public void shouldCreatePlayerAndGetName(){
        Player pl = new Player("Tjaart");
        assertEquals("Failure - Name does not match", "Tjaart", pl.getName());
    }

    /**
     * Set the cards of the Player and get the cards of the Player
     */
    @Test
    public void shouldSetCardsAndGetCards(){
        Player pl = new Player("Tjaart");
        ArrayList<Card> test = new ArrayList<Card>();
        test.add(new Card(CardRank.ACE, CardSuit.HEART));
        test.add(new Card(CardRank.KING, CardSuit.HEART));
        test.add(new Card(CardRank.QUEEN, CardSuit.HEART));
        test.add(new Card(CardRank.JACK, CardSuit.HEART));
        test.add(new Card(CardRank.TEN, CardSuit.HEART));
        pl.setCards(test);
        assertEquals("Failure - The cards do not match the Players hand", test, pl.getCards());
    }

    /**
     * Add cards one by one to the Player hand
     */
    @Test
    public void shouldAddCardOneByOne(){
        Player pl = new Player("Tjaart");
        ArrayList<Card> test = new ArrayList<Card>();
        test.add(new Card(CardRank.ACE, CardSuit.HEART));
        test.add(new Card(CardRank.KING, CardSuit.HEART));
        test.add(new Card(CardRank.QUEEN, CardSuit.HEART));
        test.add(new Card(CardRank.JACK, CardSuit.HEART));
        test.add(new Card(CardRank.TEN, CardSuit.HEART));
        for(Card c : test){
            pl.addCard(c);
        }
        assertEquals("Failure - The cards do not match the Players hand", test, pl.getCards());
    }

    /**
     * Sort the Cards in the Player hand
     */
    @Test
    public void shouldSortCardsInHand(){
        Player pl = new Player("Tjaart");
        ArrayList<Card> test = new ArrayList<Card>();
        test.add(new Card(CardRank.ACE, CardSuit.HEART));
        test.add(new Card(CardRank.KING, CardSuit.HEART));
        test.add(new Card(CardRank.QUEEN, CardSuit.HEART));
        test.add(new Card(CardRank.JACK, CardSuit.HEART));
        test.add(new Card(CardRank.TEN, CardSuit.HEART));
        pl.setCards(test);
        pl.sortCards();
        assertEquals("Failure - The last and first Card's difference are not 4", 4, pl.getCards().get(4).getRankValue() - pl.getCards().get(0).getRankValue());
    }

    /**
     * Clear the Players hand
     */
    @Test
    public void shouldClearPlayerHand(){
        Player pl = new Player("Tjaart");
        ArrayList<Card> test = new ArrayList<Card>();
        test.add(new Card(CardRank.ACE, CardSuit.HEART));
        test.add(new Card(CardRank.KING, CardSuit.HEART));
        test.add(new Card(CardRank.QUEEN, CardSuit.HEART));
        test.add(new Card(CardRank.JACK, CardSuit.HEART));
        test.add(new Card(CardRank.TEN, CardSuit.HEART));
        pl.setCards(test);
        pl.clearHand();
        assertEquals("Failure - The Player hand is not empty", 0, pl.getCards().size());
    }

    /**
     * Show the Player
     */
    @Test
    public void shouldShowCards(){
        Player pl = new Player("Tjaart");
        ArrayList<Card> test = new ArrayList<Card>();
        test.add(new Card(CardRank.ACE, CardSuit.HEART));
        test.add(new Card(CardRank.KING, CardSuit.HEART));
        test.add(new Card(CardRank.QUEEN, CardSuit.HEART));
        test.add(new Card(CardRank.JACK, CardSuit.HEART));
        test.add(new Card(CardRank.TEN, CardSuit.HEART));
        pl.setCards(test);
        assertEquals("Failure - The player is not shown correct", "A♥ K♥ Q♥ J♥ 10♥ ", pl.toString());
    }
}