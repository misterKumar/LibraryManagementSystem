package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTos.AuhtorEntryDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
