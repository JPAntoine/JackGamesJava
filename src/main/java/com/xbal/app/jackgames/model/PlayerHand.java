package com.xbal.app.jackgames.model;

import java.util.List;

import com.xbal.app.jackgames.exceptions.InvalidGameStateException;

public class PlayerHand extends Hand {
    private boolean isSplit;

    public PlayerHand(List<Card> cards) {
        super(cards);
        this.isSplit = false;
    }

    public boolean isSplit() {
        return isSplit;
    }

    public boolean canSplit() {
        if (super.getCards().size() == 2 && super.getCards().get(0).getRank() == super.getCards().get(1).getRank()) {
            return true;
        } else {
            return false;
        }
    }

    public List<PlayerHand> split() {
        if (super.getCards().size() == 2 && super.getCards().get(0).getRank() == super.getCards().get(1).getRank()) {
            Card card1 = super.getCards().get(0);
            Card card2 = super.getCards().get(1);

            List<PlayerHand> newHands = List.of(
                    new PlayerHand(List.of(card1)),
                    new PlayerHand(List.of(card2)));

            newHands.get(0).setBetAmount(super.getBetAmount());
            newHands.get(1).setBetAmount(super.getBetAmount());

            return newHands;
        } else {
            throw new InvalidGameStateException("Cards cannot be split");
        }
    }
}
