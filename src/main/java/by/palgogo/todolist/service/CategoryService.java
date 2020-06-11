package by.palgogo.todolist.service;

import by.palgogo.todolist.domain.Category;
import by.palgogo.todolist.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

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

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
