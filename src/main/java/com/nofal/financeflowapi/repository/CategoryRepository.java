package com.nofal.financeflowapi.repository;

import com.nofal.financeflowapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
