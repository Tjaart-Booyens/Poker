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
 */
public abstract class HandEvaluator{

    /**
     * Abstract evaluateHand function
     */
    public abstract String evaluateHand(ArrayList<Card> cards);

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
            if(option.equals("rank")){
                i = hm.get(c.getRankName());
                hm.put(c.getRankName(), (i == null) ? 1 : i + 1);
            }
            else if(option.equals("suit")){
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
}