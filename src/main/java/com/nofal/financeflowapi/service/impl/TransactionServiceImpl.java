package com.nofal.financeflowapi.service.impl;

import com.nofal.financeflowapi.entity.Transaction;
import com.nofal.financeflowapi.repository.TransactionRepository;
import com.nofal.financeflowapi.service.TransactionService;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;

    }
    @Override
    public Transaction save(Transaction transaction) {

        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findAll(){
        return transactionRepository.findAll();
    }
    @Override
    public Transaction findById(Long id){
        return transactionRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
    @Override
    public void delete(Long id){
        transactionRepository.deleteById(id);
    }
    @Override
    public Transaction update(Long id, Transaction transaction){
        Transaction existingTransaction =
                transactionRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Transaction not found"));
                existingTransaction.setAmount(transaction.getAmount());
                existingTransaction.setDescription(transaction.getDescription());
                existingTransaction.setTransactionDate(transaction.getTransactionDate());
                existingTransaction.setType(transaction.getType());

        return transactionRepository.save(existingTransaction);
    }



}
