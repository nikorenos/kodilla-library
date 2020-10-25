package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.Title;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    List<Book> findAll();

    @Override
    Optional<Book> findById(Long bookId);

    @Override
    Book save(Book book);

    @Override
    void deleteById(Long bookId);

    @Query
    List<Book> retrieveFreeBooksWithTitleId(@Param("titleId") Long titleId);

}


