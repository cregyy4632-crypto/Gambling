package com.example.gambling.dto;

import com.example.gambling.model.Card;

public class CardDto {
    private String suit;
    private String rank;
    private int value;
    private boolean isAce;
    private String suitSymbol;
    private String rankSymbol;
    private boolean isRed;

    public CardDto() {}

    public CardDto(Card card) {
        this.suit = card.getSuit().name();
        this.rank = card.getRank().name();
        this.value = card.getValue();
        this.isAce = card.isAce();
        this.suitSymbol = card.getSuitSymbol();
        this.rankSymbol = card.getRankSymbol();
        this.isRed = card.isRed();
    }

    // Getters and Setters
    public String getSuit() { return suit; }
    public void setSuit(String suit) { this.suit = suit; }

    public String getRank() { return rank; }
    public void setRank(String rank) { this.rank = rank; }

    public int getValue() { return value; }
    public void setValue(int value) { this.value = value; }

    public boolean isAce() { return isAce; }
    public void setAce(boolean ace) { isAce = ace; }

    public String getSuitSymbol() { return suitSymbol; }
    public void setSuitSymbol(String suitSymbol) { this.suitSymbol = suitSymbol; }

    public String getRankSymbol() { return rankSymbol; }
    public void setRankSymbol(String rankSymbol) { this.rankSymbol = rankSymbol; }

    public boolean isRed() { return isRed; }
    public void setRed(boolean red) { isRed = red; }
}
