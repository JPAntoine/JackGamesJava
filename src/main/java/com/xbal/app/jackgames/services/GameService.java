package com.xbal.app.jackgames.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xbal.app.jackgames.database.GameRepository;
import com.xbal.app.jackgames.model.GameStatus;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void startGame(GameStatus gameStatus) {
        gameRepository.addGame(gameStatus);
    }

    public List<GameStatus> getAllGames() {
        return gameRepository.getGames();
    }

    public GameStatus getGameById(int id) {
        return gameRepository.getGameById(id);
    }

    // Other service methods here...
}