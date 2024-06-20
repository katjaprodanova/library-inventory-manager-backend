package com.libraryinventory.service;

import com.libraryinventory.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    Category findCategoryById(Long id);
    Category addCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long id);

    Category createCategoryWithName(String name);
    List<Category> searchCategories(String searchText);
}
