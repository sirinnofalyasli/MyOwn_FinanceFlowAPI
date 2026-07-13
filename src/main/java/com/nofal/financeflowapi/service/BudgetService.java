package com.nofal.financeflowapi.service;

import com.nofal.financeflowapi.entity.Budget;

import java.util.List;

public interface BudgetService {

    Budget save(Budget budget);

    List<Budget> findAll();

    Budget findById(Long id);

    void delete(Long id);

    Budget update(Long id, Budget budget);
}
