package com.company.jobs.converter;

import com.company.jobs.entity.Category;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToCategory implements Converter<String, Category> {

    private final CategoryRepository categoryRepository;

    @Autowired
    public StringToCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category convert(String source) {
        Long id = Long.valueOf(source);
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category with id: "
                + id + " is not found."));
    }
}
