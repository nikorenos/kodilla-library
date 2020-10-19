package com.crud.kodillalibrary.library;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.service.DbService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryTestSuite {
    @Autowired
    private DbService service;

    /*@Test
    public void testLibrarySave() {
        //Given
        Book book1 = new Book (1L, "Borrowed");
        Book book2 = new Book (2L, "Destroyed");


        Title title1 = new Title(1L,"Title 1", "Author 1", 1981);



        book1.setTitle(title1);
        book2.setTitle(title1);

        *//*Invoice invoice = new Invoice("0001");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);*//*

        //When
        service.saveTitle(title1);
        int id = Math.toIntExact(title1.getId());

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        service.deleteTitleById((long) id);
    }*/
}
