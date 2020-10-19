package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    List<User> findAll();

    @Override
    Optional<User> findById(Long userId);

    @Override
    User save(User user);

    @Override
    void deleteById(Long userId);
}

