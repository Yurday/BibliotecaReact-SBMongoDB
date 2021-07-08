package com.example.biblioteca.usecases;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.mappers.ResourceMapper;
import com.example.biblioteca.repositories.ResourceRepository;
import com.example.biblioteca.usecases.usecasesinterfaces.ConsultResourceById;
import com.example.biblioteca.usecases.usecasesinterfaces.CreateResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseConsultResourceById implements ConsultResourceById {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    @Autowired
    public UseCaseConsultResourceById(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
            }

    @Override
    public Mono<ResourceDTO> findById(String id){
        return resourceRepository.findById(id).map(resourceMapper.mappResourceToDTO());
    }

}