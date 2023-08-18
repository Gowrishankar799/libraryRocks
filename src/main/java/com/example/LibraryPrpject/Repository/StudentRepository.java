package com.example.LibraryPrpject.Repository;

import com.example.LibraryPrpject.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
