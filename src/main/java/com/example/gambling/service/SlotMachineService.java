package com.example.gambling.service;

import com.example.gambling.dto.ApiResponse;
import com.example.gambling.dto.GameStateDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SlotMachineService {
    
    private int playerBalance = 1000;
    private int currentBet = 0;
    private boolean gameStarted = false;
    private boolean roundOver = false;
    private int totalWinnings = 0;
    
    // Fishing Frenzy symbols with their values and probabilities
    private final String[] SYMBOLS = {
        "🐟", "🦈", "🐠", "🦑", "🦀", "🐙", "⚓", "💎", "🎣", "💰"
    };
    
    // Symbol values (multipliers)
    private final Map<String, Integer> SYMBOL_VALUES = new HashMap<>();
    
    public SlotMachineService() {
        // Initialize symbol values
        SYMBOL_VALUES.put("🐟", 1);    // Fish - 1x
        SYMBOL_VALUES.put("🦈", 2);    // Shark - 2x
        SYMBOL_VALUES.put("🐠", 3);    // Tropical Fish - 3x
        SYMBOL_VALUES.put("🦑", 4);    // Squid - 4x
        SYMBOL_VALUES.put("🦀", 5);    // Crab - 5x
        SYMBOL_VALUES.put("🐙", 6);    // Octopus - 6x
        SYMBOL_VALUES.put("⚓", 8);    // Anchor - 8x
        SYMBOL_VALUES.put("💎", 10);   // Diamond - 10x
        SYMBOL_VALUES.put("🎣", 15);   // Fishing Rod - 15x
        SYMBOL_VALUES.put("💰", 25);   // Treasure - 25x
    }
    
    public ApiResponse<GameStateDto> getState() {
        GameStateDto state = new GameStateDto();
        state.setPlayerBalance(playerBalance);
        state.setCurrentBet(currentBet);
        state.setGameStarted(gameStarted);
        state.setRoundOver(roundOver);
        state.setTotalWinnings(totalWinnings);
        state.setMessage("🎰 Fishing Frenzy Slot Machine Ready!");
        
        return new ApiResponse<>(true, "Game state retrieved", state);
    }
    
    public ApiResponse<GameStateDto> setBet(int betAmount) {
        if (betAmount <= 0) {
            return new ApiResponse<>(false, "Bet amount must be positive", null);
        }
        
        if (betAmount > playerBalance) {
            return new ApiResponse<>(false, "Insufficient balance", null);
        }
        
        currentBet = betAmount;
        gameStarted = false;
        roundOver = false;
        
        GameStateDto state = new GameStateDto();
        state.setPlayerBalance(playerBalance);
        state.setCurrentBet(currentBet);
        state.setGameStarted(gameStarted);
        state.setRoundOver(roundOver);
        state.setTotalWinnings(totalWinnings);
        state.setMessage("💰 Bet set to $" + currentBet + " - Ready to spin!");
        
        return new ApiResponse<>(true, "Bet set successfully", state);
    }
    
    public ApiResponse<GameStateDto> spin() {
        if (currentBet <= 0) {
            return new ApiResponse<>(false, "Please set a bet first", null);
        }
        
        if (currentBet > playerBalance) {
            return new ApiResponse<>(false, "Insufficient balance", null);
        }
        
        // Deduct bet from balance
        playerBalance -= currentBet;
        
        // Generate 5 reels with weighted probabilities
        String[] reel1 = generateReel();
        String[] reel2 = generateReel();
        String[] reel3 = generateReel();
        String[] reel4 = generateReel();
        String[] reel5 = generateReel();
        
        // Calculate winnings
        int winnings = calculateWinnings(reel1, reel2, reel3, reel4, reel5);
        totalWinnings = winnings;
        
        // Add winnings to balance
        playerBalance += winnings;
        
        gameStarted = true;
        roundOver = true;
        
        GameStateDto state = new GameStateDto();
        state.setPlayerBalance(playerBalance);
        state.setCurrentBet(currentBet);
        state.setGameStarted(gameStarted);
        state.setRoundOver(roundOver);
        state.setTotalWinnings(totalWinnings);
        state.setReel1(reel1);
        state.setReel2(reel2);
        state.setReel3(reel3);
        state.setReel4(reel4);
        state.setReel5(reel5);
        
        String message;
        if (winnings > 0) {
            message = "🎉 You won $" + winnings + "! " + getWinMessage(reel1, reel2, reel3, reel4, reel5);
        } else {
            message = "😔 No win this time. Try again!";
        }
        state.setMessage(message);
        
        return new ApiResponse<>(true, "Spin completed", state);
    }
    
    public ApiResponse<GameStateDto> reset() {
        playerBalance = 1000;
        currentBet = 0;
        gameStarted = false;
        roundOver = false;
        totalWinnings = 0;
        
        GameStateDto state = new GameStateDto();
        state.setPlayerBalance(playerBalance);
        state.setCurrentBet(currentBet);
        state.setGameStarted(gameStarted);
        state.setRoundOver(roundOver);
        state.setTotalWinnings(totalWinnings);
        state.setMessage("🎰 Fishing Frenzy Slot Machine Reset!");
        
        return new ApiResponse<>(true, "Game reset", state);
    }
    
    private String[] generateReel() {
        String[] reel = new String[3];
        
        // Weighted probabilities - common symbols appear more often
        for (int i = 0; i < 3; i++) {
            double rand = Math.random();
            if (rand < 0.3) {
                reel[i] = "🐟"; // 30% chance
            } else if (rand < 0.5) {
                reel[i] = "🦈"; // 20% chance
            } else if (rand < 0.65) {
                reel[i] = "🐠"; // 15% chance
            } else if (rand < 0.75) {
                reel[i] = "🦑"; // 10% chance
            } else if (rand < 0.82) {
                reel[i] = "🦀"; // 7% chance
            } else if (rand < 0.87) {
                reel[i] = "🐙"; // 5% chance
            } else if (rand < 0.91) {
                reel[i] = "⚓"; // 4% chance
            } else if (rand < 0.94) {
                reel[i] = "💎"; // 3% chance
            } else if (rand < 0.97) {
                reel[i] = "🎣"; // 3% chance
            } else {
                reel[i] = "💰"; // 3% chance
            }
        }
        
        return reel;
    }
    
    private int calculateWinnings(String[] reel1, String[] reel2, String[] reel3, String[] reel4, String[] reel5) {
        int winnings = 0;
        
        // Check for horizontal wins (same symbol across all 5 reels)
        for (int row = 0; row < 3; row++) {
            if (reel1[row].equals(reel2[row]) && reel2[row].equals(reel3[row]) && 
                reel3[row].equals(reel4[row]) && reel4[row].equals(reel5[row])) {
                int multiplier = SYMBOL_VALUES.get(reel1[row]);
                winnings += currentBet * multiplier * 2; // 5-reel win pays double
            }
        }
        
        // Check for 4-reel matches
        for (int row = 0; row < 3; row++) {
            if (reel1[row].equals(reel2[row]) && reel2[row].equals(reel3[row]) && reel3[row].equals(reel4[row])) {
                int multiplier = SYMBOL_VALUES.get(reel1[row]);
                winnings += currentBet * multiplier;
            }
            if (reel2[row].equals(reel3[row]) && reel3[row].equals(reel4[row]) && reel4[row].equals(reel5[row])) {
                int multiplier = SYMBOL_VALUES.get(reel2[row]);
                winnings += currentBet * multiplier;
            }
        }
        
        // Check for 3-reel matches
        for (int row = 0; row < 3; row++) {
            if (reel1[row].equals(reel2[row]) && reel2[row].equals(reel3[row])) {
                int multiplier = SYMBOL_VALUES.get(reel1[row]);
                winnings += currentBet * (multiplier / 2);
            }
            if (reel2[row].equals(reel3[row]) && reel3[row].equals(reel4[row])) {
                int multiplier = SYMBOL_VALUES.get(reel2[row]);
                winnings += currentBet * (multiplier / 2);
            }
            if (reel3[row].equals(reel4[row]) && reel4[row].equals(reel5[row])) {
                int multiplier = SYMBOL_VALUES.get(reel3[row]);
                winnings += currentBet * (multiplier / 2);
            }
        }
        
        // Check for diagonal wins (5-reel diagonals)
        // Top-left to bottom-right
        if (reel1[0].equals(reel2[1]) && reel2[1].equals(reel3[2]) && 
            reel3[2].equals(reel4[1]) && reel4[1].equals(reel5[0])) {
            int multiplier = SYMBOL_VALUES.get(reel1[0]);
            winnings += currentBet * multiplier * 2;
        }
        
        // Bottom-left to top-right
        if (reel1[2].equals(reel2[1]) && reel2[1].equals(reel3[0]) && 
            reel3[0].equals(reel4[1]) && reel4[1].equals(reel5[2])) {
            int multiplier = SYMBOL_VALUES.get(reel1[2]);
            winnings += currentBet * multiplier * 2;
        }
        
        return winnings;
    }
    
    private String getWinMessage(String[] reel1, String[] reel2, String[] reel3, String[] reel4, String[] reel5) {
        // Check for 5-reel horizontal wins
        for (int row = 0; row < 3; row++) {
            if (reel1[row].equals(reel2[row]) && reel2[row].equals(reel3[row]) && 
                reel3[row].equals(reel4[row]) && reel4[row].equals(reel5[row])) {
                return "Five " + reel1[row] + " in a row! MEGA WIN!";
            }
        }
        
        // Check for 4-reel horizontal wins
        for (int row = 0; row < 3; row++) {
            if (reel1[row].equals(reel2[row]) && reel2[row].equals(reel3[row]) && reel3[row].equals(reel4[row])) {
                return "Four " + reel1[row] + " in a row!";
            }
            if (reel2[row].equals(reel3[row]) && reel3[row].equals(reel4[row]) && reel4[row].equals(reel5[row])) {
                return "Four " + reel2[row] + " in a row!";
            }
        }
        
        // Check for 3-reel horizontal wins
        for (int row = 0; row < 3; row++) {
            if (reel1[row].equals(reel2[row]) && reel2[row].equals(reel3[row])) {
                return "Three " + reel1[row] + " in a row!";
            }
            if (reel2[row].equals(reel3[row]) && reel3[row].equals(reel4[row])) {
                return "Three " + reel2[row] + " in a row!";
            }
            if (reel3[row].equals(reel4[row]) && reel4[row].equals(reel5[row])) {
                return "Three " + reel3[row] + " in a row!";
            }
        }
        
        // Check for diagonal wins
        if (reel1[0].equals(reel2[1]) && reel2[1].equals(reel3[2]) && 
            reel3[2].equals(reel4[1]) && reel4[1].equals(reel5[0])) {
            return "Five-reel diagonal win!";
        }
        
        if (reel1[2].equals(reel2[1]) && reel2[1].equals(reel3[0]) && 
            reel3[0].equals(reel4[1]) && reel4[1].equals(reel5[2])) {
            return "Five-reel diagonal win!";
        }
        
        return "Partial match!";
    }
}
