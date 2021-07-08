package com.example.biblioteca.usecases;

import com.example.biblioteca.DTOs.ResourceAreaThemeDTO;
import com.example.biblioteca.mappers.ResourceAreaThemeMapper;
import com.example.biblioteca.repositories.ResourceAreaThemeRepository;
import com.example.biblioteca.usecases.usecasesinterfaces.CreateAreaTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCreateAreaTheme implements CreateAreaTheme {

    private final ResourceAreaThemeRepository resourceAreaThemeRepository;
    private final ResourceAreaThemeMapper resourceAreaThemeMapper;

    @Autowired

    public UseCaseCreateAreaTheme(ResourceAreaThemeRepository resourceAreaThemeRepository, ResourceAreaThemeMapper resourceAreaThemeMapper) {
        this.resourceAreaThemeRepository = resourceAreaThemeRepository;
        this.resourceAreaThemeMapper = resourceAreaThemeMapper;
    }

    @Override
    public Mono<ResourceAreaThemeDTO> apply(ResourceAreaThemeDTO resourceAreaThemeDTO) {
        var areaTheme = resourceAreaThemeRepository.save(resourceAreaThemeMapper.mapperToAreaTheme(null).apply(resourceAreaThemeDTO)).map(resourceAreaThemeMapper.mappAreaThemeToDTO());
        return areaTheme;
    }
}
