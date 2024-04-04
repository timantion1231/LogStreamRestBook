package com.rest.books.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.books.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/api/main")
    public String mainListener() {
        return "Test";
    }

    @GetMapping("/api/book")
    public String getBook() {
        Books books = new Books("186", "Title");
        String jsonData = null;

        try {
            jsonData = objectMapper.writeValueAsString(books);
        } catch (JsonProcessingException e) {
            System.out.println("Error books");
        }
        return jsonData;
    }


    @PostMapping("/api/addBook")
    public String addBook(@RequestParam String isbn, String title) {
        Books books = new Books(isbn, title);
        String jsonData = null;

        try {
            jsonData = objectMapper.writeValueAsString(books);
        } catch (JsonProcessingException e) {
            System.out.println("Error books");
        }
        return jsonData;
    }
}
