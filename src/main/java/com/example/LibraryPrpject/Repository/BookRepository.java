package com.example.LibraryPrpject.Repository;

import com.example.LibraryPrpject.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
