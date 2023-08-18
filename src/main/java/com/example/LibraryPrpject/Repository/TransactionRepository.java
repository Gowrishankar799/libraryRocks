package com.example.LibraryPrpject.Repository;

import com.example.LibraryPrpject.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
