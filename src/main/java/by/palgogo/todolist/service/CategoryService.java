package by.palgogo.todolist.service;

import by.palgogo.todolist.service.dto.CategoryDTO;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    Optional<CategoryDTO> getCategoryById(Long id);

    CategoryDTO createCategory(CategoryDTO category);

    void deleteCategory(Long categoryId);
}
