package com.crud.kodillalibrary.controller;
import com.crud.kodillalibrary.domain.BookDto;
import com.crud.kodillalibrary.domain.TitleDto;
import com.crud.kodillalibrary.domain.UserDto;
import com.crud.kodillalibrary.mapper.BookMapper;
import com.crud.kodillalibrary.mapper.TitleMapper;
import com.crud.kodillalibrary.mapper.UserMapper;
import com.crud.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/library")
@CrossOrigin(origins = "*")
public class LibraryController {
    @Autowired
    private DbService service;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TitleMapper titleMapper;
    @Autowired
    private BookMapper bookMapper;

    //users
    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getUsers() {
        return userMapper.mapToUserDtoList(service.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserById")
    public UserDto getUserById(Long userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(service.getUserById(userId).orElseThrow(UserNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam Long userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(service.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(@RequestParam Long userId) throws UserNotFoundException {
        if (service.getUser(userId).isPresent()) {
            service.deleteUserById(userId);
        } else {
            throw new UserNotFoundException("Error with delete User");
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(service.saveUser(userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
        public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(userMapper.mapToUser(userDto));
    }
    
    //titles
    @RequestMapping(method = RequestMethod.GET, value = "getTitles")
    public List<TitleDto> getTitles() {
        return titleMapper.mapToTitleDtoList(service.getAllTitles());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitleById")
    public TitleDto getTitleById(Long titleId) throws TitleNotFoundException {
        return titleMapper.mapToTitleDto(service.getTitleById(titleId).orElseThrow(TitleNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitle")
    public TitleDto getTitle(@RequestParam Long titleId) throws TitleNotFoundException {
        return titleMapper.mapToTitleDto(service.getTitle(titleId).orElseThrow(TitleNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTitle")
    public void deleteTitle(@RequestParam Long titleId) throws TitleNotFoundException {
        if (service.getTitle(titleId).isPresent()) {
            service.deleteTitleById(titleId);
        } else {
            throw new TitleNotFoundException("Error with delete Title");
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTitle")
    public TitleDto updateTitle(@RequestBody TitleDto titleDto) {
        return titleMapper.mapToTitleDto(service.saveTitle(titleMapper.mapToTitle(titleDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle", consumes = APPLICATION_JSON_VALUE)
    public void createTitle(@RequestBody TitleDto titleDto) {
        service.saveTitle(titleMapper.mapToTitle(titleDto));
    }

    //books
    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBookById")
    public BookDto getBookById(Long bookId) throws BookNotFoundException {
        return bookMapper.mapToBookDto(service.getBookById(bookId).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(@RequestParam Long bookId) throws BookNotFoundException {
        return bookMapper.mapToBookDto(service.getBook(bookId).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam Long bookId) throws BookNotFoundException {
        if (service.getBook(bookId).isPresent()) {
            service.deleteBookById(bookId);
        } else {
            throw new BookNotFoundException("Error with delete Book");
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBook")
    public BookDto updateBook(@RequestBody BookDto BookDto) {
        return bookMapper.mapToBookDto(service.saveBook(bookMapper.mapToBook(BookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto BookDto) {
        service.saveBook(bookMapper.mapToBook(BookDto));
    }
}

