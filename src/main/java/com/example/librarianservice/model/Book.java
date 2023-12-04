package com.example.librarianservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique=true)
    private String ISBN;
    private String title;
    private String genre;
    private String description;
    private String author;
}
