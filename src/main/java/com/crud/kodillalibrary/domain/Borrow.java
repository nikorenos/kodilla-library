package com.crud.kodillalibrary.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity(name = "BORROWS")
public class Borrow {
    private Long id;
    private LocalDate startBorrow;
    private LocalDate endBorrow;
    private User user;
    List<Book> books = new ArrayList<>();

    public Borrow(LocalDate startBorrow, LocalDate endBorrow) {
        this.startBorrow = startBorrow;
        this.endBorrow = endBorrow;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    @Column(name = "START_BORROW")
    public LocalDate getStartBorrow() {
        return startBorrow;
    }

    @Column(name = "END_BORROW")
    public LocalDate getEndBorrow() {
        return endBorrow;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartBorrow(LocalDate startBorrow) {
        this.startBorrow = startBorrow;
    }

    public void setEndBorrow(LocalDate endBorrow) {
        this.endBorrow = endBorrow;
    }
}
