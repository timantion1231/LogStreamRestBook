package com.rest.books.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Books {

    @Id
    private String isbn;

    private String title;

    public Books(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public Books() {
    }

    @Override
    public String toString() {
        return "Books{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                '}';
    }
}
