package com.example.gambling.service;

import com.example.gambling.model.Deck;
import com.example.gambling.model.Hand;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BlackjackService {
    // Store game state per session (using thread ID as simple session key)
    private final ConcurrentHashMap<String, GameState> gameStates = new ConcurrentHashMap<>();
    
    private static class GameState {
        Deck deck;
        Hand player;
        Hand dealer;
        boolean roundOver;
        boolean gameStarted;
        String gameResult;
    }
    private String getSessionKey() {
        return Thread.currentThread().getName();
    }
    
    private GameState getOrCreateGameState() {
        String sessionKey = getSessionKey();
        return gameStates.computeIfAbsent(sessionKey, k -> new GameState());
    }

    public void start() {
        GameState state = getOrCreateGameState();
        state.deck = new Deck();
        state.player = new Hand();
        state.dealer = new Hand();
        state.roundOver = false;
        state.gameStarted = true;
        state.gameResult = null;
        
        // Initial deal
        state.player.add(state.deck.deal());
        state.dealer.add(state.deck.deal());
        state.player.add(state.deck.deal());
        state.dealer.add(state.deck.deal());
    }

    public void hit() {
        GameState state = getOrCreateGameState();
        if (state.roundOver || !state.gameStarted) return;
        state.player.add(state.deck.deal());
        if (state.player.isBust()) {
            state.roundOver = true;
            state.gameResult = "Player busts! Dealer wins.";
        }
    }

    public void stand() {
        GameState state = getOrCreateGameState();
        if (state.roundOver || !state.gameStarted) return;
        
        // Dealer plays
        while (state.dealer.getValue() < 17) {
            state.dealer.add(state.deck.deal());
        }
        
        state.roundOver = true;
        determineWinner(state);
    }

    private void determineWinner(GameState state) {
        if (state.player.isBust()) {
            state.gameResult = "Player busts! Dealer wins.";
        } else if (state.dealer.isBust()) {
            state.gameResult = "Dealer busts! Player wins.";
        } else {
            int playerValue = state.player.getValue();
            int dealerValue = state.dealer.getValue();
            
            if (playerValue > dealerValue) {
                state.gameResult = "Player wins!";
            } else if (playerValue < dealerValue) {
                state.gameResult = "Dealer wins.";
            } else {
                state.gameResult = "Push (tie).";
            }
        }
    }

    public void reset() {
        GameState state = getOrCreateGameState();
        state.gameStarted = false;
        state.roundOver = false;
        state.gameResult = null;
        state.player = null;
        state.dealer = null;
        state.deck = null;
    }

    // Getters
    public Hand getPlayer() { 
        GameState state = getOrCreateGameState();
        return state.player; 
    }
    
    public Hand getDealer() { 
        GameState state = getOrCreateGameState();
        return state.dealer; 
    }
    
    public boolean isRoundOver() { 
        GameState state = getOrCreateGameState();
        return state.roundOver; 
    }
    
    public boolean isGameStarted() { 
        GameState state = getOrCreateGameState();
        return state.gameStarted; 
    }
    
    public String getGameResult() { 
        GameState state = getOrCreateGameState();
        return state.gameResult; 
    }
}



