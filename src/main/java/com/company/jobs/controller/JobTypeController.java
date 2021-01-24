package com.company.jobs.controller;

import com.company.jobs.dto.JobTypeDTO;
import com.company.jobs.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job_types")
public class JobTypeController {

    private final JobTypeService jobTypeService;

    @Autowired
    public JobTypeController(JobTypeService jobTypeService) {
        this.jobTypeService = jobTypeService;
    }

    @GetMapping
    public ResponseEntity<List<JobTypeDTO>> findAll() {

        List<JobTypeDTO> jobTypeDTOS = jobTypeService.findAll();
        return ResponseEntity.ok(jobTypeDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobTypeDTO> findById(@PathVariable Long id) {

        JobTypeDTO foundJobType = jobTypeService.findById(id);
        return ResponseEntity.ok(foundJobType);
    }
}
