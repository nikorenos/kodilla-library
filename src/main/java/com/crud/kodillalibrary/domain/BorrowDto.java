package com.crud.kodillalibrary.domain;

import java.time.LocalDate;

public class BorrowDto {
    private Long book_id;
    private Long user_id;
    private LocalDate startBorrow;
    private LocalDate endBorrow;
}
