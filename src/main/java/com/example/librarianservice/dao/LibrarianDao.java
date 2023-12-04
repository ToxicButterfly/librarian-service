package com.example.librarianservice.dao;

import com.example.librarianservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibrarianDao extends JpaRepository<Book, Integer> {
    public Optional<Book> findBookByISBN(String isbn);
}
