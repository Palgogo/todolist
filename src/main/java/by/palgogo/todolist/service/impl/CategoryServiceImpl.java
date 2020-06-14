package by.palgogo.todolist.service.impl;

import by.palgogo.todolist.domain.Category;
import by.palgogo.todolist.repository.CategoryRepository;
import by.palgogo.todolist.service.CategoryService;
import by.palgogo.todolist.service.dto.CategoryDTO;
import by.palgogo.todolist.service.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllCategories() {
        return categoryMapper.toCategoryList(categoryRepository.findAll());
    }

    public Optional<CategoryDTO> getCategoryById(Long id) {
        return categoryRepository.findById(id).map(categoryMapper::toDTO);
    }

    public CategoryDTO createCategory(CategoryDTO category) {
        Category toCategory = categoryMapper.toCategory(category);
        Category save = categoryRepository.save(toCategory);

        return categoryMapper.toDTO(save);
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
