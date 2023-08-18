package com.example.LibraryPrpject.Models;

import com.example.LibraryPrpject.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libraryCard")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int libraryCardId;
    private CardStatus cardStatus;
    private int noOfBooksIssued;
    public LibraryCard(CardStatus cardStatus,int noOfBooksIssued){
        this.cardStatus = cardStatus;
        this.noOfBooksIssued = noOfBooksIssued;
    }
    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    private List<Transaction>list = new ArrayList<>();
    @OneToOne
    @JoinColumn
    private Student student;


}
