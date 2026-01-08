package com.simplifymoney.goldai.repository;

import com.simplifymoney.goldai.entity.GoldTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoldTransactionRepository extends JpaRepository<GoldTransaction, Long> {
}
