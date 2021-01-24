package com.company.jobs.service;

import com.company.jobs.dto.JobTypeDTO;

import java.util.List;

public interface JobTypeService {

    List<JobTypeDTO> findAll();

    JobTypeDTO findById(Long jobTypeId);
}
