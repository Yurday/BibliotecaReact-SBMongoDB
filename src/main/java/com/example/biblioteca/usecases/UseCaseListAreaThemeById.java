package com.example.biblioteca.usecases;

import com.example.biblioteca.DTOs.ResourceAreaThemeDTO;
import com.example.biblioteca.mappers.ResourceAreaThemeMapper;
import com.example.biblioteca.repositories.ResourceAreaThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class UseCaseListAreaThemeById implements Function<String, Mono<ResourceAreaThemeDTO>> {
    private final ResourceAreaThemeRepository resourceAreaThemeRepository;
    private final ResourceAreaThemeMapper resourceAreaThemeMapper;

    @Autowired
    public UseCaseListAreaThemeById(ResourceAreaThemeRepository resourceAreaThemeRepository, ResourceAreaThemeMapper resourceAreaThemeMapper) {
        this.resourceAreaThemeRepository = resourceAreaThemeRepository;
        this.resourceAreaThemeMapper = resourceAreaThemeMapper;
    }

    @Override
    public Mono<ResourceAreaThemeDTO> apply(String id) {
        return resourceAreaThemeRepository.findById(id).map(resourceAreaThemeMapper.mappAreaThemeToDTO());
}
}
