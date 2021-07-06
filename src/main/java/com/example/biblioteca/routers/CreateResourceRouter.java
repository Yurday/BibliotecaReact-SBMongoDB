package com.example.biblioteca.routers;

import com.example.biblioteca.DTOs.ResourceDTO;
import com.example.biblioteca.usecases.UseCaseCreateResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class CreateResourceRouter {

    @Bean
    public RouterFunction<ServerResponse> createResource(UseCaseCreateResource useCaseCreateResource){
        return route(POST("biblioteca/resource/create").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ResourceDTO.class)
                        .flatMap(resourceDTO -> UseCaseCreateResource.apply(resourceDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
