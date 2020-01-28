package poker;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simulates the Poker game
 */
public class Poker{

    private static Scanner scanner;
    private static ArrayList<Player> players;
    private static Deck deck;
    private static HandEvaluator handEvaluator;
    private static Integer handSize;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        players = new ArrayList<Player>();
        deck = new Deck();
        handEvaluator = new FiveCardDrawHandEvaluator();
        handSize = 5;

        System.out.println("==============================");
        System.out.println("Welcome to 5-card draw Poker..");
        System.out.println("==============================");

        boolean cont = true;
        while(cont){
            displayPlayers();
            displayMenu();
            try{
                Integer input = Integer.parseInt(scanner.nextLine());
                switch(input){
                    case 1: addPlayer();
                        break;
                    case 2: showDeck();
                        break;
                    case 3: shuffleDeck();
                        break;
                    case 4: playHand();
                        break;
                    case 5: newDeck();
                        break;
                    case 6: runStats();
                        break;
                    case 9: cont = false;
                        System.out.println("==============================");
                        System.out.println("Goodbye.");
                        System.out.println("==============================");
                        break;
                    default: System.out.print("Please enter a number from the menu.\n");
                }
            }
            catch (NumberFormatException ex) {
                System.out.print("Please enter a valid number from the menu.\n");
            }
        }
        scanner.close();
    }

    /**
     * Display all the current Players
     */
    public static void displayPlayers(){
        if(players.size() > 0){
            System.out.println("The players are:");
            for(Player player : players){
                System.out.printf("%-15s %-15s \n", player.getName(),  " - Number Cards " + Integer.toString(player.getCards().size()));
            }
            System.out.println();
        }
    }

    /**
     * Display the menu of options
     */
    public static void displayMenu(){
        System.out.println("==============================");
        System.out.println("1. Add a player");
        System.out.println("2. Show Deck");
        System.out.println("3. Shuffle Deck");
        System.out.println("4. Play Hand");
        System.out.println("5. New Deck");
        System.out.println("6. Run Stats");
        System.out.println("9. Quit");
        System.out.println("==============================");
    }

    /**
     * Add a Player toe the current game
     */
    public static void addPlayer(){
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        players.add(new Player(name));
        System.out.println();
    }

    /**
     * Show the current Deck
     */
    public static void showDeck(){
        System.out.println("==============================");
        deck.showDeck();
        System.out.println("==============================");
    }

    /**
     * Shuffle the current Deck
     */
    public static void shuffleDeck(){
        System.out.println("Shuffling the deck now.");
        deck.setCards(deck.shuffleDeck());
        System.out.println();
    }

    /**
     * Play a hand
     */
    public static void playHand(){
        if(!players.isEmpty()){
            clearHands();
            if(handSize * players.size() <= deck.getCards().size()){
                dealHands();
                evaluateHands();
                System.out.println("Cards left: " + deck.getCards().size());
            }
            else{
                System.out.println("Not enough cards to deal.\n");
            }
        }
        else{
            System.out.println("Please add some players for the game.\n");
        }
    }

    /**
     * Deal hands to the Players in the game
     */
    public static void dealHands(){
        System.out.println("Dealing the hands now.");
        deck.dealHand(handSize, players);
        System.out.println();
    }

    /**
     * Evaluate the Players hands
     */
    public static void evaluateHands(){
        for(Player player : players){
            System.out.println("==============================");
            player.sortCards();
            System.out.printf("%-25s %-14s \n", "Player " + player.getName() + "'s hand:", player.toString());
            System.out.printf("%-25s %-14s \n", "Player " + player.getName() + " have:", handEvaluator.evaluateHand(player.getCards()));
        }
        System.out.println("==============================\n");
    }

    /**
     * Clear the Players hand
     */
    public static void clearHands(){
        for(Player player : players){
            player.clearHand();
        }
    }

    /**
     * Create a new Deck and start over
     */
    public static void newDeck(){
        deck = new Deck();
        clearHands();
    } 

    /**
     * Some interesting stats
     */
    public static void runStats(){
        ArrayList<Player> statPlayers = new ArrayList<>();
        Deck statDeck = new Deck();
        HandEvaluator statHe = new FiveCardDrawHandEvaluator();

        statPlayers.add(new Player("Tjaart"));
        Integer[] evaluations = new Integer[10];
        for(int i=0; i<evaluations.length; i++){
            evaluations[i] = 0;
        }

        for(int i=0; i<650000; i++){
            statDeck.setCards(statDeck.shuffleDeck());
            statDeck.dealHand(5, statPlayers);
            statPlayers.get(0).sortCards();

            switch(statHe.evaluateHand(statPlayers.get(0).getCards())){
                case "High Card": evaluations[0]++;
                    break;
                case "One Pair": evaluations[1]++;
                    break;
                case "Two Pair": evaluations[2]++;
                    break;
                case "Three of a Kind": evaluations[3]++;
                    break;
                case "Straight": evaluations[4]++;
                    break;
                case "Flush": evaluations[5]++;
                    break;
                case "Full House": evaluations[6]++;
                    break;
                case "Four of a Kind": evaluations[7]++;
                    break;
                case "Straight Flush": evaluations[8]++;
                    break;
                case "Royal Flush": evaluations[9]++;
                break;
            }

            statDeck = new Deck();
            statPlayers.get(0).clearHand();
        }

        System.out.println("High Card: " + evaluations[0]);
        System.out.println("One Pair: " + evaluations[1]);
        System.out.println("Two Pair: " + evaluations[2]);
        System.out.println("Three of a Kind: " + evaluations[3]);
        System.out.println("Straight: " + evaluations[4]);
        System.out.println("Flush: " + evaluations[5]);
        System.out.println("Full House: " + evaluations[6]);
        System.out.println("Four of a Kind: " + evaluations[7]);
        System.out.println("Straight Flush: " + evaluations[8]);
        System.out.println("Royal Flush: " + evaluations[9]);
    }
}