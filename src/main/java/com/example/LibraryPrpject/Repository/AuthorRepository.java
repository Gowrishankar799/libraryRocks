package com.example.LibraryPrpject.Repository;

import com.example.LibraryPrpject.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
