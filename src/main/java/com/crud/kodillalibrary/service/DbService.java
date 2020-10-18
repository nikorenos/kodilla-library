package com.crud.kodillalibrary.service;


import com.crud.kodillalibrary.domain.User;
import com.crud.kodillalibrary.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private LibraryRepository repository;


    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(final Long UserId) {
        return repository.findById(UserId);
    }

    public User saveUser(final User User) {
        return repository.save(User);
    }

    public Optional<User> getUser(final Long UserId) {
        return repository.findById(UserId);
    }

    public void deleteById(final Long UserId) {
        repository.deleteById(UserId);
    }
}

