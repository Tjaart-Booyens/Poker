package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

/**
 * Determines the hand of a Player based on his Cards
 * NOTE: This class is only tested with 5 Draw Poker 
 * (It will not work if more than 5 cards are presented)
 * TODO determine winner of Poker game
 */
public class HandEvaluater{

    /**
     * Gets the Evaluation of the Cards given
     * @param cards that should be evaluated
     * @return the evaluation of the Cards
     */
    public String evaluateHand(ArrayList<Card> cards){
        String evaluation = "";

        evaluation = ranksHistogram(cards);

        if(evaluation == ""){
            evaluation = straight(cards);
        }

        if(evaluation == ""){
            evaluation = suitsHistogram(cards);
        }
        else if(evaluation == "Straight"){
            evaluation += " " + suitsHistogram(cards);
        }

        if(evaluation == "Straight Flush" && cards.get(cards.size()-1).getRankName() == "A"){
            evaluation = "Royal Flush";
        }

        if(evaluation == ""){
            evaluation = "High Card" /*" + cards.get(cards.size()-1).getRankName()*/;
        }

        return evaluation;
    }

    /**
     * Generates a map of the cards on either the CardRank or the CardSuit
     * It then converts it to an ordered list
     * @param cards that should be ordered
     * @param option that should be used in the mapping process
     * @return the ordered list
     */
    public List<Entry<String, Integer>> generateList(ArrayList<Card> cards, String option){
        Map<String, Integer> hm = new HashMap<String, Integer>();

        for(Card c : cards) {
            Integer i = 0;
            if(option == "rank"){
                i = hm.get(c.getRankName());
                hm.put(c.getRankName(), (i == null) ? 1 : i + 1);
            }
            else if(option == "suit"){
                i = hm.get(c.getSuitName());
                hm.put(c.getSuitName(), (i == null) ? 1 : i + 1);
            }
        }

        Set<Entry<String, Integer>> set = hm.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return list;
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

        if(cards.get(cards.size()-1).getRankName() == "A" && cards.get(cards.size()-2).getRankName() == "5"){
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