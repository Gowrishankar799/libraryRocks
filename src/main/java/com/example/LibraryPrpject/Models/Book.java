package com.example.LibraryPrpject.Models;

import com.example.LibraryPrpject.Enum.Catagory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Catagory catagory;
    private int price;
    private Boolean isAvailable;
    public Book(String name, Catagory catagory, int price, Boolean isAvailable){
        this.name = name;
        this.catagory = catagory;
        this.price = price;
        this.isAvailable = isAvailable;
    }
    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Author author;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transaction>list = new ArrayList<>();
}
