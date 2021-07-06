package com.example.biblioteca.usecases;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.mappers.ResourceMapper;
import com.example.biblioteca.repositories.ResourceRepository;
import com.example.biblioteca.usecases.usecasesinterfaces.SaveResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCreateResource implements SaveResource {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired

    public UseCaseCreateResource(ResourceMapper resourceMapper, ResourceRepository resourceRepository) {
        this.resourceMapper = resourceMapper;
        this.resourceRepository = resourceRepository;
    }

    @Override
    public Mono<ResourceDTO> apply(ResourceDTO resourceDTO) {
        var resource = resourceRepository.save(resourceMapper.mapperToResource(null).apply(resourceDTO)).map(resourceMapper.mappResourceToDTO());
        return resource;
    }

}