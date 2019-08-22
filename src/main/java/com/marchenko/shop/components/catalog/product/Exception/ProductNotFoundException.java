package com.marchenko.shop.components.catalog.product.Exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super (message);
    }

    public ProductNotFoundException() {}
}
