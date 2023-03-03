package com.xbal.app.jackgames.model;

public class PlayerHand {
    private String playerId;
    private Hand hand;
    private boolean isBust;
    private boolean isStand;

    public PlayerHand(String playerId) {
        this.playerId = playerId;
        this.hand = new Hand();
        this.isBust = false;
        this.isStand = false;
    }

    public String getPlayerId() {
        return playerId;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isBust() {
        return isBust;
    }

    public void setBust(boolean bust) {
        isBust = bust;
    }

    public boolean isStand() {
        return isStand;
    }

    public void setStand(boolean stand) {
        isStand = stand;
    }

    // Add setters if necessary
}