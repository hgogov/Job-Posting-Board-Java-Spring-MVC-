package com.company.jobs.service;

import com.company.jobs.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {

    List<CompanyDTO> findAll();

    CompanyDTO findById(Long companyId);
}
