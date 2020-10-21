package com.crud.kodillalibrary;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.Title;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KodillaLibraryApplication {

    public static void main(String[] args) {


        Title title1 = new Title("Book1", "Author 1", 1981);
        Long id = title1.getId();
        System.out.println(id);
        String title = title1.getBookTitle();
        System.out.println(title);
        Book book1 = new Book ("Borrowed");
        Book book2 = new Book ("Destroyed");

        //title1.getBooksList().add(book1);
        //title1.getBooksList().add(book2);

        //book1.setTitle(title1);
        //book2.setTitle(title1);


        System.out.println(title1);
        //System.out.println(title1.getBooksList());

        SpringApplication.run(KodillaLibraryApplication.class, args);
    }

}
