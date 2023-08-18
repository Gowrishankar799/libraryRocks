package com.example.LibraryPrpject.Models;

import com.example.LibraryPrpject.Enum.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String name;
    private int age;
    private Department department;
    @Column(unique = true)
    private String email;
    @OneToOne
    @JoinColumn
    private LibraryCard libraryCard;
}
