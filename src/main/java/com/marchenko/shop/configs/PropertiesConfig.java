package com.marchenko.shop.configs;

import com.marchenko.shop.components.images.service.ImageStorageServiceImpl;
import com.marchenko.shop.core.StorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StorageProperties.class)
public class PropertiesConfig {

    @Bean
    @Autowired
    CommandLineRunner init(ImageStorageServiceImpl imageStorageService) {
        return (args) -> {
            imageStorageService.init();
        };
    }
}
