package by.palgogo.todolist.service.mapper;

import by.palgogo.todolist.domain.Category;
import by.palgogo.todolist.service.dto.CategoryDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);

    Category toCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> toCategoryList(List<Category> categories);
}
