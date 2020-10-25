package com.crud.kodillalibrary.service;


import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.Borrow;
import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.domain.User;
import com.crud.kodillalibrary.repository.BookRepository;
import com.crud.kodillalibrary.repository.BorrowRepository;
import com.crud.kodillalibrary.repository.TitleRepository;
import com.crud.kodillalibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowRepository borrowRepository;

    //Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(final Long userId) {
        return userRepository.findById(userId);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUser(final Long userId) {
        return userRepository.findById(userId);
    }

    public void deleteUserById(final Long userId) {
        userRepository.deleteById(userId);
    }

   //Titles
    public List<Title> getAllTitles() {
        return titleRepository.findAll();
    }

    public Optional<Title> getTitleById(final Long titleId) {
        return titleRepository.findById(titleId);
    }
    public Title saveTitle(final Title title) {
        return titleRepository.save(title);
    }

    public Optional<Title> getTitle(final Long TitleId) {
        return titleRepository.findById(TitleId);
    }

    public void deleteTitleById(final Long titleId) {
        titleRepository.deleteById(titleId);
    }
    public List<Title> retrieveTitlesWithName(String name) {
        return titleRepository.retrieveTitleWithName(name);
    }

    //Books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(final Long bookId) {
        return bookRepository.findById(bookId);
    }
    public Book saveBook(final Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBook(final Long bookId) {
        return bookRepository.findById(bookId);
    }

    public void deleteBookById(final Long bookId) {
        bookRepository.deleteById(bookId);
    }
    public List<Book> retrieveFreeBooksWithTitleId(String name) {
        Long titleId = titleRepository.retrieveTitleWithName(name).get(0).getId();
        return bookRepository.retrieveFreeBooksWithTitleId(titleId);
    }

    //Borrows
    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }

    public Optional<Borrow> getBorrowById(final Long borrowId) {
        return borrowRepository.findById(borrowId);
    }
    public Borrow saveBorrow(final Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    public Optional<Borrow> getBorrow(final Long borrowId) {
        return borrowRepository.findById(borrowId);
    }

    public void deleteBorrowById(final Long borrowId) {
        borrowRepository.deleteById(borrowId);
    }
}

