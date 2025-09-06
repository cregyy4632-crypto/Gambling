package com.example.gambling.service;

import com.example.gambling.model.Deck;
import com.example.gambling.model.Hand;
import org.springframework.stereotype.Service;

@Service
public class BlackjackService {
    // Single game state for simplicity
    private Deck deck;
    private Hand player;
    private Hand dealer;
    private boolean roundOver;
    private boolean gameStarted;
    private String gameResult;

    public void start() {
        deck = new Deck();
        player = new Hand();
        dealer = new Hand();
        roundOver = false;
        gameStarted = true;
        gameResult = null;
        
        // Initial deal
        player.add(deck.deal());
        dealer.add(deck.deal());
        player.add(deck.deal());
        dealer.add(deck.deal());
    }

    public void hit() {
        if (roundOver || !gameStarted) return;
        player.add(deck.deal());
        if (player.isBust()) {
            roundOver = true;
            gameResult = "Player busts! Dealer wins.";
        }
    }

    public void stand() {
        if (roundOver || !gameStarted) return;
        
        // Dealer plays
        while (dealer.getValue() < 17) {
            dealer.add(deck.deal());
        }
        
        roundOver = true;
        determineWinner();
    }

    private void determineWinner() {
        if (player.isBust()) {
            gameResult = "Player busts! Dealer wins.";
        } else if (dealer.isBust()) {
            gameResult = "Dealer busts! Player wins.";
        } else {
            int playerValue = player.getValue();
            int dealerValue = dealer.getValue();
            
            if (playerValue > dealerValue) {
                gameResult = "Player wins!";
            } else if (playerValue < dealerValue) {
                gameResult = "Dealer wins.";
            } else {
                gameResult = "Push (tie).";
            }
        }
    }

    public void reset() {
        gameStarted = false;
        roundOver = false;
        gameResult = null;
        player = null;
        dealer = null;
        deck = null;
    }

    // Getters
    public Hand getPlayer() { 
        return player; 
    }
    
    public Hand getDealer() { 
        return dealer; 
    }
    
    public boolean isRoundOver() { 
        return roundOver; 
    }
    
    public boolean isGameStarted() { 
        return gameStarted; 
    }
    
    public String getGameResult() { 
        return gameResult; 
    }
}



