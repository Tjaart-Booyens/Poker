package poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class FiveCardDrawHandEvaluator extends HandEvaluator{

    /**
     * Gets the Evaluation of the Cards given
     * @param cards that should be evaluated
     * @return the evaluation of the Cards
     */
    @Override
    public String evaluateHand(ArrayList<Card> cards){
        String evaluation = "";

        evaluation = ranksHistogram(cards);

        if(evaluation.isEmpty()){
            evaluation = straight(cards);
        }

        if(evaluation.isEmpty()){
            evaluation = suitsHistogram(cards);
        }
        else if(evaluation.equals("Straight")){
            if(suitsHistogram(cards).equals("Flush")){
                evaluation += " Flush";
            }
        }

        if(evaluation.equals("Straight Flush") && cards.get(cards.size()-1).getRankValue() == CardRank.ACE.getRankValue() &&
            cards.get(0).getRankValue() == CardRank.TEN.getRankValue()){
            evaluation = "Royal Flush";
        }

        if(evaluation.isEmpty()){
            evaluation = "High Card";
        }

        return evaluation;
    }

    /**
     * Counts the number of CardRanks in the given Cards
     * Then determines the evaluation if any matches
     * @param cards that should be evaluated
     * @return the evaluation of the Cards
     */
    public String ranksHistogram(ArrayList<Card> cards){
        String evaluation = "";

        List<Entry<String, Integer>> list = generateList(cards, "rank");

        if(list.size() == 2){
            if(list.get(0).getValue() == 4 && list.get(1).getValue() == 1){
                evaluation = "Four of a Kind";
            }
            else if(list.get(0).getValue() == 3 && list.get(1).getValue() == 2){
                evaluation = "Full House";
            }
        }
        else if(list.size() == 3){
            if(list.get(0).getValue() == 3 && list.get(1).getValue() == 1 && list.get(2).getValue() == 1){
                evaluation = "Three of a Kind";
            }
            else if(list.get(0).getValue() == 2 && list.get(1).getValue() == 2 && list.get(2).getValue() == 1){
                evaluation = "Two Pair";
            }
        }
        else if(list.size() == 4){
            evaluation = "One Pair";
        }

        return evaluation;
    }

    /**
     * Determines if the Cards are a Straight
     * @param cards that should be evaluated
     * @return the evaluation of the Cards
     */
    public String straight(ArrayList<Card> cards){
        String evaluation = "";

        if(cards.get(cards.size()-1).getRankName().equals("A") && cards.get(cards.size()-2).getRankName().equals("5")){
            evaluation = "Straight";
        }
        else{
            int val = cards.get(cards.size()-1).getRankValue() - cards.get(0).getRankValue();
            if(val == 4){
                evaluation = "Straight";
            }
        }

        return evaluation;
    }

    /**
     * Counts the number of CardSuits in the given Cards
     * Then determines the evaluation if any matches
     * @param cards that should be evaluated
     * @return the evaluation of the Cards
     */
    public String suitsHistogram(ArrayList<Card> cards){
        String evaluation = "";

        List<Entry<String, Integer>> list = generateList(cards, "suit");

        if(list.size() == 1){
            evaluation = "Flush";
        }

        return evaluation;
    }
}