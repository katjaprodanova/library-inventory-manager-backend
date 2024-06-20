package com.libraryinventory.controller;

import com.libraryinventory.model.Book;
import com.libraryinventory.model.Category;
import com.libraryinventory.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> allBooks = this.bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        Book book = this.bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book newBook = this.bookService.addBook(book);
        return new ResponseEntity<>(newBook,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updatedBook = this.bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
        this.bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/count")
//    public ResponseEntity<Long> getBookCount(){
//        Long count = (long) this.bookService.getAllBooks().size();
//        return new ResponseEntity<>(count,HttpStatus.OK);
//    }
    @GetMapping("/count")
    public ResponseEntity<Long> countBooks() {
        long count = bookService.countBooks();
       /// System.out.println("Count of books: " + count);
        return ResponseEntity.ok(count);
    }
}







