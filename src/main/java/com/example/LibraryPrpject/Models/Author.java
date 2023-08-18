package com.example.LibraryPrpject.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String name;
    private String penName;
    @Column(unique = true)
    private String eMail;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book>list = new ArrayList<>();
}
