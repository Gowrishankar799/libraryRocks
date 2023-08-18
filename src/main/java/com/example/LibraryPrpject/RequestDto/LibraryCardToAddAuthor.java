package com.example.LibraryPrpject.RequestDto;

import com.example.LibraryPrpject.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryCardToAddAuthor {
    private CardStatus cardStatus;
    private int noOfBooksIssued;
    private int studentId;
}
