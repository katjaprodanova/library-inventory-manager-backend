package com.libraryinventory.repository;

import com.libraryinventory.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findBookById(Long id);
    void deleteBookById(Long id);
    boolean existsById(Long id);
    Optional<Book> findByBookName(String bookName);

}
