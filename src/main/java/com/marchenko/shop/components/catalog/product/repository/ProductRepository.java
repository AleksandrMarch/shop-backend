package com.marchenko.shop.components.catalog.product.repository;

import com.marchenko.shop.components.catalog.product.model.ProductModel;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductModel, Long> {
}
