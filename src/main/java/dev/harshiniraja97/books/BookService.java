package dev.harshiniraja97.books;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class BookService {
    @Autowired//instantiates the below class for the application
    private BookRepository bookRepository;
    public List<Books> allBooks(){
      //  System.out.println(bookRepository.findAll().toString());
        return bookRepository.findAll();
    }
    public Optional<Books> singleBook(ObjectId id){
        return bookRepository.findById(id);
    }
}
