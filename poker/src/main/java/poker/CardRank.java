package poker;

public enum CardRank{
    TWO((byte)2, "2"),
    THREE((byte)3, "3"),
    FOUR((byte)4, "4"),
    FIVE((byte)5, "5"),
    SIX((byte)6, "6"),
    SEVEN((byte)7, "7"),
    EIGHT((byte)8, "8"),
    NINE((byte)9, "9"),
    TEN((byte)10, "10"),
    JACK((byte)11, "J"),
    QUEEN((byte)12, "Q"),
    KING((byte)13, "K"),
    ACE((byte)14, "A");

    private final byte rankValue;
    private final String rankName;

    private CardRank(byte rankValue, String rankName){
        this.rankValue = rankValue;
        this.rankName = rankName;
    }

    protected byte getRankValue(){
        return this.rankValue;
    }

    protected String getRankName(){
        return this.rankName;
    }
}