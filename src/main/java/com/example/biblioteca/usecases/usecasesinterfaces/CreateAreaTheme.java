package com.example.biblioteca.usecases.usecasesinterfaces;

import com.example.biblioteca.DTOs.ResourceAreaThemeDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateAreaTheme {
    public Mono<ResourceAreaThemeDTO> apply(ResourceAreaThemeDTO areaThemeDTO);
}
