package com.xbal.app.jackgames.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private int betAmount;
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getValue() {
        int value = 0;
        int numAces = 0;
        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) {
                numAces++;
                value += 11;
            } else if (card.getRank().ordinal() >= Rank.TEN.ordinal()) {
                value += 10;
            } else {
                value += card.getRank().ordinal() + 1;
            }
        }
        while (value > 21 && numAces > 0) {
            value -= 10;
            numAces--;
        }
        return value;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(int betAmount) {
        this.betAmount = betAmount;
    }
}