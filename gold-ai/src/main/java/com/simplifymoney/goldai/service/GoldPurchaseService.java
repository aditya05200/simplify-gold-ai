package com.simplifymoney.goldai.service;

import com.simplifymoney.goldai.entity.GoldTransaction;
import com.simplifymoney.goldai.entity.User;
import com.simplifymoney.goldai.repository.GoldTransactionRepository;
import com.simplifymoney.goldai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class GoldPurchaseService {

    private static final double GOLD_PRICE_PER_GRAM = 6000.0;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GoldTransactionRepository transactionRepository;

    public Map<String, Object> purchaseGold(String userId, double amount) {

        // Step 1: Ensure user exists
        userRepository.findByUserId(userId)
                .orElseGet(() -> {
                    User user = new User();
                    user.setUserId(userId);
                    return userRepository.save(user);
                });

        // Step 2: Calculate gold
        double goldGrams = amount / GOLD_PRICE_PER_GRAM;

        // Step 3: Save transaction
        GoldTransaction txn = new GoldTransaction();
        txn.setUserId(userId);
        txn.setAmount(amount);
        txn.setGoldGrams(goldGrams);
        txn.setStatus("SUCCESS");

        transactionRepository.save(txn);

        // Step 4: Response
        Map<String, Object> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("message",
                "Congratulations! You have successfully purchased " +
                        String.format("%.2f", goldGrams) + " grams of digital gold.");
        response.put("transactionId", txn.getId());

        return response;
    }
}
