package com.company.jobs.service;

import com.company.jobs.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> findAll();

    CategoryDTO findById(Long id);
}
