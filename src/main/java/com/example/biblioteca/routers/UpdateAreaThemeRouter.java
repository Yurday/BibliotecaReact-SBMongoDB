package com.example.biblioteca.routers;

import com.example.biblioteca.DTOs.ResourceAreaThemeDTO;
import com.example.biblioteca.usecases.UseCaseUpdateAreaTheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateAreaThemeRouter {

    @Bean
    public RouterFunction<ServerResponse> updateAreaTheme(UseCaseUpdateAreaTheme useCaseUpdateAreaTheme){
        return route(PUT("/biblioteca/area/update").and(accept(MediaType.APPLICATION_JSON)),
                request->request.bodyToMono(ResourceAreaThemeDTO.class)
                        .flatMap(areaThemeDTO -> useCaseUpdateAreaTheme.apply(areaThemeDTO)
                                .flatMap(result->ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result)))
        );
    }
}