package com.example.gambling.web;

import com.example.gambling.dto.ApiResponse;
import com.example.gambling.dto.RouletteDto;
import com.example.gambling.service.RouletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roulette")
@CrossOrigin(origins = "*")
public class RouletteController {

    @Autowired
    private RouletteService rouletteService;

    @PostMapping("/bet")
    public ResponseEntity<ApiResponse<RouletteDto>> placeBet(
            @RequestParam String betType,
            @RequestParam int amount,
            @RequestParam(required = false) String betValue) {
        try {
            rouletteService.placeBet(betType, amount, betValue != null ? betValue : "");
            
            RouletteDto gameState = new RouletteDto(
                rouletteService.getPlayerBalance(),
                rouletteService.getCurrentBet(),
                rouletteService.getLastWinningNumber(),
                rouletteService.getLastWinningColor(),
                rouletteService.isGameInProgress(),
                rouletteService.getGameMessage(),
                rouletteService.getTotalWinnings(),
                rouletteService.getBets(),
                rouletteService.getWheelNumbers(),
                rouletteService.getColors()
            );
            
            return ResponseEntity.ok(ApiResponse.success("Bet placed", gameState));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Failed to place bet: " + e.getMessage()));
        }
    }

    @PostMapping("/spin")
    public ResponseEntity<ApiResponse<RouletteDto>> spinWheel() {
        try {
            rouletteService.spinWheel();
            
            RouletteDto gameState = new RouletteDto(
                rouletteService.getPlayerBalance(),
                rouletteService.getCurrentBet(),
                rouletteService.getLastWinningNumber(),
                rouletteService.getLastWinningColor(),
                rouletteService.isGameInProgress(),
                rouletteService.getGameMessage(),
                rouletteService.getTotalWinnings(),
                rouletteService.getBets(),
                rouletteService.getWheelNumbers(),
                rouletteService.getColors()
            );
            
            return ResponseEntity.ok(ApiResponse.success("Wheel spinning", gameState));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Failed to spin wheel: " + e.getMessage()));
        }
    }

    @PostMapping("/clear")
    public ResponseEntity<ApiResponse<RouletteDto>> clearBets() {
        try {
            rouletteService.clearBets();
            
            RouletteDto gameState = new RouletteDto(
                rouletteService.getPlayerBalance(),
                rouletteService.getCurrentBet(),
                rouletteService.getLastWinningNumber(),
                rouletteService.getLastWinningColor(),
                rouletteService.isGameInProgress(),
                rouletteService.getGameMessage(),
                rouletteService.getTotalWinnings(),
                rouletteService.getBets(),
                rouletteService.getWheelNumbers(),
                rouletteService.getColors()
            );
            
            return ResponseEntity.ok(ApiResponse.success("Bets cleared", gameState));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Failed to clear bets: " + e.getMessage()));
        }
    }

    @GetMapping("/state")
    public ResponseEntity<ApiResponse<RouletteDto>> getGameState(@RequestParam(defaultValue = "1000") int balance) {
        try {
            rouletteService.setPlayerBalance(balance);
            
            RouletteDto gameState = new RouletteDto(
                rouletteService.getPlayerBalance(),
                rouletteService.getCurrentBet(),
                rouletteService.getLastWinningNumber(),
                rouletteService.getLastWinningColor(),
                rouletteService.isGameInProgress(),
                rouletteService.getGameMessage(),
                rouletteService.getTotalWinnings(),
                rouletteService.getBets(),
                rouletteService.getWheelNumbers(),
                rouletteService.getColors()
            );
            
            return ResponseEntity.ok(ApiResponse.success("Game state retrieved", gameState));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Failed to get game state: " + e.getMessage()));
        }
    }

    @PostMapping("/reset")
    public ResponseEntity<ApiResponse<RouletteDto>> resetGame() {
        try {
            rouletteService.resetGame();
            
            RouletteDto gameState = new RouletteDto(
                rouletteService.getPlayerBalance(),
                rouletteService.getCurrentBet(),
                rouletteService.getLastWinningNumber(),
                rouletteService.getLastWinningColor(),
                rouletteService.isGameInProgress(),
                rouletteService.getGameMessage(),
                rouletteService.getTotalWinnings(),
                rouletteService.getBets(),
                rouletteService.getWheelNumbers(),
                rouletteService.getColors()
            );
            
            return ResponseEntity.ok(ApiResponse.success("Game reset successfully", gameState));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Failed to reset game: " + e.getMessage()));
        }
    }
}
