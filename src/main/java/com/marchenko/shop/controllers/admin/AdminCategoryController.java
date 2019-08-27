package com.marchenko.shop.controllers.admin;

import com.marchenko.shop.components.catalog.category.model.CategoryModel;
import com.marchenko.shop.components.catalog.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class AdminCategoryController {

    private CategoryService categoryService;

    @Autowired
    public AdminCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public String saveCategory(CategoryModel categoryModel) {
        categoryService.saveCategory(categoryModel);
        return "ok";
    }
}
