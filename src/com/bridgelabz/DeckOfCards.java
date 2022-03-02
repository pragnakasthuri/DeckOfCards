package com.bridgelabz;
/**
 * Shuffle the cards using Random method and then distribute
 * 9 Cards to 4 Players and Print the Cards received by
 * the 4 Players using 2D Array...
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {
    static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8",
            "9", "10", "Jack", "Queen", "King", "Ace"};
    List<String> cards = new ArrayList<>();
    List<List<String>> players = new ArrayList<>();

    /**
     * Iterating using for in loop to get combination of suits and ranks
     */
    DeckOfCards() {
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(rank + ":" + suit);
            }
        }
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
    }

    /**
     * Method to deal with cards and assign 9 cards to each player
     */
    public void deal() {
        boolean[] cardsUsed = new boolean[52];
        for(List<String> playerCards : players) {
            Random random = new Random();
            int cardIndex = 0;
            do {
                cardIndex = random.nextInt(52);
                if (cardsUsed[cardIndex] == false) {
                    playerCards.add(cards.get(cardIndex));
                    cardsUsed[cardIndex] = true;
                }
            }while(playerCards.size() < 9);
        }

        for(List<String> playerCards : players) {
            for(String card : playerCards) {
                System.out.print(card + (card.length() > 9 ? " " : "      "));
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.deal();
    }
}
