package com.niklas.bookfilmservice.repository;

import org.springframework.stereotype.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContaining(String title);
    List<Book> findByGenre(String genre);
}

