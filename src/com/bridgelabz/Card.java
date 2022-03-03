package com.bridgelabz;

public class Card{
    private int rank;
    private String suit;

    /**
     * @param rank 
     * @param suit
     */
    Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit.equals(card.getSuit());
    }

    @Override
    public String toString() {
        return rank + ":" + suit+"  ";
    }
}
