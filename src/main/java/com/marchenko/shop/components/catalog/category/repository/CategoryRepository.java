package com.marchenko.shop.components.catalog.category.repository;

import com.marchenko.shop.components.catalog.category.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryModel, Long> {
}
