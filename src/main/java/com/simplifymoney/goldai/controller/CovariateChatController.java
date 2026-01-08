package com.simplifymoney.goldai.controller;

import com.simplifymoney.goldai.service.CovariateAIService;
import com.simplifymoney.goldai.service.IntentDetectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/covariate")
public class CovariateChatController {

    @Autowired
    private IntentDetectionService intentDetectionService;

    @Autowired
    private CovariateAIService covariateAIService;

    @PostMapping("/chat")
    public ResponseEntity<?> chat(@RequestBody Map<String, String> request) {

        String message = request.get("message");

        if (intentDetectionService.isGoldRelated(message)) {
            return ResponseEntity.ok(
                    covariateAIService.goldInvestmentResponse()
            );
        }

        return ResponseEntity.ok(
                covariateAIService.defaultResponse()
        );
    }
}
