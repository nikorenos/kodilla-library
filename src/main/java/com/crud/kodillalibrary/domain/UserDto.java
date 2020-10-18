package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate accountCreated;
}
