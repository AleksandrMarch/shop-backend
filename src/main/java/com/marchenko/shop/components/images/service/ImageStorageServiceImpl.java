package com.marchenko.shop.components.images.service;

import com.marchenko.shop.components.images.ImageTypes;
import com.marchenko.shop.components.images.model.ImageModel;
import com.marchenko.shop.components.images.repository.ImageRepository;
import com.marchenko.shop.core.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImageStorageServiceImpl implements ImageStorageService {

    private ImageRepository imageRepository;
    private final Path rootLocation;

    @Autowired
    public ImageStorageServiceImpl(
            StorageProperties storageProperties,
            ImageRepository imageRepository
    ) {
        this.imageRepository = imageRepository;
        this.rootLocation = Paths.get(storageProperties.getLocation());
    }

    @Override
    public void store(MultipartFile file, Long targetId) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (Files.exists(this.rootLocation)) {
                System.out.println("test");
            }
            if (file.isEmpty()) {
//                throw new StorageException("Failed to store empty file " + filename);
            }
            if (filename.contains("..")) {
                return;
                // This is a security check
//                throw new StorageException(
//                        "Cannot store file with relative path outside current directory "
//                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(filename),
                        StandardCopyOption.REPLACE_EXISTING);

                imageRepository.save(getNewImageModel(file.getOriginalFilename(), targetId));
            }
        }
        catch (IOException e) {
            e.getMessage();
//            throw new StorageException("Failed to store file " + filename, e);
        }
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
//                throw new StorageFileNotFoundException(
//                        "Could not read file: " + filename);

            }
        }
        catch (Exception e) {
//        catch (MalformedURLException e) {
//            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
        return null;
    }

    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e) {
            System.out.println(e.toString());
//            throw new StorageException("Could not initialize storage", e);
        }
    }

    private Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    private ImageModel getNewImageModel(String title, Long targetId) {
        ImageModel imageModel = new ImageModel();
        imageModel.setImageType(ImageTypes.PRODUCT.toString());
        imageModel.setTitle(title);
        imageModel.setTargetId(targetId);
        return imageModel;
    }
}
