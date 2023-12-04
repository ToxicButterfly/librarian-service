package com.example.librarianservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("LIBRARY-SERVICE")
public interface FeignInterface {

    @PostMapping("library/addBook/{id}")
    public ResponseEntity<String> addBook(@PathVariable int id);

    @DeleteMapping("library/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id);
}
