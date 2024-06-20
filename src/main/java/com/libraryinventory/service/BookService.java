package com.libraryinventory.service;

import com.libraryinventory.model.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);
    List<Book> getAllBooks();
    Book findBookById(Long id);
    Book updateBook(Book book);
    void deleteBook(Long id);
    long countBooks();


}
