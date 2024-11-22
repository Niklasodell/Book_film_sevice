package com.niklas.bookfilmservice.controller;

import com.niklas.bookfilmservice.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/google-books")
public class GoogleBooksController {

    @Autowired
    private GoogleBooksService googleBooksService;

    @GetMapping("/search")
    public ResponseEntity<String> searchBook(@RequestParam String title) {
        String response = googleBooksService.searchBookByTitle(title);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<String> getBookDetails(@PathVariable String id) {
        String response = googleBooksService.getBookDetailsById(id);
        return ResponseEntity.ok(response);
    }
}

