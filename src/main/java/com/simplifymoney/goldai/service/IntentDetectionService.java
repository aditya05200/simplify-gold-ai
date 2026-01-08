package com.simplifymoney.goldai.service;

import org.springframework.stereotype.Service;

@Service
public class IntentDetectionService {

    public boolean isGoldRelated(String message) {
        if (message == null) return false;

        String msg = message.toLowerCase();

        return msg.contains("gold") ||
                msg.contains("invest in gold") ||
                msg.contains("digital gold") ||
                msg.contains("gold investment");
    }
}
