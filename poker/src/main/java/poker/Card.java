package poker;

/**
 * Represents a Card that is apart of a Deck
 */
public class Card implements Comparable<Card>{

    private CardSuit suit;
    private CardRank rank;

    /**
     * Creates a card with the given CardRank and CardSuit
     * @param rank This is the card's rank and determines the ordering of a list of cards
     * @param suit This is the suit of a card
     */
    public Card(CardRank rank, CardSuit suit){
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Gets the icon of the suit
     * @return this Card's suit name
     */
    public String getSuitName(){
        return this.suit.getSuitName();
    }

    /**
     * Gets the rank name of the card
     * @return this Card's rank name
     */
    public String getRankName(){
        return this.rank.getRankName();
    }

    /**
     * Gets the rank value of the card
     * @return this Card's rank value
     */
    public byte getRankValue(){
        return this.rank.getRankValue();
    }

    /**
     * Gets the rank name and the suit name of the Card
     * @return this Card's rank and suit name
     */
    public String toString(){
        return this.rank.getRankName() + this.suit.getSuitName();
    }

    /**
     * Overrides the compareTo function of the Comparable interface
     * Enables Card's to be compared by their rank values
     */
    @Override
    public int compareTo(Card c){
        if (getRankValue() < c.getRankValue()) {
            return -1;
        }
        else if (c.getRankValue() < getRankValue()) {
            return 1;
        }
        return 0;
    }
}