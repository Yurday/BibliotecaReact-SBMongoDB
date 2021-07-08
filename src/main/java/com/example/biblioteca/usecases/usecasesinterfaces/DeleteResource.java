package com.example.biblioteca.usecases.usecasesinterfaces;

import reactor.core.publisher.Mono;

@FunctionalInterface
public interface DeleteResource {
    public Mono<Void> deleteFindById(String id);
}
