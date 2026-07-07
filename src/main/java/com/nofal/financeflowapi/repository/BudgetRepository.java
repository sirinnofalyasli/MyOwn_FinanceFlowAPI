package com.nofal.financeflowapi.repository;

import com.nofal.financeflowapi.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
