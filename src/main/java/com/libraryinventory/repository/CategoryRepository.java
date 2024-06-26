package com.libraryinventory.repository;

import com.libraryinventory.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAllByNameLike(String text);

    Optional<Category> findCategoryById(Long id);

    void deleteCategoryById(Long id);

    void deleteByName(String name);
    Optional<Category> findByName(String name);
}
