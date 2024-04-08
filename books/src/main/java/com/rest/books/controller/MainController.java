package com.rest.books.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.books.entity.Books;
import com.rest.books.repository.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final BookRepo repo;

    @SneakyThrows
    @GetMapping("/all")
    public List<Books> getAllBooks() {
        return repo.findAll();
    }

    @GetMapping("/isbn/")
    public Books getByIsbn(@RequestParam String isbn) {
        return repo.findByIsbn(isbn);
    }

    @PostMapping("/add/")
    public String addBook(@RequestBody Books book) {
        if(repo.existsById(book.getIsbn())){
            return "Book exists";
        }
        return "New book: " + repo.save(book);

    }

    @DeleteMapping("/delete/")
    void deleteBook(@RequestParam String isbn) {
        repo.deleteById(isbn);
    }

    @PutMapping("/change/")
    public String changeBook(@RequestBody Books book){
        if(!repo.existsById(book.getIsbn())){
            return "Book does not exists";
        }
        return repo.save(book).toString();
    }
}
