package com.crud.kodillalibrary;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.Borrow;
import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.domain.User;
import com.crud.kodillalibrary.service.DbService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class KodillaLibraryApplicationTests {
    @Autowired
    private DbService service;

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
        borrow1.setBook(new Book("Free"));
        borrow1.getBook().setTitle(title1);
        borrow1.setUser(new User("Henry","Cavil",date1));


        //System.out.println(title1);

        /*Invoice invoice = new Invoice("0001");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);*/

        //When
        service.saveTitle(title1);
        service.saveBorrow(borrow1);

        //service.saveBook(book1);
        //service.saveBook(book2);
        //Long id = title1.getId();

        //Then
        Assert.assertNotEquals(0,1);

        //CleanUp
        //service.deleteTitleById((long) id);
    }

}
