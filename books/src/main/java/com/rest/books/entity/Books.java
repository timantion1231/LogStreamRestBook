package com.rest.books.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Books {

    private UUID isbn;

    private String title;

}
