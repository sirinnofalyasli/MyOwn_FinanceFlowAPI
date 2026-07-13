package com.nofal.financeflowapi.controller;

import com.nofal.financeflowapi.entity.Budget;
import com.nofal.financeflowapi.service.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    private final BudgetService budgetService;
    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping
    public ResponseEntity<List<Budget>> findAllBudgets(){
        return ResponseEntity.ok(budgetService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Budget> findById(@PathVariable Long id){
        return ResponseEntity.ok(budgetService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget){
        Budget savedBudget = budgetService.save(budget);
        URI location = URI.create("/budget/" + savedBudget.getId());
        return ResponseEntity.created(location).body(savedBudget);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        budgetService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Budget> update(@PathVariable Long id, @RequestBody Budget budget){
        Budget updatedBudget = budgetService.update(id, budget);
        return ResponseEntity.ok(updatedBudget);
    }
}
