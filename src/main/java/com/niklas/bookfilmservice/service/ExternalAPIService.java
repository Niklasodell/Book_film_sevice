package com.niklas.bookfilmservice.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

@Service
public class ExternalAPIService {
    @Autowired
    private RestTemplate restTemplate;

    public String fetchBooksByTitle(String title) {
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + title;
        return restTemplate.getForObject(url, String.class);
    }
}

