package com.xbal.app.jackgames.database;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.xbal.app.jackgames.model.Game;

@Repository
public class GameRepository {
    private Map<UUID, Game> games = new HashMap<>(0, 0);

    public Optional<Game> getGameById(UUID id) {
        return Optional.ofNullable(games.get(id));
    }

    public Map<UUID, Game> getAllGames() {
        return games;
    }

    public void save(Game game) {
        if (game.getSessionId() == null) {
            game.setSessionId(UUID.randomUUID());
        }
        games.put(game.getSessionId(), game);
    }
}
