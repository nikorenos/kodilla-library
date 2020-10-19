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
    public UserDto updateUser(@RequestBody UserDto UserDto) {
        return userMapper.mapToUserDto(service.saveUser(userMapper.mapToUser(UserDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto UserDto) {
        service.saveUser(userMapper.mapToUser(UserDto));
    }
    
    //titles
    @RequestMapping(method = RequestMethod.GET, value = "getTitles")
    public List<TitleDto> getTitles() {
        return titleMapper.mapToTitleDtoList(service.getAllTitles());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitleById")
    public TitleDto getTitleById(Long TitleId) throws TitleNotFoundException {
        return titleMapper.mapToTitleDto(service.getTitleById(TitleId).orElseThrow(TitleNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitle")
    public TitleDto getTitle(@RequestParam Long TitleId) throws TitleNotFoundException {
        return titleMapper.mapToTitleDto(service.getTitle(TitleId).orElseThrow(TitleNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTitle")
    public void deleteTitle(@RequestParam Long TitleId) throws TitleNotFoundException {
        if (service.getTitle(TitleId).isPresent()) {
            service.deleteTitleById(TitleId);
        } else {
            throw new TitleNotFoundException("Error with delete Title");
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTitle")
    public TitleDto updateTitle(@RequestBody TitleDto TitleDto) {
        return titleMapper.mapToTitleDto(service.saveTitle(titleMapper.mapToTitle(TitleDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle", consumes = APPLICATION_JSON_VALUE)
    public void createTitle(@RequestBody TitleDto TitleDto) {
        service.saveTitle(titleMapper.mapToTitle(TitleDto));
    }

    //books
    @RequestMapping(method = RequestMethod.GET, value = "getBooks")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(service.getAllBooks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBookById")
    public BookDto getBookById(Long BookId) throws BookNotFoundException {
        return bookMapper.mapToBookDto(service.getBookById(BookId).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBook")
    public BookDto getBook(@RequestParam Long BookId) throws BookNotFoundException {
        return bookMapper.mapToBookDto(service.getBook(BookId).orElseThrow(BookNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBook")
    public void deleteBook(@RequestParam Long BookId) throws BookNotFoundException {
        if (service.getBook(BookId).isPresent()) {
            service.deleteBookById(BookId);
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

