package com.niklas.bookfilmservice.controller;

import com.niklas.bookfilmservice.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tmdb")
public class TMDbController {

    @Autowired
    private TMDbService tmdbService;

    @GetMapping("/search")
    public ResponseEntity<String> searchMovie(@RequestParam String title) {
        String response = tmdbService.searchMovieByTitle(title);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<String> getMovieDetails(@PathVariable Long id) {
        String response = tmdbService.getMovieDetailsById(id);
        return ResponseEntity.ok(response);
    }
}

