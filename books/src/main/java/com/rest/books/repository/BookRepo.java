package com.rest.books.repository;


import com.rest.books.entity.Books;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepo extends JpaRepository<Books, String> {

    Books findByIsbn(String isbn);



}
