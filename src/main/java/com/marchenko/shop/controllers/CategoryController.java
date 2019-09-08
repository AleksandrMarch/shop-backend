package com.marchenko.shop.controllers;

import com.marchenko.shop.components.catalog.category.exception.CategoryNotFoundException;
import com.marchenko.shop.components.catalog.category.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import com.marchenko.shop.components.catalog.category.model.CategoryModel;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryModel> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "/{id}")
    public CategoryModel getCategoryById(@PathVariable Long id)
            throws CategoryNotFoundException {
        return categoryService
                .getCategoryById(id)
                .orElseThrow(CategoryNotFoundException::new);
    }

}