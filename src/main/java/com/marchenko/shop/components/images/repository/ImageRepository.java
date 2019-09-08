package com.marchenko.shop.components.images.repository;

import com.marchenko.shop.components.images.model.ImageModel;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository <ImageModel, Long> { }
