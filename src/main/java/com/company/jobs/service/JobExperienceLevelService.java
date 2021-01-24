package com.company.jobs.service;

import com.company.jobs.dto.JobExperienceLevelDTO;

import java.util.List;

public interface JobExperienceLevelService {

    List<JobExperienceLevelDTO> findAll();

    JobExperienceLevelDTO findById(Long jobExperienceLevelId);
}
