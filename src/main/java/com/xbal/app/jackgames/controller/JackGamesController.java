package com.xbal.app.jackgames.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbal.app.jackgames.model.GameStatus;
import com.xbal.app.jackgames.model.Player;
import com.xbal.app.jackgames.services.GameService;

@RestController
@RequestMapping("/api")
public class JackGamesController {

    @Autowired
    private GameService gameService;

    @PostMapping("/games")
    public ResponseEntity<UUID> createGame(@PathVariable("players") int numPlayers, @RequestBody int numDecks) {
        UUID sessionId = gameService.createGame(numPlayers, numDecks);
        return ResponseEntity.ok(sessionId);
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<GameStatus> getGameById(@PathVariable("id") UUID id) {
        GameStatus gameStatus = gameService.getGameById(id);
        return ResponseEntity.ok(gameStatus);
    }

    // Game controls
    @PostMapping("/games/{id}/start")
    public ResponseEntity<GameStatus> startGame(@PathVariable("id") UUID id) {
        GameStatus gameStatus = gameService.startGame(id);
        return ResponseEntity.ok(gameStatus);
    }

    @PostMapping("/games/{id}/stop")
    public ResponseEntity<String> stopGame(@PathVariable("id") UUID id) {
        gameService.stopGame(id);
        return ResponseEntity.ok("Game stopped");
    }

    @PostMapping("/games/{id}/hit")
    public ResponseEntity<GameStatus> hit(@PathVariable("id") UUID id) {
        GameStatus gameStatus = gameService.hit(id);
        return ResponseEntity.ok(gameStatus);
    }

    @PostMapping("/games/{id}/stand")
    public ResponseEntity<GameStatus> stand(@PathVariable("id") UUID id) {
        GameStatus gameStatus = gameService.stand(id);
        return ResponseEntity.ok(gameStatus);
    }

    @GetMapping("/games/{id}/suggestion")
    public ResponseEntity<String> getSuggestedMove(@PathVariable("id") UUID id) {
        String suggestion = gameService.getSuggestedMove(id);
        return ResponseEntity.ok(suggestion);
    }

    @PostMapping("/games/{id}/players")
    public ResponseEntity<String> addPlayerToGame(@PathVariable("id") UUID id, @RequestBody Player player) {
        gameService.addPlayerToGame(id, player);
        return ResponseEntity.ok("Player added to game");
    }

}
