package com.xbal.app.jackgames.model;

import java.util.List;

public class GameStatus {
    private String sessionId;
    private List<PlayerHand> playerHands;
    private Hand dealerHand;
    private boolean gameOver;
    private String message;

    public GameStatus(String sessionId, List<PlayerHand> playerHands, Hand dealerHand, boolean gameOver, String message) {
        this.sessionId = sessionId;
        this.playerHands = playerHands;
        this.dealerHand = dealerHand;
        this.gameOver = gameOver;
        this.message = message;
    }

    public String getSessionId() {
        return sessionId;
    }

    public List<PlayerHand> getPlayerHands() {
        return playerHands;
    }

    public Hand getDealerHand() {
        return dealerHand;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public String getMessage() {
        return message;
    }

    // Add setters if necessary
}

