package com.example.biblioteca.repositories;

import com.example.biblioteca.collections.Resource;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ResourceRepository extends ReactiveMongoRepository<Resource, String> {

    @Transactional(readOnly = true)
    Optional<List<Resource>> findByAreaThemeId(String areaThemeId);

    @Transactional(readOnly = true)
    Optional<List<Resource>> findByResourceType(String resourceType);

    @Transactional(readOnly = true)
    Optional<List<Resource>> findByAreaThemeIdAndResourceType(String areaThemeId, String resourceType);
}