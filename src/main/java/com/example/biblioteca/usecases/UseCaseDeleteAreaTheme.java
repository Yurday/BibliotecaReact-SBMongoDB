package com.example.biblioteca.usecases;

import com.example.biblioteca.mappers.ResourceAreaThemeMapper;
import com.example.biblioteca.repositories.ResourceAreaThemeRepository;
import com.example.biblioteca.usecases.usecasesinterfaces.DeleteAreaTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.swing.*;

@Service
public class UseCaseDeleteAreaTheme implements DeleteAreaTheme {
    private final ResourceAreaThemeRepository resourceAreaThemeRepository;
    private final ResourceAreaThemeMapper resourceAreaThemeMapper;

    @Autowired

    public UseCaseDeleteAreaTheme(ResourceAreaThemeRepository resourceAreaThemeRepository, ResourceAreaThemeMapper resourceAreaThemeMapper) {
        this.resourceAreaThemeRepository = resourceAreaThemeRepository;
        this.resourceAreaThemeMapper = resourceAreaThemeMapper;
    }

    @Override
    public Mono<Void> deleteFindById(String id){
        return resourceAreaThemeRepository.deleteById(id);
    }
}
