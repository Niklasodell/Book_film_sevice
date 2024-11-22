package com.niklas.bookfilmservice.service;

import com.niklas.bookfilmservice.model.Film;
import com.niklas.bookfilmservice.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film getFilmById(Long id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found"));
    }

    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

    public List<Film> searchFilmsByTitle(String title) {
        return filmRepository.findByTitleContaining(title);
    }

    public List<Film> searchFilmsByGenre(String genre) {
        return filmRepository.findByGenre(genre);
    }
}

