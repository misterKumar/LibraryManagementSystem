package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTos.AuhtorEntryDto;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
