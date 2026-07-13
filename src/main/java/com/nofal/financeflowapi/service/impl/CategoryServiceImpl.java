package com.nofal.financeflowapi.service.impl;

import com.nofal.financeflowapi.entity.Category;
import com.nofal.financeflowapi.repository.CategoryRepository;
import com.nofal.financeflowapi.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category){
        return categoryRepository.save(category);
    }
    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public void delete(Long id){
        categoryRepository.deleteById(id);
    }
    @Override
    public Category update(Long id, Category category){
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Category not found"));
        existingCategory.setName(category.getName());
        existingCategory.setType(category.getType());


        return categoryRepository.save(existingCategory);
    }

}
