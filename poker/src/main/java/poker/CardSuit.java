package poker;

public enum CardSuit{
    HEART("♥"), 
    DIAMOND("♦"), 
    SPADE("♠"), 
    CLUB("♣");

    private final String suitName;

    private CardSuit(String suitName){
        this.suitName = suitName;
    }
    
    protected String getSuitName(){
        return this.suitName;
    }
}