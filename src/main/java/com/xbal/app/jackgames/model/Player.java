package com.xbal.app.jackgames.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Player {
    private UUID id;
    private String username;
    private List<PlayerHand> playerHands;

    public Player(UUID id, String username, List<PlayerHand> playerHands) {
        this.id = id;
        this.username = username;
        this.playerHands = playerHands;
    }

    public Player(String username) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.playerHands = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<PlayerHand> getPlayerHands() {
        return playerHands;
    }

    public void setPlayerHands(List<PlayerHand> playerHands) {
        this.playerHands = playerHands;
    }

    public void addPlayerHand(PlayerHand playerHand) {
        this.playerHands.add(playerHand);
    }
}
