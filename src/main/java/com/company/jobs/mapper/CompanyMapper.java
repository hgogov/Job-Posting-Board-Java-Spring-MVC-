package com.company.jobs.mapper;

import com.company.jobs.dto.CompanyDTO;
import com.company.jobs.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company mapToCompany(CompanyDTO companyDTO);

    CompanyDTO mapToCompanyDTO(Company company);
}
