package com.example.biblioteca.usecases;

import com.example.biblioteca.DTOs.ResourceAreaThemeDTO;
import com.example.biblioteca.mappers.ResourceAreaThemeMapper;
import com.example.biblioteca.repositories.ResourceAreaThemeRepository;
import com.example.biblioteca.usecases.usecasesinterfaces.UpdateAreaTheme;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UseCaseUpdateAreaTheme implements UpdateAreaTheme {
    private final ResourceAreaThemeRepository resourceAreaThemeRepository;
    private final ResourceAreaThemeMapper resourceAreaThemeMapper;

    public UseCaseUpdateAreaTheme(ResourceAreaThemeRepository resourceAreaThemeRepository, ResourceAreaThemeMapper resourceAreaThemeMapper) {
        this.resourceAreaThemeRepository = resourceAreaThemeRepository;
        this.resourceAreaThemeMapper = resourceAreaThemeMapper;
    }

    @Override
    public Mono<ResourceAreaThemeDTO> apply(ResourceAreaThemeDTO resourceAreaThemeDTO){
        return resourceAreaThemeRepository.save(resourceAreaThemeMapper.mapperToAreaTheme(resourceAreaThemeDTO.getId()).apply(resourceAreaThemeDTO)).map(resourceAreaThemeMapper.mappAreaThemeToDTO());
    }
}
