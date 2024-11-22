package com.niklas.bookfilmservice.service;

import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.util.*;

@Service
public class GoogleBooksService {

    @Value("${google.books.api.key}")
    private String apiKey;

    @Value("${google.books.api.url}")
    private String apiUrl;

    private final WebClient.Builder webClientBuilder;

    public GoogleBooksService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String searchBookByTitle(String title) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("key", apiKey)
                .queryParam("q", title)
                .toUriString();

        return webClientBuilder.baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getBookDetailsById(String bookId) {
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl + "/{bookId}")
                .queryParam("key", apiKey)
                .toUriString();

        return webClientBuilder.baseUrl(url)
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
