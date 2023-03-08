package com.example.Student_Library_Management_System.Controllers;

import com.example.Student_Library_Management_System.DTos.StudentUpdateMobRequestDto;
import com.example.Student_Library_Management_System.Models.Student;
import com.example.Student_Library_Management_System.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/get_user")
    public String getNameByEmail(@RequestParam("email")String email){
        return studentService.findNameByEmail(email);
    }
    @GetMapping("/getby_country")
    public List<Student> getByCountry(@RequestParam("country")String country){
        return studentService.findByCountry(country);
    }
    @PutMapping("/update_mob")
    public String updateMob(@RequestBody StudentUpdateMobRequestDto studentUpdateMobRequestDto){
        return studentService.updateMobNo(studentUpdateMobRequestDto);
    }
}
