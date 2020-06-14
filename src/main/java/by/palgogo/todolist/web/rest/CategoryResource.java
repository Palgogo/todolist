package by.palgogo.todolist.web.rest;

import by.palgogo.todolist.domain.Category;
import by.palgogo.todolist.service.CategoryService;
import by.palgogo.todolist.service.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Transactional
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")

    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id) {
        Optional<Category> categoryById = categoryService.getCategoryById(id);
        return (ResponseEntity<?>) categoryById.map((response) -> ((ResponseEntity.BodyBuilder) ResponseEntity.ok().body(response)))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/categories")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDTO category) throws URISyntaxException {
        final CategoryDTO result = categoryService.createCategory(category);

        return ResponseEntity.created(new URI("/api/categories" + result.getId()))
                .body(result);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
