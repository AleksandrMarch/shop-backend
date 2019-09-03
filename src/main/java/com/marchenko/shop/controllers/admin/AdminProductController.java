package com.marchenko.shop.controllers.admin;

import com.marchenko.shop.components.catalog.product.model.ProductModel;
import com.marchenko.shop.components.catalog.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/admin")
public class AdminProductController {

    private ProductService productService;

    @Autowired
    public AdminProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/product")
    public String saveProduct(@RequestBody ProductModel productModel) {
        productService.saveProduct(productModel);
        return productModel.getId().toString();
    }

    @GetMapping(path = "/product")
    public List<ProductModel> getProducts(@RequestParam(required = false) Long productId) {
        return productService.getAllProducts();
    }

}
