package com.nofal.financeflowapi.service.impl;

import com.nofal.financeflowapi.entity.Budget;
import com.nofal.financeflowapi.repository.BudgetRepository;
import com.nofal.financeflowapi.service.BudgetService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetServiceImpl(BudgetRepository budgetRepository){
        this.budgetRepository = budgetRepository;
    }

    @Override
    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    @Override
    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    @Override
    public Budget findById(Long id) {
        return budgetRepository.findById(id).orElseThrow(() -> new RuntimeException("Budget not found"));
    }

    @Override
    public void delete(Long id) {
        budgetRepository.deleteById(id);
    }

    @Override
    public Budget update(Long id, Budget budget) {
        Budget existingBudget = budgetRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Budget not found"));
        existingBudget.setLimitAmount(budget.getLimitAmount());
        existingBudget.setMonth(budget.getMonth());
        existingBudget.setYear(budget.getYear());

        return budgetRepository.save(existingBudget);
    }
}
