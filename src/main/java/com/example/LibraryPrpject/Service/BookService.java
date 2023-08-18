package com.example.LibraryPrpject.Service;

import com.example.LibraryPrpject.CustomExceptions.InvalidAuthorIdException;
import com.example.LibraryPrpject.Enum.Catagory;
import com.example.LibraryPrpject.Models.Author;
import com.example.LibraryPrpject.Models.Book;
import com.example.LibraryPrpject.Repository.AuthorRepository;
import com.example.LibraryPrpject.Repository.BookRepository;
import com.example.LibraryPrpject.RequestDto.BookIsSetAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    public String addBook(BookIsSetAuthor bookIsSetAuthor) throws Exception{
        Optional<Author>authorOptional = authorRepository.findById(bookIsSetAuthor.getAuthorId());
       if(!authorOptional.isPresent()){
           throw new InvalidAuthorIdException("Author id is not valid");
       }
       Author author = authorOptional.get();
       // Book(String name, Catagory catagory,int price, Boolean isAvailable){
        Book b = new Book(bookIsSetAuthor.getName(),bookIsSetAuthor.getCatagory(),bookIsSetAuthor.getPrice(),bookIsSetAuthor.getIsAvailable());
       // set parent object in the child class (Foreign key)
        b.setAuthor(author);
        // set child object set in the parent class (Because its birectional)
        List<Book>list = author.getList();
        list.add(b);
        author.setList(list);
        // Since it is birectional we dont require save both the parent and child
        // we save either parent or child . Mostly patent is refer.
        authorRepository.save(author);
        //bookRepository.save(b);
        return "book is added in the database successfully";
    }
    public List<String> getNamesByFiction(Catagory catagory){
        List<Book>list = bookRepository.findAll();
        List<String>list1 = new ArrayList<>();
        for(Book b : list){
            if(b.getCatagory() == catagory){
                list1.add(b.getName());
            }
        }
        return list1;
    }
}
