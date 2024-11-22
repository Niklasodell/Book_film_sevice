package com.niklas.bookfilmservice.controller;

import com.niklas.bookfilmservice.model.Film;
import com.niklas.bookfilmservice.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }

    @PostMapping
    public ResponseEntity<Film> createFilm(@RequestBody Film film) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.saveFilm(film));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film filmDetails) {
        Film film = filmService.getFilmById(id);
        film.setTitle(filmDetails.getTitle());
        film.setDirector(filmDetails.getDirector());
        film.setGenre(filmDetails.getGenre());
        film.setDescription(filmDetails.getDescription());
        film.setReleaseYear(filmDetails.getReleaseYear());
        film.setRating(filmDetails.getRating());
        return ResponseEntity.ok(filmService.saveFilm(film));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
