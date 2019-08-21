package com.marchenko.shop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.marchenko.shop.components.catalog.category.model.CategoryModel;

@RestController
public class CategoryController {

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public CategoryModel getAllCategories(@RequestParam Double id) {
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(123L);
        categoryModel.setParentId(321L);
        categoryModel.setTitle("product-test");
        categoryModel.setDescription("bitch");

        return categoryModel;
    }

}