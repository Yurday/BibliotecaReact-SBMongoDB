package com.example.biblioteca.usecases.usecasesinterfaces;

import com.example.biblioteca.DTOs.ResourceDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface ConsultResourceById {
    public Mono<ResourceDTO> findById(String id);
}
