package com.example.LibraryPrpject.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePenNameAndName {
    private int authorId;
    private String name;
    private String penName;
}
