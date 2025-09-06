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
        this.playerCards = (player != null) ? player.getCards() : null;
        this.dealerCards = (dealer != null) ? dealer.getCards() : null;
        this.playerValue = (player != null) ? player.getValue() : 0;
        this.dealerValue = (dealer != null) ? dealer.getValue() : 0;
        this.playerBust = (player != null) ? player.isBust() : false;
        this.dealerBust = (dealer != null) ? dealer.isBust() : false;
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
