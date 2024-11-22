package com.niklas.bookfilmservice.repository;

import com.niklas.bookfilmservice.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByGenre(String genre);
}

