package com.xbal.app.jackgames.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbal.app.jackgames.model.GameStatus;

@RestController
@RequestMapping("/game")
public class GameController {
    
    // Inject any necessary services or repositories here

    @PostMapping
    public String startGame() {
        // ...
    }

    @GetMapping("/{sessionId}")
    public GameStatus getGameStatus(@PathVariable String sessionId) {
        // ...
    }

    @PostMapping("/{sessionId}/bet")
    public GameStatus placeBet(@PathVariable String sessionId, @RequestBody BetRequest betRequest) {
        // ...
    }

    @PostMapping("/{sessionId}/hit")
    public GameStatus hit(@PathVariable String sessionId) {
        // ...
    }

    @PostMapping("/{sessionId}/stand")
    public GameStatus stand(@PathVariable String sessionId) {
        // ...
    }

    @PostMapping("/{sessionId}/double")
    public GameStatus doubleDown(@PathVariable String sessionId) {
        // ...
    }

    @PostMapping("/{sessionId}/split")
    public GameStatus split(@PathVariable String sessionId) {
        // ...
    }

    @PostMapping("/{sessionId}/surrender")
    public GameStatus surrender(@PathVariable String sessionId) {
        // ...
    }

    @DeleteMapping("/{sessionId}")
    public void endGame(@PathVariable String sessionId) {
        // ...
    }
}

