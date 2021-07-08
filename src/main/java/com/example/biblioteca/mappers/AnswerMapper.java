package com.example.biblioteca.mappers;

import com.example.biblioteca.DTOs.ResourceAnswerDTO;
import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.collections.Resource;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class AnswerMapper {

    public Function<Resource, ResourceAnswerDTO> mappToResource() {
        return updateResource-> {
            var resource = new Resource();
            var answer = new ResourceAnswerDTO();
            if (updateResource.getStatus()){
                answer.setAnswer("El recurso está disponible");
                answer.setStatus(updateResource.getStatus());
                answer.setDate(updateResource.getDate());
                return answer;
            }else{
                answer.setAnswer("El recurso no está disponible");
                answer.setStatus(updateResource.getStatus());
                answer.setDate(updateResource.getDate());
                return answer;
            }
        };
    }

}
