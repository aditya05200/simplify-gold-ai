package com.simplifymoney.goldai.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CovariateAIService {

    public Map<String, Object> goldInvestmentResponse() {

        Map<String, Object> response = new HashMap<>();

        response.put("intent", "GOLD_INVESTMENT");
        response.put("stage", "EDUCATION");

        response.put("reply",
                "Digital gold is one of the easiest and safest ways to start investing in gold. " +
                        "You can begin with just ₹10, get 99.99% pure gold, avoid storage hassles, " +
                        "and buy or sell anytime with instant liquidity.");

        response.put("nudge", "Would you like to buy digital gold now?");
        response.put("actions", List.of("BUY_DIGITAL_GOLD", "NOT_NOW"));

        return response;
    }

    public Map<String, Object> defaultResponse() {
        Map<String, Object> response = new HashMap<>();
        response.put("intent", "OTHER");
        response.put("reply",
                "I can help you with investments like gold, mutual funds, and stocks. " +
                        "Try asking about gold investments.");
        return response;
    }
}
