package com.crud.kodillalibrary.domain;


import lombok.NoArgsConstructor;
import javax.persistence.*;



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
    @GeneratedValue(strategy = GenerationType.AUTO)
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