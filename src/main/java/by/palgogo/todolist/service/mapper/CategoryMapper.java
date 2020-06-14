package by.palgogo.todolist.service.mapper;

import by.palgogo.todolist.domain.Category;
import by.palgogo.todolist.service.dto.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);

    Category toCategory(CategoryDTO categoryDTO);
}
