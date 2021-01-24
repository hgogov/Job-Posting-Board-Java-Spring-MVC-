package com.company.jobs.controller;

import com.company.jobs.dto.CompanyDTO;
import com.company.jobs.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> findAll() {

        List<CompanyDTO> companyDTOS = companyService.findAll();
        return ResponseEntity.ok(companyDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable Long id) {

        CompanyDTO foundCompany = companyService.findById(id);
        return ResponseEntity.ok(foundCompany);
    }
}
