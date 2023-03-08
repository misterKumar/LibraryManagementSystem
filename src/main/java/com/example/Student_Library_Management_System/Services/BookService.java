package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTos.BookRequestDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

/*
    public String addBook(Book book){
        //i want to get the author Entity
        int authorId=book.getAuthor().getId();
        // now i will be fetching the author Entity
        Author author=authorRepository.findById(authorId).get();

        // basic attributes are already set from postman
        // setting the foreign key attributes in the child class
        book.setAuthor(author);

        // we need to update the list of books written in the parent class
        // I need to update the listOfBooks written in the parent class

        List<Book> currentBooksWritten=author.getBooksWritten();
        currentBooksWritten.add(book);
        author.setBooksWritten(currentBooksWritten);

        // now the book is to be saved ,but also author is also to be saved

        // why do we need to again save(updating) the author ??? because
        // the author entity has been updated... we need to resave/update it.

        authorRepository.save(author);// data was modified
        // .save function works both the save function and as update function

        // bookrepo.save is not required because it will be autocalled by cascade effect
      return "book added successfully";
    }

 */
    // new flow with dto
public String addBook(BookRequestDto bookRequestDto){
    //i want to get the author Entity
    int authorId=bookRequestDto.getAuthorId();
    // now i will be fetching the author Entity
    Author author=authorRepository.findById(authorId).get();

    // created this entity so that we can save it into the db
    //and it will help in conversion of dto to entity or object to save in repository
    Book book=new Book();


    // basic attributes are being set from Dto to entity layer
    book.setGenre(bookRequestDto.getGenre());
    book.setIssued(false);
    book.setName(bookRequestDto.getName());
    book.setPages(bookRequestDto.getPages());


    // setting the foreign key attributes in the child class
    book.setAuthor(author);

    // we need to update the list of books written in the parent class
    // I need to update the listOfBooks written in the parent class

    List<Book> currentBooksWritten=author.getBooksWritten();
    currentBooksWritten.add(book);
    author.setBooksWritten(currentBooksWritten);

    // now the book is to be saved ,but also author is also to be saved

    // why do we need to again save(updating) the author ??? because
    // the author entity has been updated... we need to resave/update it.

    authorRepository.save(author);// data was modified
    // .save function works both the save function and as update function

    // bookrepo.save is not required because it will be autocalled by cascade effect
    return "book added successfully";
}

}
