package com.example.gambling.dto;

import com.example.gambling.model.Card;
import com.example.gambling.model.Hand;
import java.util.List;

public class GameStateDto {
    private List<Card> playerCards;
    private List<Card> dealerCards;
    private int playerValue;
    private int dealerValue;
    private boolean playerBust;
    private boolean dealerBust;
    private boolean roundOver;
    private String gameResult;
    private boolean gameStarted;

    public GameStateDto() {}

    public GameStateDto(Hand player, Hand dealer, boolean roundOver, String gameResult, boolean gameStarted) {
        this.playerCards = player.getCards();
        this.dealerCards = dealer.getCards();
        this.playerValue = player.getValue();
        this.dealerValue = dealer.getValue();
        this.playerBust = player.isBust();
        this.dealerBust = dealer.isBust();
        this.roundOver = roundOver;
        this.gameResult = gameResult;
        this.gameStarted = gameStarted;
    }

    // Getters and Setters
    public List<Card> getPlayerCards() { return playerCards; }
    public void setPlayerCards(List<Card> playerCards) { this.playerCards = playerCards; }

    public List<Card> getDealerCards() { return dealerCards; }
    public void setDealerCards(List<Card> dealerCards) { this.dealerCards = dealerCards; }

    public int getPlayerValue() { return playerValue; }
    public void setPlayerValue(int playerValue) { this.playerValue = playerValue; }

    public int getDealerValue() { return dealerValue; }
    public void setDealerValue(int dealerValue) { this.dealerValue = dealerValue; }

    public boolean isPlayerBust() { return playerBust; }
    public void setPlayerBust(boolean playerBust) { this.playerBust = playerBust; }

    public boolean isDealerBust() { return dealerBust; }
    public void setDealerBust(boolean dealerBust) { this.dealerBust = dealerBust; }

    public boolean isRoundOver() { return roundOver; }
    public void setRoundOver(boolean roundOver) { this.roundOver = roundOver; }

    public String getGameResult() { return gameResult; }
    public void setGameResult(String gameResult) { this.gameResult = gameResult; }

    public boolean isGameStarted() { return gameStarted; }
    public void setGameStarted(boolean gameStarted) { this.gameStarted = gameStarted; }
}
