package com.example.LibraryPrpject.Service;

import com.example.LibraryPrpject.CustomExceptions.InvalidStudentId;
import com.example.LibraryPrpject.Enum.CardStatus;
import com.example.LibraryPrpject.Models.Book;
import com.example.LibraryPrpject.Models.LibraryCard;
import com.example.LibraryPrpject.Models.Student;
import com.example.LibraryPrpject.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) throws Exception{
       if(student.getStudentId()!=0){
           throw new Exception("Author id not sent in the postman");
       }
       studentRepository.save(student);
       return "Student is added to the database";
    }
    public CardStatus cardStatusOfTheStudent(int id) throws Exception{
        Optional<Student>optionalStudent = studentRepository.findById(id);
        if(!optionalStudent.isPresent()){
            throw new InvalidStudentId("Student id is not valid");
        }
        Student student = optionalStudent.get();
         LibraryCard libraryCard =  student.getLibraryCard();
         return libraryCard.getCardStatus();
    }
}
