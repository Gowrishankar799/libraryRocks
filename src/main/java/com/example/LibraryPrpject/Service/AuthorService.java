package com.example.LibraryPrpject.Service;

import com.example.LibraryPrpject.CustomExceptions.InvalidAuthorIdException;
import com.example.LibraryPrpject.Models.Author;
import com.example.LibraryPrpject.Models.Book;
import com.example.LibraryPrpject.Repository.AuthorRepository;
import com.example.LibraryPrpject.RequestDto.UpdatePenNameAndName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) throws Exception{
        if(author.getAuthorId()!=0){
            throw new Exception("Author Id is not sent to the postMan");
        }
        authorRepository.save(author);
        return "Author is saved is in the database";
    }
    public String updateAuthor(UpdatePenNameAndName updatePenNameAndName) throws Exception{
        if(!authorRepository.existsById(updatePenNameAndName.getAuthorId())){
            throw new Exception("Author Id is not valid");
        }
        Optional<Author>optionalAuthor = authorRepository.findById(updatePenNameAndName.getAuthorId());
        Author author = optionalAuthor.get();
        author.setName(updatePenNameAndName.getName());
        author.setPenName(updatePenNameAndName.getPenName());
        return "update name and penname by authorid";
    }
    public List<String> listOfBooks(int id) throws Exception{
        Optional<Author>optionalAuthor = authorRepository.findById(id);
        if(!optionalAuthor.isPresent()){
            throw new InvalidAuthorIdException("author id is not valid");
        }
        Author author = optionalAuthor.get();
        List<String>list = new ArrayList<>();
        List<Book>list1 = author.getList();
        for(Book b : list1){
            list.add(b.getName());
        }
        return list;
    }
    public Author getAuthorById(int id) throws Exception{
        Optional<Author>authorOptional = authorRepository.findById(id);
        if(!authorOptional.isPresent()){
            throw new InvalidAuthorIdException("Author is not valid");
        }
        Author author = authorOptional.get();
        return author;
    }
}
