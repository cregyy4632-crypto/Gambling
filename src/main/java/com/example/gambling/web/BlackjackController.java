package com.example.gambling.web;

import com.example.gambling.dto.ApiResponse;
import com.example.gambling.dto.GameStateDto;
import com.example.gambling.service.BlackjackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blackjack")
@CrossOrigin(origins = "*")
public class BlackjackController {

    @Autowired
    private BlackjackService blackjackService;

    @PostMapping("/deal")
    public ResponseEntity<ApiResponse<GameStateDto>> dealCards(@RequestParam(defaultValue = "1000") int balance, @RequestParam(defaultValue = "0") int bet) {
        try {
            blackjackService.start();
            GameStateDto gameState = new GameStateDto(
                blackjackService.getPlayer(),
                blackjackService.getDealer(),
                blackjackService.isRoundOver(),
                blackjackService.getGameResult(),
                blackjackService.isGameStarted()
            );
            gameState.setPlayerBalance(balance);
            gameState.setCurrentBet(bet);
            return ResponseEntity.ok(ApiResponse.success("Cards dealt", gameState));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Failed to deal cards: " + e.getMessage()));
        }
    }

    @PostMapping("/start")
    public ResponseEntity<ApiResponse<GameStateDto>> startGame() {
        try {
            blackjackService.start();
            GameStateDto gameState = new GameStateDto(
                blackjackService.getPlayer(),
                blackjackService.getDealer(),
                blackjackService.isRoundOver(),
                blackjackService.getGameResult(),
                blackjackService.isGameStarted()
            );
            return ResponseEntity.ok(ApiResponse.success("Game started", gameState));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Failed to start game: " + e.getMessage()));
        }
    }

    @PostMapping("/hit")
    public ResponseEntity<ApiResponse<GameStateDto>> hit() {
        try {
            if (!blackjackService.isGameStarted()) {
                return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Game not started. Please start a new game first."));
            }
            
            blackjackService.hit();
            GameStateDto gameState = new GameStateDto(
                blackjackService.getPlayer(),
                blackjackService.getDealer(),
                blackjackService.isRoundOver(),
                blackjackService.getGameResult(),
                blackjackService.isGameStarted()
            );
            return ResponseEntity.ok(ApiResponse.success("Card dealt", gameState));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Failed to hit: " + e.getMessage()));
        }
    }

    @PostMapping("/stand")
    public ResponseEntity<ApiResponse<GameStateDto>> stand() {
        try {
            if (!blackjackService.isGameStarted()) {
                return ResponseEntity.badRequest()
                    .body(ApiResponse.error("Game not started. Please start a new game first."));
            }
            
            blackjackService.stand();
            GameStateDto gameState = new GameStateDto(
                blackjackService.getPlayer(),
                blackjackService.getDealer(),
                blackjackService.isRoundOver(),
                blackjackService.getGameResult(),
                blackjackService.isGameStarted()
            );
            return ResponseEntity.ok(ApiResponse.success("Player stands", gameState));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Failed to stand: " + e.getMessage()));
        }
    }

    @GetMapping("/state")
    public ResponseEntity<ApiResponse<GameStateDto>> getGameState(@RequestParam(defaultValue = "1000") int balance, @RequestParam(defaultValue = "0") int bet) {
        try {
            GameStateDto gameState;
            if (!blackjackService.isGameStarted()) {
                gameState = new GameStateDto(null, null, false, null, false);
            } else {
                gameState = new GameStateDto(
                    blackjackService.getPlayer(),
                    blackjackService.getDealer(),
                    blackjackService.isRoundOver(),
                    blackjackService.getGameResult(),
                    blackjackService.isGameStarted()
                );
            }
            gameState.setPlayerBalance(balance);
            gameState.setCurrentBet(bet);
            return ResponseEntity.ok(ApiResponse.success("Game state retrieved", gameState));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Failed to get game state: " + e.getMessage()));
        }
    }

    @PostMapping("/reset")
    public ResponseEntity<ApiResponse<String>> resetGame() {
        try {
            blackjackService.reset();
            return ResponseEntity.ok(ApiResponse.success("Game reset successfully", "Game has been reset"));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Failed to reset game: " + e.getMessage()));
        }
    }
}
