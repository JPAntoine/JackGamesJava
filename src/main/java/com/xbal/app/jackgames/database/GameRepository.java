package com.xbal.app.jackgames.database;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xbal.app.jackgames.model.GameStatus;

@Repository
public class GameRepository {
    private List<GameStatus> games = new ArrayList<>();

    public void addGame(GameStatus gameStatus) {
        games.add(gameStatus);
    }

    public List<GameStatus> getGames() {
        return games;
    }

    public GameStatus getGameById(int id) {
        for (GameStatus game : games) {
            if (game.getSessionId() == id) {
                return game;
            }
        }
        return null;
    }

    // Other repository methods here...
}
