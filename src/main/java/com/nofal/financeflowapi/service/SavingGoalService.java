package com.nofal.financeflowapi.service;

import com.nofal.financeflowapi.entity.SavingGoal;

import java.util.List;

public interface SavingGoalService {

    SavingGoal save(SavingGoal savingGoal);

    List<SavingGoal> findAll();

    SavingGoal findById(Long id);

    void delete(Long id);

    SavingGoal update(Long id, SavingGoal savingGoal);
}
