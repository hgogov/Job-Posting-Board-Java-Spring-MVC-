package com.company.jobs.converter;

import com.company.jobs.entity.Company;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCompany implements Converter<String, Company> {

    private final CompanyRepository companyRepository;

    @Autowired
    public StringToCompany(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company convert(String source) {
        Long id = Long.valueOf(source);
        return companyRepository.findById(id).orElseThrow(() -> new NotFoundException("Company with id: "
                + id + " is not found."));
    }
}
