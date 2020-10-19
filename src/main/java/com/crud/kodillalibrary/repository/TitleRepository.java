package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TitleRepository extends CrudRepository<Title, Long> {

    @Override
    List<Title> findAll();

    @Override
    Optional<Title> findById(Long titleId);

    @Override
    Title save(Title title);

    @Override
    void deleteById(Long titleId);

}

