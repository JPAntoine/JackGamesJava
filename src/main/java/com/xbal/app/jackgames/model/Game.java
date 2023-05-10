package com.xbal.app.jackgames.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.xbal.app.jackgames.exceptions.InvalidGameStateException;

public class Game {
    private UUID sessionId;
    private Deck deck;
    private List<Player> players;
    private Map<UUID, PlayerHand> playerHands;
    private Hand dealerHand;
    private GameStatus status;

    public Game(Deck deck) {
        this.sessionId = UUID.randomUUID();
        this.deck = deck;
        this.status = new GameStatus(this.sessionId);
        this.status.setWaitingForPlayers(true);
        this.playerHands = new HashMap<>(0, 0);
        this.players = new ArrayList<>();
    }

    // Getters and setters
    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public GameStatus getGameStatus() {
        return this.status;
    }

    // Player Moves
    public void playerHit() {
    }

    public void playerStand() {
    }

    public PlayerHand getPlayerHand(UUID id) {
        return playerHands.get(id);
    }

    public String getSuggestedMove() {
        return null;
    }

    // Game events
    public void addPlayerToGame(Player player) {
        this.players.add(player);
    }

    public void setPlayerHand(PlayerHand playerHand) {

    }

    public void addPlayerHand(PlayerHand playerHand) {
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void startGame() {
        deck.shuffle();
        if (this.dealerHand == null)
            this.dealerHand = new Hand();

        for (int cardsDelt = 0; cardsDelt < 2; cardsDelt++) {
            for (int entityHand = 0; entityHand <= players.size(); entityHand++) {
                Card card = deck.drawCard();
                if (entityHand == players.size()) {
                    this.dealerHand.addCard(card);
                } else {
                    Player player = this.players.get(entityHand);
                    if (cardsDelt == 1) {
                        PlayerHand playerHand = this.players.get(entityHand).getPlayerHands().get(0);
                        playerHand.addCard(card);
                    } else {
                        List<Card> handCards = new ArrayList<Card>();
                        handCards.add(card);
                        PlayerHand newPlayerHand = new PlayerHand(handCards);
                        player.addPlayerHand(newPlayerHand);
                    }
                }
            }
        }
    }

    public void stopGame() {
        if (!this.status.isGameCompleted()) {
            this.status.setGameCompleted(true);
        } else {
            throw new InvalidGameStateException("Game is already finished");
        }
    }
    
}
