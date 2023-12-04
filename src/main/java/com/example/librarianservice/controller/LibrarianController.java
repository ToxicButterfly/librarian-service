package com.example.librarianservice.controller;

import com.example.librarianservice.model.Book;
import com.example.librarianservice.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("book")
public class LibrarianController {

    @Autowired
    LibrarianService librarianService;

    @GetMapping("getAll")
    public ResponseEntity<List<Book>> getAllBooks() {
        return librarianService.getAllBooks();
    }

    @GetMapping("get/ID/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return librarianService.getBookById(id);
    }

    @GetMapping("get/ISBN/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        return librarianService.getBookByIsbn(isbn);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("add")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        return librarianService.addBook(book);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("update/{id}")
    public ResponseEntity<String> addOrUpdateBook(@RequestBody Book book, @PathVariable int id) {
        return librarianService.addOrUpdateBook(book, id);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return librarianService.deleteBook(id);
    }

    @GetMapping("unsecured")
    public String unsecuredData() {
        return "Unsecured data";
    }

    @GetMapping("secured")
    public String securedData() {
        return "Secured data";
    }

    @GetMapping("admin")
    public String adminData() {
        return "Admin data";
    }

    @GetMapping("info")
    public String userData(Principal principal) {
        return principal.getName();
    }
}
