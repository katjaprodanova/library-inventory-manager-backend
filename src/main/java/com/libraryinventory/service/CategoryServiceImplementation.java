package com.libraryinventory.service;

import com.libraryinventory.exceptions.CategoryNotFoundException;
import com.libraryinventory.exceptions.EmptyFieldException;
import com.libraryinventory.model.Category;
import com.libraryinventory.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImplementation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category findCategoryById(Long id) {
        return this.categoryRepository.findCategoryById(id).orElseThrow(()->new CategoryNotFoundException(id));
    }
    @Override
    public Category addCategory(Category category){
        return this.categoryRepository.save(category);
    }
    @Override
    public Category createCategoryWithName(String name) {
        if (name.isEmpty()) throw new EmptyFieldException();
        Category category = new Category(name);
        this.categoryRepository.save(category);
        return category;
    }

    @Override
    public Category updateCategory(Category category) {
       return this.categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        this.categoryRepository.deleteCategoryById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public List<Category> searchCategories(String searchText) {
        return this.categoryRepository.findAllByNameLike(searchText);
    }
}
