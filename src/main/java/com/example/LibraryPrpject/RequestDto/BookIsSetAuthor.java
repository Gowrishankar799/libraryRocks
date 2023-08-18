package com.example.LibraryPrpject.RequestDto;

import com.example.LibraryPrpject.Enum.Catagory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookIsSetAuthor {
    private String name;
    private Catagory catagory;
    private int price;
    private Boolean isAvailable;
    private int authorId;
}
