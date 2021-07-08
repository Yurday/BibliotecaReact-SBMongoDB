package com.example.biblioteca.mappers;

import com.example.biblioteca.DTOs.ResourceAreaThemeDTO;
import com.example.biblioteca.collections.ResourceAreaTheme;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class ResourceAreaThemeMapper {

    public Function<ResourceAreaThemeDTO, ResourceAreaTheme> mapperToAreaTheme(String id){
        return updateAreaTheme ->{
            var areaTheme = new ResourceAreaTheme();
            areaTheme.setId(id);
            areaTheme.setName(updateAreaTheme.getName());

            return areaTheme;
        };
    }

    public Function<ResourceAreaTheme, ResourceAreaThemeDTO> mappAreaThemeToDTO(){
        return entity ->new ResourceAreaThemeDTO(entity.getId(),entity.getName());
    }
}
