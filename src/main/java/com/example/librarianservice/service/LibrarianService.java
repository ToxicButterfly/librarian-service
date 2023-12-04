package com.example.librarianservice.service;

import com.example.librarianservice.dao.LibrarianDao;
import com.example.librarianservice.feign.FeignInterface;
import com.example.librarianservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrarianService {

    @Autowired
    LibrarianDao librarianDao;
    @Autowired
    FeignInterface feignInterface;

    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(librarianDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Book> getBookById(int id) {
        try {
            return new ResponseEntity<>(librarianDao.findById(id).get(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Book(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Book> getBookByIsbn(String isbn) {
        try {
            return new ResponseEntity<>(librarianDao.findBookByISBN(isbn).get(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new Book(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> addBook(Book book) {
        if(librarianDao.findBookByISBN(book.getISBN()).isPresent()) {
            return new ResponseEntity<>("There's already book with this ISBN", HttpStatus.BAD_REQUEST);
        }
        else {
            librarianDao.save(book);
            feignInterface.addBook(librarianDao.findBookByISBN(book.getISBN()).get().getId());
        }
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> addOrUpdateBook(Book book, int id) {
        if(librarianDao.findById(id).isPresent()) {
            book.setId(id);
            librarianDao.save(book);
        }
        else {
            librarianDao.save(book);
            feignInterface.addBook(id);
        }
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteBook(int id) {
        if(librarianDao.findById(id).isPresent()) {
            librarianDao.deleteById(id);
            feignInterface.deleteBook(id);
            return new ResponseEntity<>("Book was successfully deleted",HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Book was not found", HttpStatus.NOT_FOUND);
    }
}
