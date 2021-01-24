package com.company.jobs.service.impl;

import com.company.jobs.dto.CategoryDTO;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.mapper.CategoryMapper;
import com.company.jobs.repository.CategoryRepository;
import com.company.jobs.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(mapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findById(Long categoryId) {
        return mapper.categoryToCategoryDTO(categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Category with id: "
                        + categoryId + " is not found.")));
    }
}
