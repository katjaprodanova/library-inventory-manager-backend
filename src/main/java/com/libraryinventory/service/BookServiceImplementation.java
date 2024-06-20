package com.libraryinventory.service;

import com.libraryinventory.exceptions.BookNotFoundException;
import com.libraryinventory.model.Book;
import com.libraryinventory.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImplementation(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book){
       return this.bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    public Book findBookById(Long id){
        return this.bookRepository.findBookById(id).orElseThrow(()->new BookNotFoundException(id));
    }

    public Book updateBook(Book book){
        Long bookId = book.getId();
        if (bookId == null || !this.bookRepository.existsById(bookId)) {
            throw new BookNotFoundException(bookId);
        }
        return this.bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long id){
        this.bookRepository.deleteBookById(id);
    }

    public long countBooks() {
        return bookRepository.count();
    }
}
