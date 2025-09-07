package com.example.gambling.dto;

import java.util.Map;

public class RouletteDto {
    private int playerBalance;
    private int currentBet;
    private int lastWinningNumber;
    private String lastWinningColor;
    private boolean gameInProgress;
    private String gameMessage;
    private int totalWinnings;
    private Map<String, Integer> bets;
    private int[] wheelNumbers;
    private String[] colors;
    
    public RouletteDto() {}
    
    public RouletteDto(int playerBalance, int currentBet, int lastWinningNumber, 
                     String lastWinningColor, boolean gameInProgress, String gameMessage,
                     int totalWinnings, Map<String, Integer> bets, int[] wheelNumbers, String[] colors) {
        this.playerBalance = playerBalance;
        this.currentBet = currentBet;
        this.lastWinningNumber = lastWinningNumber;
        this.lastWinningColor = lastWinningColor;
        this.gameInProgress = gameInProgress;
        this.gameMessage = gameMessage;
        this.totalWinnings = totalWinnings;
        this.bets = bets;
        this.wheelNumbers = wheelNumbers;
        this.colors = colors;
    }
    
    // Getters and Setters
    public int getPlayerBalance() { return playerBalance; }
    public void setPlayerBalance(int playerBalance) { this.playerBalance = playerBalance; }
    
    public int getCurrentBet() { return currentBet; }
    public void setCurrentBet(int currentBet) { this.currentBet = currentBet; }
    
    public int getLastWinningNumber() { return lastWinningNumber; }
    public void setLastWinningNumber(int lastWinningNumber) { this.lastWinningNumber = lastWinningNumber; }
    
    public String getLastWinningColor() { return lastWinningColor; }
    public void setLastWinningColor(String lastWinningColor) { this.lastWinningColor = lastWinningColor; }
    
    public boolean isGameInProgress() { return gameInProgress; }
    public void setGameInProgress(boolean gameInProgress) { this.gameInProgress = gameInProgress; }
    
    public String getGameMessage() { return gameMessage; }
    public void setGameMessage(String gameMessage) { this.gameMessage = gameMessage; }
    
    public int getTotalWinnings() { return totalWinnings; }
    public void setTotalWinnings(int totalWinnings) { this.totalWinnings = totalWinnings; }
    
    public Map<String, Integer> getBets() { return bets; }
    public void setBets(Map<String, Integer> bets) { this.bets = bets; }
    
    public int[] getWheelNumbers() { return wheelNumbers; }
    public void setWheelNumbers(int[] wheelNumbers) { this.wheelNumbers = wheelNumbers; }
    
    public String[] getColors() { return colors; }
    public void setColors(String[] colors) { this.colors = colors; }
}
