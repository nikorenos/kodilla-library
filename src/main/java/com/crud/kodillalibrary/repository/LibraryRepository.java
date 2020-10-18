package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long UserId);

    @Override
    User save(User User);

    @Override
    void deleteById(Long UserId);

}

