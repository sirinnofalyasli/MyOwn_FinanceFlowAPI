package com.nofal.financeflowapi.service;

import com.nofal.financeflowapi.entity.Transaction;
import com.nofal.financeflowapi.entity.User;

import java.util.List;

public interface TransactionService {

    Transaction save(Transaction transaction);

    List<Transaction> findAll();

    Transaction findById(Long id);

    void delete(Long id);

    Transaction update(Long id, Transaction transaction);
}
