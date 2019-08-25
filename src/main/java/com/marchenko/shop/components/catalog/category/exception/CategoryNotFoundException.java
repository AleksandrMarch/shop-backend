package com.marchenko.shop.components.catalog.category.exception;

public class CategoryNotFoundException extends Exception{
    public CategoryNotFoundException(String message) {
        super (message);
    }

    public CategoryNotFoundException() {}
}
