package com.xbal.app.jackgames.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    private int value;

    public Hand() {
        this.cards = new ArrayList<>();
        this.value = 0;
    }

    public void addCard(Card card) {
        cards.add(card);
        value += card.getValue();
        if (value > 21 && hasAce()) {
            value -= 10;
        }
    }

    private boolean hasAce() {
        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        cards.clear();
        value = 0;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getValue() {
        return value;
    }

    // Add setters if necessary
}