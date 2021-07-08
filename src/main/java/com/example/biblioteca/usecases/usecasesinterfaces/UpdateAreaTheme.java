package com.example.biblioteca.usecases.usecasesinterfaces;

import com.example.biblioteca.DTOs.ResourceAreaThemeDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface UpdateAreaTheme {
    public Mono<ResourceAreaThemeDTO> apply(ResourceAreaThemeDTO resourceAreaThemeDTO);
}
