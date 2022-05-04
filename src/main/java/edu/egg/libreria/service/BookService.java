package edu.egg.libreria.service;

import edu.egg.libreria.entity.Book;
import edu.egg.libreria.entity.Publisher;
import edu.egg.libreria.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;




    @Transactional(readOnly = true)
    public List<Book> getAll(){
        return bookRepository.findAll();
    }
}
