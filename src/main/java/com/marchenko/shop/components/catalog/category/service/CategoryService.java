package com.marchenko.shop.components.catalog.category.service;

import com.marchenko.shop.components.catalog.category.model.CategoryModel;
import com.marchenko.shop.components.catalog.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryModel> getAllCategories() {
        return (List<CategoryModel>) categoryRepository.findAll();
    }

    public Optional<CategoryModel> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
}
