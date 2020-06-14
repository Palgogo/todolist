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
import java.util.Objects;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    public Category createCategory(String categoryName) {
        //TODO add checking on duplicate by name category
        Category newCategory = new Category();
        newCategory.setName(categoryName);

        Category savedCategory = categoryRepository.save(newCategory);

        return savedCategory;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryByName(String categoryName) {
        Optional<Category> optionalCategory = categoryRepository.findCategoryByName(categoryName);
        boolean categoryPresent = optionalCategory.isPresent();

        if (categoryPresent) {
            return optionalCategory.get();
        } else return null;
    }

    public void deleteCategory(String categoryName){
        Category categoryByName = getCategoryByName(categoryName);

        if (Objects.nonNull(categoryByName)){
            categoryRepository.delete(categoryByName);
        }
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
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
