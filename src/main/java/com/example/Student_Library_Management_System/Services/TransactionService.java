package com.example.Student_Library_Management_System.Services;

import com.example.Student_Library_Management_System.DTos.IssueBookRequestDto;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Transaction;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import com.example.Student_Library_Management_System.Repositories.CardRepository;
import com.example.Student_Library_Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        int bookId= issueBookRequestDto.getBookId();
        int cardId=issueBookRequestDto.getCardId();
        // get the book entity and card entity to set the transaction attributes

        Book book=bookRepository.findById(bookId).get();
        Card card=cardRepository.findById(cardId).get();

        // final goal is to make a transaction entity, set its attribute and save it.
        Transaction transaction=new Transaction();
        // convert dto to object by setting some required variables
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setIssueOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        transaction.setTransactionId(UUID.randomUUID().toString());

        // check for validate transactions i.e., success or failure.
        if(book==null||book.isIssued()==true)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }
        if(card==null||card.getCardStatus()!= CardStatus.ACTIVATED)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not valid");
        }
        // we have reached a success case now.
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);

        // need to make changes in the card and book
        List<Transaction> transactionsListForCard=card.getListOfTransactions();
        transactionsListForCard.add(transaction);
        card.setListOfTransactions(transactionsListForCard);

        // card and the transaction are bidirectional(parent class)
        List<Transaction> transactionsListForBook=book.getListOfTransactions();
        transactionsListForBook.add(transaction);
        book.setListOfTransactions(transactionsListForBook);

        // save the parent.
        cardRepository.save(card);
        // automatically by cascading : book and transaction will be saved.since we save the parent card
        return "Book issued successfully";
    }
    public String getTransactions(int bookId,int cardId){
        List<Transaction>transactionList=transactionRepository.getTransactionsForBookAndCard(bookId,cardId);
        String transactionId=transactionList.get(0).getTransactionId();
        return transactionId;
    }
}
