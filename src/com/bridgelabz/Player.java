package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int playerId;
    private List<Card> playerCards = new ArrayList<>();

    /**
     * getter and setter methods for player object
     */
    Player(int playerId) {
        this.playerId = playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public int getPlayerId() {
        return playerId;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId == player.playerId;
    }

    public void sortCards() {
        this.getPlayerCards().sort((card1, card2) -> {
            return Integer.compare(card1.getRank(), card2.getRank());
        });
    }
}
