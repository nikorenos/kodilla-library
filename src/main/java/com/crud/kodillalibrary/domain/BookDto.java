package com.crud.kodillalibrary.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BookDto {
    private Long id;
    private Long title_id;
    private String status;
}
