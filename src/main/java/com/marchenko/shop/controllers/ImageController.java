package com.marchenko.shop.controllers;

import com.marchenko.shop.components.images.service.ImageStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

    private final ImageStorageServiceImpl imageStorageService;

    @Autowired
    public ImageController(ImageStorageServiceImpl imageStorageService) {
        this.imageStorageService = imageStorageService;
    }

    @GetMapping
    public Resource getTestImage(@RequestParam(name = "image") String filename) {
        return imageStorageService.loadAsResource(filename);
    }

    @PostMapping
    public String saveImage(@RequestParam(name = "image") MultipartFile file) {
        imageStorageService.store(file);
        return "ok";
    }

}
