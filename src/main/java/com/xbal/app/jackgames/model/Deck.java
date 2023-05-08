package com.xbal.app.jackgames.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(0);
    }

    public List<Card> getCards() {
        return cards;
    }

    public static List<Card> generateGameDeck(int numDecks) {
        if (numDecks <= 0) {
            numDecks = 6;
        }

        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < numDecks; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deck.add(new Card(suit, rank));
                }
            }
        }
        return deck;
    }

}