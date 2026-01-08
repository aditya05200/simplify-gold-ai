package com.simplifymoney.goldai.controller;

import com.simplifymoney.goldai.service.GoldPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/gold")
public class GoldPurchaseController {

    @Autowired
    private GoldPurchaseService goldPurchaseService;

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseGold(@RequestBody Map<String, Object> request) {

        String userId = request.get("userId").toString();
        double amount = Double.parseDouble(request.get("amount").toString());

        return ResponseEntity.ok(
                goldPurchaseService.purchaseGold(userId, amount)
        );
    }
}
