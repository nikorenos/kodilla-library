package com.crud.kodillalibrary.domain;

import com.crud.kodillalibrary.service.DbService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Title.retrieveTitleWithName",
                query = "FROM TITLES WHERE BOOK_TITLE = :name"
                //SELECT * FROM books WHERE title_id=70 AND status='Free'
        )
})


@NoArgsConstructor
@Entity(name = "TITLES")
public class Title {
    private Long id;
    private String bookTitle;
    private String author;
    private int publicationYear;
    List<Book> books = new ArrayList<>();

    public Title(String bookTitle, String author, int publicationYear) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    @Column(name = "BOOK_TITLE", unique = true)
    public String getBookTitle() {
        return bookTitle;
    }
    @Column(name = "AUTHOR")
    public String getAuthor() {
        return author;
    }

    @Column(name = "PUBLICATION_YEAR")
    public int getPublicationYear() {
        return publicationYear;
    }

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "title",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }


    @Override
    public String toString() {
        return "Title{" +
                //"id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                //", booksList=" + booksList +
                '}';
    }
}