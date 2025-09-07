package com.example.gambling.service;

import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class RouletteService {
    
    // Roulette wheel numbers (0-36, where 0 is green)
    private static final int[] WHEEL_NUMBERS = {
        0, 32, 15, 19, 4, 21, 2, 25, 17, 34, 6, 27, 13, 36, 11, 30, 8, 23, 10, 5, 24, 16, 33, 1, 20, 14, 31, 9, 22, 18, 29, 7, 28, 12, 35, 3, 26
    };
    
    // Color mapping (0 = green, odd = red, even = black)
    private static final String[] COLORS = {
        "green", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black", "red", "black"
    };
    
    // Game state
    private int playerBalance = 1000;
    private int currentBet = 0;
    private int lastWinningNumber = -1;
    private String lastWinningColor = "";
    private boolean gameInProgress = false;
    private String gameMessage = "";
    private int totalWinnings = 0;
    
    // Betting areas
    private Map<String, Integer> bets = new ConcurrentHashMap<>();
    
    // Betting types and their payouts
    public enum BetType {
        SINGLE_NUMBER(35, "Single Number"),
        RED(1, "Red"),
        BLACK(1, "Black"),
        EVEN(1, "Even"),
        ODD(1, "Odd"),
        LOW(1, "Low (1-18)"),
        HIGH(1, "High (19-36)"),
        DOZEN_FIRST(2, "First Dozen (1-12)"),
        DOZEN_SECOND(2, "Second Dozen (13-24)"),
        DOZEN_THIRD(2, "Third Dozen (25-36)"),
        COLUMN_FIRST(2, "First Column"),
        COLUMN_SECOND(2, "Second Column"),
        COLUMN_THIRD(2, "Third Column");
        
        private final int payoutMultiplier;
        private final String displayName;
        
        BetType(int payoutMultiplier, String displayName) {
            this.payoutMultiplier = payoutMultiplier;
            this.displayName = displayName;
        }
        
        public int getPayoutMultiplier() { return payoutMultiplier; }
        public String getDisplayName() { return displayName; }
    }
    
    public void placeBet(String betType, int amount, String betValue) {
        if (gameInProgress) {
            gameMessage = "Cannot place bets while wheel is spinning!";
            return;
        }
        
        if (amount <= 0 || amount > playerBalance) {
            gameMessage = "Invalid bet amount!";
            return;
        }
        
        String betKey = betType + "_" + betValue;
        bets.put(betKey, bets.getOrDefault(betKey, 0) + amount);
        playerBalance -= amount;
        currentBet += amount;
        gameMessage = "Bet placed: $" + amount + " on " + getBetDisplayName(betType, betValue);
    }
    
    public void spinWheel() {
        if (gameInProgress) {
            gameMessage = "Wheel is already spinning!";
            return;
        }
        
        if (bets.isEmpty()) {
            gameMessage = "Please place a bet before spinning!";
            return;
        }
        
        gameInProgress = true;
        gameMessage = "Spinning the wheel...";
        
        // Simulate wheel spin delay
        new Thread(() -> {
            try {
                Thread.sleep(3000); // 3 second spin
                int winningNumber = WHEEL_NUMBERS[new Random().nextInt(WHEEL_NUMBERS.length)];
                String winningColor = COLORS[winningNumber];
                
                lastWinningNumber = winningNumber;
                lastWinningColor = winningColor;
                
                // Calculate winnings
                int totalWinnings = calculateWinnings(winningNumber, winningColor);
                playerBalance += totalWinnings;
                this.totalWinnings = totalWinnings;
                
                gameMessage = "Winning number: " + winningNumber + " (" + winningColor + "). " +
                             (totalWinnings > 0 ? "You won $" + totalWinnings + "!" : "Better luck next time!");
                
                // Clear bets for next round
                bets.clear();
                currentBet = 0;
                gameInProgress = false;
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
    
    private int calculateWinnings(int winningNumber, String winningColor) {
        int totalWinnings = 0;
        
        for (Map.Entry<String, Integer> bet : bets.entrySet()) {
            String betKey = bet.getKey();
            int betAmount = bet.getValue();
            
            String[] parts = betKey.split("_");
            String betType = parts[0];
            String betValue = parts.length > 1 ? parts[1] : "";
            
            boolean isWinningBet = false;
            int payoutMultiplier = 1;
            
            switch (betType) {
                case "single":
                    if (Integer.parseInt(betValue) == winningNumber) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.SINGLE_NUMBER.getPayoutMultiplier();
                    }
                    break;
                case "red":
                    if ("red".equals(winningColor)) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.RED.getPayoutMultiplier();
                    }
                    break;
                case "black":
                    if ("black".equals(winningColor)) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.BLACK.getPayoutMultiplier();
                    }
                    break;
                case "even":
                    if (winningNumber != 0 && winningNumber % 2 == 0) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.EVEN.getPayoutMultiplier();
                    }
                    break;
                case "odd":
                    if (winningNumber != 0 && winningNumber % 2 == 1) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.ODD.getPayoutMultiplier();
                    }
                    break;
                case "low":
                    if (winningNumber >= 1 && winningNumber <= 18) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.LOW.getPayoutMultiplier();
                    }
                    break;
                case "high":
                    if (winningNumber >= 19 && winningNumber <= 36) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.HIGH.getPayoutMultiplier();
                    }
                    break;
                case "dozen1":
                    if (winningNumber >= 1 && winningNumber <= 12) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.DOZEN_FIRST.getPayoutMultiplier();
                    }
                    break;
                case "dozen2":
                    if (winningNumber >= 13 && winningNumber <= 24) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.DOZEN_SECOND.getPayoutMultiplier();
                    }
                    break;
                case "dozen3":
                    if (winningNumber >= 25 && winningNumber <= 36) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.DOZEN_THIRD.getPayoutMultiplier();
                    }
                    break;
                case "column1":
                    if (winningNumber % 3 == 1 && winningNumber != 0) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.COLUMN_FIRST.getPayoutMultiplier();
                    }
                    break;
                case "column2":
                    if (winningNumber % 3 == 2 && winningNumber != 0) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.COLUMN_SECOND.getPayoutMultiplier();
                    }
                    break;
                case "column3":
                    if (winningNumber % 3 == 0 && winningNumber != 0) {
                        isWinningBet = true;
                        payoutMultiplier = BetType.COLUMN_THIRD.getPayoutMultiplier();
                    }
                    break;
            }
            
            if (isWinningBet) {
                totalWinnings += betAmount * (payoutMultiplier + 1); // +1 for original bet
            }
        }
        
        return totalWinnings;
    }
    
    private String getBetDisplayName(String betType, String betValue) {
        switch (betType) {
            case "single": return "Number " + betValue;
            case "red": return "Red";
            case "black": return "Black";
            case "even": return "Even";
            case "odd": return "Odd";
            case "low": return "Low (1-18)";
            case "high": return "High (19-36)";
            case "dozen1": return "First Dozen (1-12)";
            case "dozen2": return "Second Dozen (13-24)";
            case "dozen3": return "Third Dozen (25-36)";
            case "column1": return "First Column";
            case "column2": return "Second Column";
            case "column3": return "Third Column";
            default: return betType;
        }
    }
    
    public void clearBets() {
        if (gameInProgress) {
            gameMessage = "Cannot clear bets while wheel is spinning!";
            return;
        }
        
        playerBalance += currentBet;
        bets.clear();
        currentBet = 0;
        gameMessage = "All bets cleared!";
    }
    
    public void resetGame() {
        bets.clear();
        currentBet = 0;
        gameInProgress = false;
        gameMessage = "";
        lastWinningNumber = -1;
        lastWinningColor = "";
        totalWinnings = 0;
    }
    
    // Getters
    public int getPlayerBalance() { return playerBalance; }
    public void setPlayerBalance(int balance) { this.playerBalance = balance; }
    
    public int getCurrentBet() { return currentBet; }
    
    public int getLastWinningNumber() { return lastWinningNumber; }
    
    public String getLastWinningColor() { return lastWinningColor; }
    
    public boolean isGameInProgress() { return gameInProgress; }
    
    public String getGameMessage() { return gameMessage; }
    
    public int getTotalWinnings() { return totalWinnings; }
    
    public Map<String, Integer> getBets() { return new HashMap<>(bets); }
    
    public int[] getWheelNumbers() { return WHEEL_NUMBERS.clone(); }
    
    public String[] getColors() { return COLORS.clone(); }
}
