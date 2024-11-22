package com.niklas.bookfilmservice.repository;

import org.springframework.stereotype.*;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByTitleContaining(String title);
    List<Film> findByGenre(String genre);
}

