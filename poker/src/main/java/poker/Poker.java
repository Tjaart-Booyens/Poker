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
    private static HandEvaluater handEvaluater;
    private static Integer handSize;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        players = new ArrayList<Player>();
        deck = new Deck();
        handEvaluater = new HandEvaluater();
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
                    case 4: playRound();
                        break;
                    case 5: startOver();
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

    public static void displayPlayers(){
        if(players.size() > 0){
            System.out.println("The players are:");
            for(Player player : players){
                System.out.printf("%-15s %-15s \n", player.getName(),  " - Number Cards " + Integer.toString(player.getCards().size()));
            }
            System.out.println();
        }
    }

    public static void displayMenu(){
        System.out.println("==============================");
        System.out.println("1. Add a player");
        System.out.println("2. Show Deck");
        System.out.println("3. Shuffle Deck");
        System.out.println("4. Play Round");
        System.out.println("5. Start Over");
        System.out.println("9. Quit");
        System.out.println("==============================");
    }

    public static void addPlayer(){
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        players.add(new Player(name));
        System.out.println();
    }

    public static void showDeck(){
        System.out.println("==============================");
        deck.showDeck();
        System.out.println("==============================");
    }

    public static void shuffleDeck(){
        System.out.println("Shuffling the deck now.");
        deck.setCards(deck.shuffleDeck());
        System.out.println();
    }

    public static void dealHands(){
        // System.out.print("Select the amount of cards per hand: ");
        // Integer handSize = Integer.parseInt(scanner.nextLine());
        // System.out.println();
        System.out.println("Dealing the hands now.");
        deck.dealHand(handSize, players);
        System.out.println();
    }

    public static void evaluateHands(){
        for(Player player : players){
            System.out.println("==============================");
            player.sortCards();
            System.out.printf("%-25s %-14s \n", "Player " + player.getName() + "'s hand:", player.toString());
            System.out.printf("%-25s %-14s \n", "Player " + player.getName() + " have:", handEvaluater.evaluateHand(player.getCards()));
        }
        System.out.println("==============================");
        System.out.println();
    }

    public static void clearHands(){
        for(Player player : players){
            player.clearHand();
        }
    }

    public static void playRound(){
        if(!players.isEmpty()){
            clearHands();
            if(handSize * players.size() <= deck.getCards().size()){
                dealHands();
                evaluateHands();
            }
            else{
                System.out.println("Not enough cards to deal.");
            }
        }
        else{
            System.out.println("Please add some players for the game.");
        }
    }

    public static void startOver(){
        deck = new Deck();
        clearHands();
    }
}