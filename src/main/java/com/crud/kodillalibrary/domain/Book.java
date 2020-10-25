package com.crud.kodillalibrary.domain;


import lombok.NoArgsConstructor;
import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "Book.retrieveFreeBooksWithTitleId",
                query = "FROM BOOKS WHERE STATUS = 'Free' AND TITLE_ID = :titleId"
                //SELECT * FROM books WHERE title_id=70 AND status='Free'
        )
})

@NoArgsConstructor
@Entity(name = "BOOKS")
public class Book {
    private Long id;
    private String status;
    private Title title;

    public Book(String status) {
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}