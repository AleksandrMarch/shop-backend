package com.marchenko.shop.components.images.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

interface ImageStorageService {

    public void store(MultipartFile file, Long targetId);

    Resource loadAsResource(String filename);

    void init();
}
