package com.example.gambling.model;

public class Card {
    public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }
    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(10), QUEEN(10), KING(10), ACE(11);
        private final int defaultValue;
        Rank(int v) { this.defaultValue = v; }
        public int getDefaultValue() { return defaultValue; }
    }

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) { this.suit = suit; this.rank = rank; }
    public Suit getSuit() { return suit; }
    public Rank getRank() { return rank; }
    public int getValue() { return rank.getDefaultValue(); }
    public boolean isAce() { return rank == Rank.ACE; }

    @Override
    public String toString() {
        String r;
        switch (rank) {
            case TWO: r = "2"; break; case THREE: r = "3"; break; case FOUR: r = "4"; break;
            case FIVE: r = "5"; break; case SIX: r = "6"; break; case SEVEN: r = "7"; break;
            case EIGHT: r = "8"; break; case NINE: r = "9"; break; case TEN: r = "10"; break;
            case JACK: r = "J"; break; case QUEEN: r = "Q"; break; case KING: r = "K"; break;
            default: r = "A";
        }
        String s;
        switch (suit) {
            case CLUBS: s = "\u2663"; break; case DIAMONDS: s = "\u2666"; break;
            case HEARTS: s = "\u2665"; break; default: s = "\u2660";
        }
        return r + s;
    }
    
    public String getDisplayName() {
        return rank.name().toLowerCase() + "_of_" + suit.name().toLowerCase();
    }
    
    public String getSuitSymbol() {
        switch (suit) {
            case CLUBS: return "\u2663";
            case DIAMONDS: return "\u2666";
            case HEARTS: return "\u2665";
            case SPADES: return "\u2660";
            default: return "?";
        }
    }
    
    public String getRankSymbol() {
        switch (rank) {
            case TWO: return "2";
            case THREE: return "3";
            case FOUR: return "4";
            case FIVE: return "5";
            case SIX: return "6";
            case SEVEN: return "7";
            case EIGHT: return "8";
            case NINE: return "9";
            case TEN: return "10";
            case JACK: return "J";
            case QUEEN: return "Q";
            case KING: return "K";
            case ACE: return "A";
            default: return "?";
        }
    }
    
    public boolean isRed() {
        return suit == Suit.HEARTS || suit == Suit.DIAMONDS;
    }
}



