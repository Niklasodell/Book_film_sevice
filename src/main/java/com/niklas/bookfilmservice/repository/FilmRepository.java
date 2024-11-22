package com.niklas.bookfilmservice.repository;

import com.niklas.bookfilmservice.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByTitleContaining(String title);
    List<Film> findByGenre(String genre);
}

