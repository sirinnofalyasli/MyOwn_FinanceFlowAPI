package com.nofal.financeflowapi.controller;


import com.nofal.financeflowapi.entity.Transaction;
import com.nofal.financeflowapi.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transactions")


public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions(){
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Long id){
        return ResponseEntity.ok(transactionService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Transaction> saveTransaction(@RequestBody Transaction transaction){
        Transaction savedTransaction = transactionService.save(transaction);
        URI location = URI.create("/transactions/" + savedTransaction.getId());
        return ResponseEntity.created(location).body(savedTransaction);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id){
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction){
        Transaction updatedTransaction = transactionService.update(id, transaction);
        return ResponseEntity.ok(updatedTransaction);
    }


}


