package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTos.AuhtorEntryDto;
import com.example.Student_Library_Management_System.DTos.AuthorResponseDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    // /(backslash) is optional :for clean coding you can write
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody AuhtorEntryDto auhtorEntryDto){
        return authorService.createAuthor(auhtorEntryDto);
    }
    /*
    @GetMapping("/getAuthor")
    public Author getAuthor(@RequestParam("authorId")Integer authorId){
        // infinite recursion due to bidirectional mapping of object/entity example api
        // since author-->book-->author-->book-->author and so on due to bidirectional mapping
        // solution is to make response dto or @jasonignore
        return authorService.getAuthor(authorId);
    }
    solution is written below
     */
    @GetMapping("/getAuthor")
    public AuthorResponseDto getAuthor(@RequestParam("authorId")Integer authorId) {
        return authorService.getAuthor(authorId);
    }
}
