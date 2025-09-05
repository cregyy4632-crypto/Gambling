package com.example.gambling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public void add(Card card) {
        cards.add(card);
    }

    public int getValue() {
        int total = 0;
        int aces = 0;
        for (Card c : cards) {
            total += c.getValue();
            if (c.isAce()) aces++;
        }
        while (total > 21 && aces > 0) {
            total -= 10; // Count one Ace as 1 instead of 11
            aces--;
        }
        return total;
    }

    public boolean isBust() {
        return getValue() > 21;
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(new ArrayList<>(cards));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : cards) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(c.toString());
        }
        sb.append(" (").append(getValue()).append(")");
        return sb.toString();
    }
}



