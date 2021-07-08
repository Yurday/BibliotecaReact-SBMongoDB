package com.example.biblioteca.usecases;

import com.example.biblioteca.DTOs.ResourceAreaThemeDTO;
import com.example.biblioteca.mappers.ResourceAreaThemeMapper;
import com.example.biblioteca.repositories.ResourceAreaThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
public class UseCaseListAreasTheme implements Supplier<Flux<ResourceAreaThemeDTO>> {
    private final ResourceAreaThemeRepository resourceAreaThemeRepository;
    private final ResourceAreaThemeMapper resourceAreaThemeMapper;

    @Autowired
    public UseCaseListAreasTheme(ResourceAreaThemeRepository resourceAreaThemeRepository, ResourceAreaThemeMapper resourceAreaThemeMapper) {
        this.resourceAreaThemeRepository = resourceAreaThemeRepository;
        this.resourceAreaThemeMapper = resourceAreaThemeMapper;
    }

    @Override
    public Flux<ResourceAreaThemeDTO> get() {
        return resourceAreaThemeRepository.findAll().map(resourceAreaThemeMapper.mappAreaThemeToDTO());
    }
}
