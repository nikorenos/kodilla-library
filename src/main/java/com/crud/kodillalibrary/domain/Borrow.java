package com.crud.kodillalibrary.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class Borrow {
    private Long book_id;
    private Long user_id;
    private LocalDate startBorrow;
    private LocalDate endBorrow;

}
