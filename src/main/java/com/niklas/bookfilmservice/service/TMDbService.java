package com.niklas.bookfilmservice.service;

import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.util.*;

@Service
public class TMDbService {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Value("${tmdb.api.url}")
    private String apiUrl;

    private final WebClient.Builder webClientBuilder;

    public TMDbService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String searchMovieByTitle(String title) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl + "/search/movie")
                .queryParam("api_key", apiKey)
                .queryParam("query", title)
                .toUriString();

        return webClientBuilder.baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getMovieDetailsById(Long movieId) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl + "/movie/{movieId}")
                .queryParam("api_key", apiKey)
                .toUriString();

        return webClientBuilder.baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
