package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Borrow;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowRepository extends CrudRepository<Borrow, Long> {

    @Override
    List<Borrow> findAll();

    @Override
    Optional<Borrow> findById(Long borrowId);

    @Override
    Borrow save(Borrow borrow);

    @Override
    void deleteById(Long borrowId);


}

