package com.xbal.app.jackgames.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xbal.app.jackgames.model.Hand;

enum Moves{
    Hit,
    Stand,
    DoubleDown,
    Split,
    Surrender
}

public class Hands {
    Hand playerHand;
    Hand dealerHand;
}


@RestController
@RequestMapping("/strategy")
public class StrategyController {

    @PostMapping("/")
	public String getStrategy(@RequestBody Hands gameHands){

    }
    
}
