package com.xbal.app.jackgames.database;

import java.util.*;

import com.xbal.app.jackgames.model.Player;

public class PlayerRepository {
    private final Map<UUID, Player> players;

    public PlayerRepository() {
        this.players = new HashMap<>();
    }

    public Optional<Player> findById(UUID id) {
        return Optional.ofNullable(players.get(id));
    }

    public void save(Player player) {
        players.put(player.getId(), player);
    }

    public void delete(Player player) {
        players.remove(player.getId());
    }

    public List<Player> findAll() {
        return new ArrayList<>(players.values());
    }
}
