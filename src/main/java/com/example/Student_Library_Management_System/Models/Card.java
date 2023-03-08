package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity// it must require default constructor.
@Table(name = "card")
public class Card {
    // plan is to save the card in db.
    //before saving  i have to set its attributes :Rule 1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;// It's Autogenerated
    @CreationTimestamp // Auto timestamp the time when an entry is created
    private Date createdOn;// It's Autogenerated
    @UpdateTimestamp// sets time when entry is updated
    private Date updateOn;// It's Autogenerated
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;// set in StudentService layer
    @OneToOne
    @JoinColumn
    private Student studentVariableName;// this variable name is used in the parent class
    // while doing the bidirectional mapping

    // card is parent wrt to book
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Book> booksIssued=new ArrayList<>();// bi directional Mapping for one card to many books

    // card is parent wrt to transaction
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    private List<Transaction>listOfTransactions=new ArrayList<>();

    public Card() {
        // this constructor is due to bean caused by entity
        // booksIssued=new ArrayList<>(); in construtor or at declaration
       // always good to initiate list because by default variables are null
        // for int =0,double =0 that is why use to initialise list to except nullpointer.

    }

    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public List<Transaction> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transaction> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }
}
