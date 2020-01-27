package poker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a Deck of Cards
 */
public class Deck{

    private ArrayList<Card> deck = new ArrayList<>();;

    /**
     * Initialize a new Deck of Cards in order
     */
    public Deck(){
        for(CardSuit suit : CardSuit.values()){
            for(CardRank rank : CardRank.values()){
                Card card = new Card(rank, suit);
                this.deck.add(card);
            }
        }
    }

    /**
     * Gets the Deck of Cards
     * @return the Deck of Cards
     */
    public ArrayList<Card> getCards(){
        return this.deck;
    }

    /**
     * Sets the deck to the list of Cards given
     * To easily add a preconfigured deck or shuffle the deck and set as the new deck
     */
    public void setCards(ArrayList<Card> deck){
        this.deck = deck;
    }

    /**
     * Shows the current deck of cards
     */
    public void showDeck(){
        int count = 0;
        for(Card card : deck){
            if(count == 13){
                System.out.print("\n");
                count = 0;
            }
            System.out.print(card.toString() + " ");
            count++;
        }
        System.out.println();
    }

    /**
     * Shuffles the current Deck of Cards
     * @return the shuffled Deck
     */
    public ArrayList<Card> shuffleDeck(){
        Random random = new Random();

        ArrayList<Card> shuffledDeck = new ArrayList<Card>();
        while(deck.size() > 0){
            shuffledDeck.add(deck.remove(random.nextInt(deck.size())));
        }

        return shuffledDeck;
    }

    /**
     * Deal a hand with the specified size from the current Deck
     * If more than one player cards are dealt to each person one by one
     */
    public void dealHand(int handSize, ArrayList<Player> players){
        
            for(int i=0; i<handSize; i++){
                for(Player player : players){
                    if(player.getCards().size() != 5)
                        player.addCard(deck.remove(0));
                }
            }
        
    }
}