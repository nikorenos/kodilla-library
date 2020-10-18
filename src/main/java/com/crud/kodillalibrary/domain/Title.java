package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "ttiles")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "bookTitle", unique = true)
    private String bookTitle;

    @Column(name = "author")
    private String author;

    @Column(name = "publicationYear")
    private int publicationYear;
}