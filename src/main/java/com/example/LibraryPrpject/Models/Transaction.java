package com.example.LibraryPrpject.Models;

import com.example.LibraryPrpject.Enum.TransactionStatus;
import com.example.LibraryPrpject.Enum.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    @CreationTimestamp
    private Date creatAt;
    @UpdateTimestamp
    private Date updateAt;
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;
    @Enumerated(value = EnumType.STRING)
    private TransactionType transactionType;
    public Transaction(TransactionStatus transactionStatus, TransactionType transactionType){
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
    }
    @ManyToOne
    @JoinColumn
    private Book book;
    @ManyToOne
    @JoinColumn
    private LibraryCard libraryCard;
}
