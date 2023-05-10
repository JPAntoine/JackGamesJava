package com.xbal.app.jackgames.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xbal.app.jackgames.database.GameRepository;
import com.xbal.app.jackgames.exceptions.GameNotFoundException;
import com.xbal.app.jackgames.exceptions.InvalidGameStateException;
import com.xbal.app.jackgames.exceptions.InvalidPlayerCountException;
import com.xbal.app.jackgames.model.Deck;
import com.xbal.app.jackgames.model.Game;
import com.xbal.app.jackgames.model.GameStatus;
import com.xbal.app.jackgames.model.Player;
import com.xbal.app.jackgames.model.PlayerHand;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public UUID createGame(int numPlayers, int numDecks) {
        if (numPlayers > 1 && numPlayers < 7) {
            Game game = new Game(new Deck(Deck.generateGameDeck(numDecks)));
            gameRepository.save(game);
            return game.getSessionId();
        } else {
            throw new InvalidPlayerCountException();
        }
    }

    public GameStatus getGameById(UUID id) {
        Optional<Game> optionalGame = gameRepository.getGameById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            return game.getGameStatus();
        } else {
            throw new GameNotFoundException();
        }
    }

    public GameStatus startGame(UUID id) {
        Optional<Game> optionalGame = gameRepository.getGameById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            if (game.getGameStatus().isWaitingForPlayers() && game.getPlayers().size() > 1) {
                game.startGame();
                gameRepository.save(game);
                return game.getGameStatus();
            } else {
                throw new InvalidGameStateException("Game cannot be started at this time");
            }
        } else {
            throw new GameNotFoundException();
        }
    }

    public void stopGame(UUID id) {
        Optional<Game> optionalGame = gameRepository.getGameById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            if (!game.getGameStatus().isGameCompleted()) {
                game.stopGame();
                gameRepository.save(game);
            } else {
                throw new InvalidGameStateException("Game is already finished");
            }
        } else {
            throw new GameNotFoundException();
        }
    }

    // Player Moves

    public GameStatus hit(UUID id) {
        Optional<Game> optionalGame = gameRepository.getGameById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            game.playerHit();
            gameRepository.save(game);
            return game.getGameStatus();
        } else {
            throw new GameNotFoundException();
        }
    }

    public GameStatus stand(UUID id) {
        Optional<Game> optionalGame = gameRepository.getGameById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            game.playerStand();
            gameRepository.save(game);
            return game.getGameStatus();
        } else {
            throw new GameNotFoundException();
        }
    }

    public GameStatus split(UUID id) {
        Optional<Game> optionalGame = gameRepository.getGameById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            PlayerHand playerHand = game.getPlayerHand(id);

            if (playerHand.canSplit()) {
                List<PlayerHand> newHands = playerHand.split();
                game.setPlayerHand(newHands.get(0));
                game.addPlayerHand(newHands.get(1));

                gameRepository.save(game);
                return game.getGameStatus();
            } else {
                throw new InvalidGameStateException("Unable to split hand");
            }
        } else {
            throw new GameNotFoundException("Game not found");
        }
    }

    // Other actions
    public String getSuggestedMove(UUID id) {
        Optional<Game> optionalGame = gameRepository.getGameById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            return game.getSuggestedMove();
        } else {
            throw new GameNotFoundException();
        }
    }

    // used to join existing game
    public void addPlayerToGame(UUID id, Player player) {
        Optional<Game> optionalGame = gameRepository.getGameById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            game.addPlayerToGame(player);
            gameRepository.save(game);
        } else {
            throw new GameNotFoundException();
        }
    }
}
