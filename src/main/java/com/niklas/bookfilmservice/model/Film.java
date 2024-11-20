package com.niklas.bookfilmservice.model;

import jakarta.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String director;
    private String genre;
    private String description;
    private int releaseYear;
    private double rating;

    // Getters, Setters och Constructors
}

