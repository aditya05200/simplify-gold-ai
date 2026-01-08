package com.simplifymoney.goldai.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "gold_transactions")
public class GoldTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private double amount;
    private double goldGrams;
    private String status;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters and setters
    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getGoldGrams() {
        return goldGrams;
    }

    public void setGoldGrams(double goldGrams) {
        this.goldGrams = goldGrams;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
