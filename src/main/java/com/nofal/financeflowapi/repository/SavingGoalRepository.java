package com.nofal.financeflowapi.repository;

import com.nofal.financeflowapi.entity.SavingGoal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingGoalRepository extends JpaRepository<SavingGoal, Long> {
}
