package poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Unit test for Deck
 */
public class DeckTest{

    /**
     * Create a new Deck and get the deck
     */
    @Test
    public void shouldReturnInitialDeck(){
        ArrayList<Card> test = new ArrayList<Card>();
        for(CardSuit suit : CardSuit.values()){
            for(CardRank rank : CardRank.values()){
                Card card = new Card(rank, suit);
                test.add(card);
            }
        }
        Deck deck = new Deck();
        for(int i=0; i<deck.getCards().size(); i++){
            assertEquals("Failure - Card " + deck.getCards().get(i).toString() + " is not correct", test.get(i).toString(), deck.getCards().get(i).toString());
        }
    }

    /**
     * Set the Deck to preconfigured Cards
     */
    @Test
    public void shouldSetDeckToPreconfiguredCards(){
        ArrayList<Card> test = new ArrayList<Card>();
        test.add(new Card(CardRank.ACE, CardSuit.HEART));
        test.add(new Card(CardRank.KING, CardSuit.HEART));
        test.add(new Card(CardRank.QUEEN, CardSuit.HEART));
        test.add(new Card(CardRank.JACK, CardSuit.HEART));
        test.add(new Card(CardRank.TEN, CardSuit.HEART));
        Deck deck = new Deck();
        deck.setCards(test);
        for(int i=0; i<deck.getCards().size(); i++){
            assertEquals("Failure - Card " + deck.getCards().get(i).toString() + " is not correct", test.get(i).toString(), deck.getCards().get(i).toString());
        }
    }

    // /**
    //  * Should shuffle the Deck
    //  */
    // @Test
    // public void shouldShuffleDeck(){
    //     Deck oDeck = new Deck();
    //     Deck nDeck = new Deck();
    //     nDeck.setCards(nDeck.shuffleDeck());
    //     for(int i=0; i<oDeck.getCards().size(); i++){
    //         assertNotEquals("Failure - The Deck was not shuffled", oDeck.getCards().get(i).toString(), nDeck.getCards().get(i).toString());
    //     }
    // }

    /**
     * Should Deal a hand to a Player
     */
    @Test
    public void shouldDealAHand(){
        ArrayList<Player> players = new ArrayList<Player>();
        int handSize = 5;
        players.add(new Player("Tjaart"));
        Deck deck = new Deck();
        deck.dealHand(handSize, players);
        assertNotEquals("Failure - The number of cards are not corret after the deal", 52, deck.getCards().size());
        assertEquals("Failure - The number of cards in the player's hand are incorrect", handSize, players.get(0).getCards().size());
    }
}