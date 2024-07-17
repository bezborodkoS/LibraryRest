package com.example.libraryrest.service;

import com.example.libraryrest.model.Book;
import com.example.libraryrest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean addBook(Book book){
        book.setIsAvailableInLibrary(true);
        book.setISBN(1);
        bookRepository.save(book);
        return true;
    }
}
