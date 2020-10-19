package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tiles")
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

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<Book> booksList = new ArrayList<>();


    public Title(Long id, String bookTitle, String author, int publicationYear) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}