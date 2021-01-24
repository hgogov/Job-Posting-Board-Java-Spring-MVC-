package com.company.jobs.service.impl;

import com.company.jobs.dto.CompanyDTO;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.mapper.CompanyMapper;
import com.company.jobs.repository.CompanyRepository;
import com.company.jobs.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper mapper;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, CompanyMapper mapper) {
        this.companyRepository = companyRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CompanyDTO> findAll() {
        return companyRepository.findAll()
                .stream()
                .map(mapper::mapToCompanyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO findById(Long companyId) {
        return mapper.mapToCompanyDTO(companyRepository.findById(companyId)
                .orElseThrow(() -> new NotFoundException("Company with id: "
                        + companyId + " is not found.")));
    }
}
