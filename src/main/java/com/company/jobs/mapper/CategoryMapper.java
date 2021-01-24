package com.company.jobs.mapper;

import com.company.jobs.dto.CategoryDTO;
import com.company.jobs.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category categoryDTOToCategory(CategoryDTO categoryDTO);

    CategoryDTO categoryToCategoryDTO(Category category);
}
