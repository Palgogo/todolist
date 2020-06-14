package by.palgogo.todolist.service;

import by.palgogo.todolist.domain.Category;
import by.palgogo.todolist.service.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category createCategory(String categoryName);

    List<Category> getAllCategories();

    Category getCategoryByName(String categoryName);

    void deleteCategory(String categoryName);

    Optional<Category> getCategoryById(Long id);

    CategoryDTO createCategory(CategoryDTO category);

    void deleteCategory(Long categoryId);
}
