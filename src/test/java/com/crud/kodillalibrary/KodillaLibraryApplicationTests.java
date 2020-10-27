package com.crud.kodillalibrary;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.Borrow;
import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.domain.User;
import com.crud.kodillalibrary.repository.TitleRepository;
import com.crud.kodillalibrary.service.DbService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest
public class KodillaLibraryApplicationTests {
    @Autowired
    private DbService service;
    @Autowired
    private TitleRepository titleRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testTitleSave() {
        //Given
        Title title1 = new Title("Title 1", "Author 1", 1981);

        //When
        service.saveTitle(title1);

        //Then
        Long id = title1.getId();
        Optional<Title> findTitle = service.getTitleById(id);
        Assert.assertTrue(findTitle.isPresent());

        //CleanUp
        service.deleteTitleById(id);
    }



    @Test
    public void testLibrarySave() {
        //Given
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now().plusDays(7);
        User user1 = new User("John","Smith",date1);
        Title title1 = new Title("Book1", "Author 1", 1981);

        Book book1 = new Book ("Borrowed");
        Book book2 = new Book ("Destroyed");

        title1.getBooks().add(book1);
        title1.getBooks().add(book2);

        book1.setTitle(title1);
        book2.setTitle(title1);

        Borrow borrow1 = new Borrow(date1, date2);
        borrow1.getBooks().add(book1);
        borrow1.getBooks().add(book2);

        //book1.setBorrow(borrow1);
        //book2.setBorrow(borrow1);
        borrow1.setUser(new User("Henry","Cavil",date1));

        //When
        service.saveTitle(title1);
        //service.saveBorrow(borrow1);
        Long titleId = title1.getId();
        Long borrowId = borrow1.getId();

        //Then
        //Assert.assertNotEquals(0,1);

        //CleanUp
        service.deleteTitleById(titleId);
        //service.deleteBorrowById(borrowId);
    }

    @Test
    public void testHowManyFreeBook() {
        //Given
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now().plusDays(7);
        User user1 = new User("John","Smith",date1);
        Title title1 = new Title("Book1", "Author 1", 1981);

        Book book1 = new Book ("Borrowed");
        Book book2 = new Book ("Free");
        Book book3 = new Book ("Free");

        title1.getBooks().add(book1);
        title1.getBooks().add(book2);
        title1.getBooks().add(book3);

        book1.setTitle(title1);
        book2.setTitle(title1);
        book3.setTitle(title1);

        List<Book> howManyFeeeBooks = title1.getBooks().stream()
                .filter(t -> t.getStatus().equals("Free"))
                .collect(Collectors.toList());

        //Then
        Assert.assertEquals(2,howManyFeeeBooks.size());


        //CleanUp

    }
    @Test
    public void testHowManyTitles() {
        //Given
        Title title1 = new Title("Ulysses", "Author 1", 1981);
        //When
        service.saveTitle(title1);
        Long id = title1.getId();
        //Then
        String name = "Ulysses";
        List<Title> searchedTitles = titleRepository.retrieveTitleWithName(name);
        Assert.assertEquals(1,searchedTitles.size());
        //CleanUp
        service.deleteTitleById((long) id);
    }
    @Test
    public void testHowManyFreeTitles() {
        //Given
        Title title1 = new Title("Ulysses", "Author 1", 1981);
        Book book1 = new Book ("Borrowed");
        Book book2 = new Book ("Free");
        Book book3 = new Book ("Free");

        title1.getBooks().add(book1);
        title1.getBooks().add(book2);
        title1.getBooks().add(book3);

        book1.setTitle(title1);
        book2.setTitle(title1);
        book3.setTitle(title1);

        //When
        service.saveTitle(title1);
        Long id = title1.getId();
        String name = "Ulysses";
        List<Book> searchedBooks = service.retrieveFreeBooksWithTitleId(name);
        Assert.assertEquals(2,searchedBooks.size());

        //CleanUp
        service.deleteTitleById((long) id);
    }

}
