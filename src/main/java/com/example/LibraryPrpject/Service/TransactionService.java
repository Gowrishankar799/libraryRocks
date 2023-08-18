package com.example.LibraryPrpject.Service;

import com.example.LibraryPrpject.CustomExceptions.*;
import com.example.LibraryPrpject.Enum.CardStatus;
import com.example.LibraryPrpject.Enum.TransactionStatus;
import com.example.LibraryPrpject.Enum.TransactionType;
import com.example.LibraryPrpject.Models.Book;
import com.example.LibraryPrpject.Models.LibraryCard;
import com.example.LibraryPrpject.Models.Transaction;
import com.example.LibraryPrpject.Repository.BookRepository;
import com.example.LibraryPrpject.Repository.LibraryCardRepository;
import com.example.LibraryPrpject.Repository.TransactionRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryCardRepository libraryCardRepository;
   // private final int maxlimit = 6;

    @Value("${book.maxLimit}")
    private Integer maxBookLimit;


    public String addTransaction(int bookId, int libraryId) throws Exception {
        // check some Validations
        //Optional<Transaction> optionalBook = transactionRepository.findById(bookId);
        Transaction tr = new Transaction(TransactionStatus.PENDING, TransactionType.ISSUE);
        Optional<Book>optionalBook = bookRepository.findById(bookId);
        if(!optionalBook.isPresent()){
            throw new BookIdIsNotAvailable("Book id is not valid");
        }
        Book b = optionalBook.get();
        if(b.getIsAvailable() == Boolean.FALSE){
            throw new BookAvailable("Book is not Available in the Library");
        }
        Optional<LibraryCard>optionalLibraryCard = libraryCardRepository.findById(libraryId);
        if(!optionalLibraryCard.isPresent()){
            throw new InvalidLibraryId("Invalid Library card id");
        }
        LibraryCard libraryCard = optionalLibraryCard.get();
        if(libraryCard.getCardStatus() == CardStatus.INACTIVE){
            tr.setTransactionStatus(TransactionStatus.FAILED);
            tr = transactionRepository.save(tr);
            throw new InActiveCardException("Card is Inactive State");
        }
        if(libraryCard.getNoOfBooksIssued() >= maxBookLimit){
            tr.setTransactionStatus(TransactionStatus.FAILED);
            tr = transactionRepository.save(tr);
            throw new MaxLimitBooksException("Maximum Books limit exceeded");
        }
        // all validations clear.
        tr.setTransactionStatus(TransactionStatus.SUCCESS);
        // save parent object in the child(foreign keys).
        tr.setBook(b);
        tr.setLibraryCard(libraryCard);
        // Since its birectional so parents also save childerens.
        Transaction newTransactionId = transactionRepository.save(tr);
        // without id tranaction is two times saved . to avoid this we save the transaction.
        //b.getTransactionList().add(newTransactionId);

        //libraryCard.getTransactionList().add(newTransactionId);
        List<Transaction>list = b.getList();
        list.add(newTransactionId);
        List<Transaction>list1 = libraryCard.getList();
        list1.add(newTransactionId);
        bookRepository.save(b);
        libraryCardRepository.save(libraryCard);
        return "Transaction is successfully added to the database";

    }
}
