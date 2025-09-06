package com.example.gambling.web;

import com.example.gambling.dto.ApiResponse;
import com.example.gambling.dto.GameStateDto;
import com.example.gambling.service.SlotMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slot")
public class SlotMachineController {

    @Autowired
    private SlotMachineService slotMachineService;

    @GetMapping("/state")
    public ApiResponse<GameStateDto> getState() {
        return slotMachineService.getState();
    }

    @PostMapping("/bet")
    public ApiResponse<GameStateDto> setBet(@RequestParam int amount) {
        return slotMachineService.setBet(amount);
    }

    @PostMapping("/spin")
    public ApiResponse<GameStateDto> spin() {
        return slotMachineService.spin();
    }

    @PostMapping("/reset")
    public ApiResponse<GameStateDto> reset() {
        return slotMachineService.reset();
    }
}
