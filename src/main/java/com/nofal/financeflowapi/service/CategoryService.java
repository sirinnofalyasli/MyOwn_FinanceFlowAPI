package com.nofal.financeflowapi.service;

import com.nofal.financeflowapi.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();

    Category findById(Long id);

    void delete(Long id);

    Category update(Long id, Category category);
}
