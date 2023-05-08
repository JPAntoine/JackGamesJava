package com.xbal.app.jackgames.model;

import java.util.UUID;

public class GameStatus {
    private UUID sessionId;
    private boolean isGameCompleted;
    private boolean isDealerTurn;
    private boolean isHandStand;
    private boolean isDealerBust;
    private boolean isPlayerBust;
    private boolean isPush;
    private boolean isPlayerWinner;
    private boolean isWaitingForPlayers;

    public GameStatus(UUID sessionId) {
        this.sessionId = sessionId;
        isGameCompleted = false;
        isDealerTurn = false;
        isHandStand = false;
        isDealerBust = false;
        isPlayerBust = false;
        isPush = false;
        isPlayerWinner = false;
        isWaitingForPlayers = true;
    }

    // Getters and setters

    public UUID getSessionId() {
        return sessionId;
    }

    public boolean isGameCompleted() {
        return isGameCompleted;
    }

    public void setGameCompleted(boolean gameCompleted) {
        isGameCompleted = gameCompleted;
    }

    public boolean isDealerTurn() {
        return isDealerTurn;
    }

    public void setDealerTurn(boolean dealerTurn) {
        isDealerTurn = dealerTurn;
    }

    public boolean isHandStand() {
        return isHandStand;
    }

    public void setHandStand(boolean handStand) {
        isHandStand = handStand;
    }

    public boolean isDealerBust() {
        return isDealerBust;
    }

    public void setDealerBust(boolean dealerBust) {
        isDealerBust = dealerBust;
    }

    public boolean isPlayerBust() {
        return isPlayerBust;
    }

    public void setPlayerBust(boolean playerBust) {
        isPlayerBust = playerBust;
    }

    public boolean isPush() {
        return isPush;
    }

    public void setPush(boolean push) {
        isPush = push;
    }

    public boolean isPlayerWinner() {
        return isPlayerWinner;
    }

    public void setPlayerWinner(boolean playerWinner) {
        isPlayerWinner = playerWinner;
    }

    public boolean isWaitingForPlayers() {
        return isWaitingForPlayers;
    }

    public void setWaitingForPlayers(boolean waitingForPlayers) {
        isWaitingForPlayers = waitingForPlayers;
    }
}
