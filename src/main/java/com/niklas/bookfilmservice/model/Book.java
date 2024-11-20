package com.niklas.bookfilmservice.model;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String genre;
    private String description;
    private int publicationYear;
    private double rating;

    // Getters, Setters och Constructors (Lombok kan användas)
}
