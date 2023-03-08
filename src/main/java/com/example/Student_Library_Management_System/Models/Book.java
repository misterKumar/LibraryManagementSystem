package com.example.Student_Library_Management_System.Models;


import com.example.Student_Library_Management_System.Enums.Genre;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pages;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private boolean isIssued;

    // book is child w.r.t author
    //Setting here the foreign Key :Standard 3 steps
    @ManyToOne
    @JoinColumn // add an extra attribute of authorId(parent table pk) for the foreign key of child table
    private Author author;// This is the parent entity are connecting with

    // book is also child wrt card
    @ManyToOne
    @JoinColumn
    private Card card;

    // book is parent wrt transaction
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction> listOfTransactions=new ArrayList<>();//good practice is to initialise here only



    public Book() {
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transaction> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }
}
