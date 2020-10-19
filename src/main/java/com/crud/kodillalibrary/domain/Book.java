package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "status")
    private String status;

    @OneToMany(
            targetEntity = Title.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    List<Title> titleList = new ArrayList<>();

    @Column(name = "titleId")
    private Long titleId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<Title> getTitleList() {
        return titleList;
    }
    public void setTitleList(List<Title> titleList) {
        this.titleList = titleList;
    }

    public Long getTitleId() {
        return titleId;
    }
    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    public Book(Long titleId, String status) {
        this.titleId = titleId;
        this.status = status;
    }
}
