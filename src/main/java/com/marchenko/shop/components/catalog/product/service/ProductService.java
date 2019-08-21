package com.marchenko.shop.components.catalog.product.service;

import com.marchenko.shop.components.catalog.product.model.ProductModel;
import com.marchenko.shop.components.catalog.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(ProductModel productModel) {
        productRepository.save(productModel);
    }

    public List<ProductModel> getAllProducts() {
        return (List<ProductModel>) productRepository.findAll();
    }

    public Optional<ProductModel> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

}
