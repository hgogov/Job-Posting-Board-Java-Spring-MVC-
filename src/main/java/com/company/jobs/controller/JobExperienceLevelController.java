package com.company.jobs.controller;

import com.company.jobs.dto.JobExperienceLevelDTO;
import com.company.jobs.service.JobExperienceLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/job_experience_levels")
public class JobExperienceLevelController {

    private final JobExperienceLevelService jobExperienceLevelService;

    @Autowired
    public JobExperienceLevelController(JobExperienceLevelService jobExperienceLevelService) {
        this.jobExperienceLevelService = jobExperienceLevelService;
    }

    @GetMapping
    public ResponseEntity<List<JobExperienceLevelDTO>> findAll() {

        List<JobExperienceLevelDTO> jobExperienceLevelDTOS = jobExperienceLevelService.findAll();
        return ResponseEntity.ok(jobExperienceLevelDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobExperienceLevelDTO> findById(@PathVariable Long id) {

        JobExperienceLevelDTO foundJobExperienceLevel = jobExperienceLevelService.findById(id);
        return ResponseEntity.ok(foundJobExperienceLevel);
    }
}
