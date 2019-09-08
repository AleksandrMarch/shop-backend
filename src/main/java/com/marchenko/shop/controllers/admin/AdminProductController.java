package com.marchenko.shop.controllers.admin;

import com.marchenko.shop.components.catalog.product.exception.ProductNotFoundException;
import com.marchenko.shop.components.catalog.product.model.ProductModel;
import com.marchenko.shop.components.catalog.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/admin/products")
public class AdminProductController {

    private ProductService productService;

    @Autowired
    public AdminProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public String saveProduct(@RequestBody ProductModel productModel) {
        productService.saveProduct(productModel);
        return productModel.getId().toString();
    }

    @PatchMapping
    public String updateProduct(@RequestBody ProductModel productModel) {
        productService.saveProduct(productModel);
        return "ok";
    }

    @GetMapping(value = "/{id}")
    public ProductModel getProduct(@PathVariable(name = "id") Long id)
            throws ProductNotFoundException {
        return productService.getProductById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    @GetMapping
    public List<ProductModel> getProducts() {
        return productService.getAllProducts();
    }

}
