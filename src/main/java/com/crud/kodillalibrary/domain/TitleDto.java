package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TitleDto {
    private Long id;
    private String bookTitle;
    private String author;
    private int publicationYear;
}
