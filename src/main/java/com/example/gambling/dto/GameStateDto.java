package com.example.gambling.dto;

import com.example.gambling.model.Card;
import com.example.gambling.model.Hand;
import java.util.List;
import java.util.stream.Collectors;

public class GameStateDto {
    private List<CardDto> playerCards;
    private List<CardDto> dealerCards;
    private int playerValue;
    private int dealerValue;
    private boolean playerBust;
    private boolean dealerBust;
    private boolean roundOver;
    private String gameResult;
    private boolean gameStarted;
    
    // Slot machine fields
    private int playerBalance;
    private int currentBet;
    private int totalWinnings;
    private int freeSpinsRemaining;
    private boolean inFreeSpinsMode;
    private String[] reel1;
    private String[] reel2;
    private String[] reel3;
    private String[] reel4;
    private String[] reel5;
    private String message;

    public GameStateDto() {}

    public GameStateDto(Hand player, Hand dealer, boolean roundOver, String gameResult, boolean gameStarted) {
        this.playerCards = (player != null) ? player.getCards().stream().map(CardDto::new).collect(Collectors.toList()) : null;
        this.dealerCards = (dealer != null) ? dealer.getCards().stream().map(CardDto::new).collect(Collectors.toList()) : null;
        this.playerValue = (player != null) ? player.getValue() : 0;
        this.dealerValue = (dealer != null) ? dealer.getValue() : 0;
        this.playerBust = (player != null) ? player.isBust() : false;
        this.dealerBust = (dealer != null) ? dealer.isBust() : false;
        this.roundOver = roundOver;
        this.gameResult = gameResult;
        this.gameStarted = gameStarted;
    }

    // Getters and Setters
    public List<CardDto> getPlayerCards() { return playerCards; }
    public void setPlayerCards(List<CardDto> playerCards) { this.playerCards = playerCards; }

    public List<CardDto> getDealerCards() { return dealerCards; }
    public void setDealerCards(List<CardDto> dealerCards) { this.dealerCards = dealerCards; }

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

    // Slot machine getters and setters
    public int getPlayerBalance() { return playerBalance; }
    public void setPlayerBalance(int playerBalance) { this.playerBalance = playerBalance; }

    public int getCurrentBet() { return currentBet; }
    public void setCurrentBet(int currentBet) { this.currentBet = currentBet; }

    public int getTotalWinnings() { return totalWinnings; }
    public void setTotalWinnings(int totalWinnings) { this.totalWinnings = totalWinnings; }

    public int getFreeSpinsRemaining() { return freeSpinsRemaining; }
    public void setFreeSpinsRemaining(int freeSpinsRemaining) { this.freeSpinsRemaining = freeSpinsRemaining; }

    public boolean isInFreeSpinsMode() { return inFreeSpinsMode; }
    public void setInFreeSpinsMode(boolean inFreeSpinsMode) { this.inFreeSpinsMode = inFreeSpinsMode; }

    public String[] getReel1() { return reel1; }
    public void setReel1(String[] reel1) { this.reel1 = reel1; }

    public String[] getReel2() { return reel2; }
    public void setReel2(String[] reel2) { this.reel2 = reel2; }

    public String[] getReel3() { return reel3; }
    public void setReel3(String[] reel3) { this.reel3 = reel3; }

    public String[] getReel4() { return reel4; }
    public void setReel4(String[] reel4) { this.reel4 = reel4; }

    public String[] getReel5() { return reel5; }
    public void setReel5(String[] reel5) { this.reel5 = reel5; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
