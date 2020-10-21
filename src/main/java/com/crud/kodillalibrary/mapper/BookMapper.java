package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getStatus());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getStatus());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(t -> new BookDto(t.getStatus()))
                .collect(Collectors.toList());
    }
}
