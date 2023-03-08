package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTos.AuhtorEntryDto;
import com.example.Student_Library_Management_System.DTos.AuthorResponseDto;
import com.example.Student_Library_Management_System.DTos.BookResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String createAuthor(AuhtorEntryDto auhtorEntryDto){
        //Important step is : in the params : the object is
        // of type DTO but the repository interacts only with entities

        //solution to this :convert authorEntryDto ---> Author

        // create an object of type Author
        Author author=new Author();

        // we are setting its attribute so that we can save
        // correct values in the db.
        author.setName(auhtorEntryDto.getName());
        author.setAge(auhtorEntryDto.getAge());
        author.setCountry(auhtorEntryDto.getCountry());
        author.setRating(auhtorEntryDto.getRating());

        authorRepository.save(author);

        return "Author added successfully";
    }
    /*
    public Author getAuthor(Integer authorId){
        // infinite recursion api
        return authorRepository.findById(authorId).get();

    }
    solution is written below
     */
    public AuthorResponseDto getAuthor(Integer authorId) {
        Author author=authorRepository.findById(authorId).get();
        AuthorResponseDto authorResponseDto=new AuthorResponseDto();
        //set  attributes of bookResponseDto
        List<Book>bookList=author.getBooksWritten();
        List<BookResponseDto>booksWrittenDto=new ArrayList<>();
        for(Book b:bookList){
            BookResponseDto bookResponseDto=new BookResponseDto();
            bookResponseDto.setGenre(b.getGenre());
            bookResponseDto.setName(b.getName());
            bookResponseDto.setPages(b.getPages());

            booksWrittenDto.add(bookResponseDto);
        }

        // set attributes for authorResponseDto
        authorResponseDto.setBooksWritten(booksWrittenDto);
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setRating(author.getRating());

        return authorResponseDto;
    }
}
