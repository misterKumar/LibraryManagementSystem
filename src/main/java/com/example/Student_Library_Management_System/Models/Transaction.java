package com.example.Student_Library_Management_System.Models;

import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;
    private int fine;
    private String transactionId= UUID.randomUUID().toString();
    private Date transactionDate;
    private boolean isIssueOperation;
    // transaction is child for book and card
    @ManyToOne
    @JoinColumn
    private Book book;// book entity pk(primary key) will come here and become a foreign key.

    @ManyToOne
    @JoinColumn
    private Card card;// card entity pk will come here and became a foreign key

    //unidirectional mapping is done here
    // for bidirectional mapping we have to set things in parent class also.


    public Transaction() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isIssueOperation() {
        return isIssueOperation;
    }

    public void setIssueOperation(boolean issueOperation) {
        isIssueOperation = issueOperation;
    }
}
