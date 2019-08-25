package com.marchenko.shop.controllers;

import com.marchenko.shop.components.catalog.product.exception.ProductNotFoundException;
import com.marchenko.shop.components.catalog.product.model.ProductModel;
import com.marchenko.shop.components.catalog.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public ProductModel getAllCategories(@PathVariable Long id) throws Exception {
        return productService.getProductById(id).orElseThrow(
                ProductNotFoundException::new
        );
    }

}