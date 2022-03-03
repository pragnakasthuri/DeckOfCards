package com.bridgelabz;
/**
 * Shuffle the cards using Random method and then distribute
 * 9 Cards to 4 Players and Print the Cards received by
 * the 4 Players using 2D Array...
 */

import java.util.*;

public class DeckOfCards {
    static String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
    List<Card> cards = new ArrayList<>();
    List<Player> players = new LinkedList<>();

    /**
     * Iterating using for in loop to get combination of suits and ranks
     */
    DeckOfCards() {
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(Integer.parseInt(rank), suit));
            }
        }
    }

    /**
     * Method to deal with cards and assign 9 cards to each player
     */
    public void deal() {
        boolean[] cardsUsed = new boolean[suits.length * ranks.length];
        for(Player player : this.players) {
            Random random = new Random();
            int cardIndex = 0;
            do {
                cardIndex = random.nextInt(cardsUsed.length);
                if (cardsUsed[cardIndex] == false) {
                    player.getPlayerCards().add(this.cards.get(cardIndex));
                    cardsUsed[cardIndex] = true;
                }
            }while(player.getPlayerCards().size() < 9);
        }
    }

    /**
     * Display the cards received by players
     */
    private void showCards() {
        for(Player player : this.players) {
            player.sortCards();
            for(Card card : player.getPlayerCards()) {
                System.out.print(card);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.players.add(new Player(1));
        deck.players.add(new Player(2));
        deck.players.add(new Player(3));
        deck.players.add(new Player(4));

        deck.deal();
        deck.showCards();
    }
}
