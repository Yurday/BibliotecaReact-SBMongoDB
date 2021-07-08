package com.example.biblioteca.mappers;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.collections.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

@Component
public class ResourceMapper {

    public Function<ResourceDTO, Resource> mapperToResource(String id) {
        return updateResource -> {
            var resource = new Resource();
            resource.setId(id);
            resource.setAreaThemeId(updateResource.getAreaThemeId());
            resource.setResourceType(updateResource.getResourceType());
            resource.setStatus(updateResource.getStatus());
            resource.setName(updateResource.getName());
            resource.setDate(updateResource.getDate());
            resource.setDate(updateResource.getDate());
            return resource;
        };
    }

    public Function<Resource, ResourceDTO> mappResourceToDTO() {
        return entity -> new ResourceDTO(entity.getId(), entity.getAreaThemeId(), entity.getResourceType(), entity.getStatus(), entity.getName(), entity.getDate());
    }
}