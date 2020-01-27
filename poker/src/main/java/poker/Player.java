package poker;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a Player in the Poker game
 */
public class Player{

    private String name = "";
    private ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * Creates a new Player with the given name
     * @param name of the new Player
     */
    Player(String name){
        this.name = name;
    }

    /**
     * Gets the name of the Player
     * @return the Player name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Sets the name of the Player
     * @param name of the Player
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Gets the cards of the Player
     * This is the Player's hand
     * @return the players Cards
     */
    public ArrayList<Card> getCards(){
        return this.cards;
    }

    /**
     * Sets the cards of the Player
     * This is the Player's hand
     * @param cards of the Player
     */
    public void setCards(ArrayList<Card> cards){
        this.cards = cards;
    }

    /**
     * Adds a single Card to the Players hand
     * @param card of the Player
     */
    public void addCard(Card card){
        this.cards.add(card);
    }

    /**
     * Sorts the Players Cards
     * This is done based on the compareTo function in Cards
     */
    public void sortCards(){
        Collections.sort(cards);
    } 

    /**
     * Clears the Player's hand of the Cards
     */
    public void clearHand(){
        cards.clear();
    }

    /**
     * Gets the Cards of the Player as a string
     * @return out string of the Players Cards 
     */
    public String toString(){
        String out = "";
        for (Card card : cards) {
            out += card.toString() + " ";
        }
        return out;
    }
}