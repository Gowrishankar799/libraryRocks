package com.example.LibraryPrpject.Service;

import com.example.LibraryPrpject.CustomExceptions.InvalidStudentId;
import com.example.LibraryPrpject.Models.LibraryCard;
import com.example.LibraryPrpject.Models.Student;
import com.example.LibraryPrpject.Repository.LibraryCardRepository;
import com.example.LibraryPrpject.Repository.StudentRepository;
import com.example.LibraryPrpject.RequestDto.LibraryCardToAddAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryCardService {
    @Autowired
    LibraryCardRepository libraryCardRepository;
    @Autowired
    StudentRepository studentRepository;
    public String addLibraryCard(LibraryCardToAddAuthor libraryCardToAddAuthor)throws Exception{
        Optional<Student>optionalStudent = studentRepository.findById(libraryCardToAddAuthor.getStudentId());
        if(!optionalStudent.isPresent()){
            throw new InvalidStudentId("Student Id is not valid");
        }
        Student student = optionalStudent.get();
        LibraryCard l = new LibraryCard(libraryCardToAddAuthor.getCardStatus(),libraryCardToAddAuthor.getNoOfBooksIssued());
        // set the parent object in the child. (foreign key is always in the child class)
        l.setStudent(student);
        // since it is birectional we set child object in the parent class.
        student.setLibraryCard(l);
        // Since its bidirectional we save the either parent or child is also fine .
        // any one of the either child or parent is required.
        // mostly we prefer to save parent.
        studentRepository.save(student);
        return "add Library Card to the database successfully";
    }
}
