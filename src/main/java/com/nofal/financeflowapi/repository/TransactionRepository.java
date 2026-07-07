package com.nofal.financeflowapi.repository;

import com.nofal.financeflowapi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
