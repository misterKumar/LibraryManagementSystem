package com.example.Student_Library_Management_System.Repositories;

import com.example.Student_Library_Management_System.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
// in repsoitory <first,second> first is entity here it is Author and second is datatype of primaryKey here id is pk and its datatype is Integer