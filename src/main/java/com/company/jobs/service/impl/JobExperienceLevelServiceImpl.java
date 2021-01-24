package com.company.jobs.service.impl;

import com.company.jobs.dto.JobExperienceLevelDTO;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.mapper.JobExperienceLevelMapper;
import com.company.jobs.repository.JobExperienceLevelRepository;
import com.company.jobs.service.JobExperienceLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobExperienceLevelServiceImpl implements JobExperienceLevelService {

    private final JobExperienceLevelRepository jobExperienceLevelRepository;
    private final JobExperienceLevelMapper mapper;

    @Autowired
    public JobExperienceLevelServiceImpl(JobExperienceLevelRepository jobExperienceLevelRepository, JobExperienceLevelMapper mapper) {
        this.jobExperienceLevelRepository = jobExperienceLevelRepository;
        this.mapper = mapper;
    }

    @Override
    public List<JobExperienceLevelDTO> findAll() {
        return jobExperienceLevelRepository.findAll()
                .stream()
                .map(mapper::mapToJobExperienceLevelDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JobExperienceLevelDTO findById(Long jobExperienceLevelId) {
        return mapper.mapToJobExperienceLevelDTO(jobExperienceLevelRepository.findById(jobExperienceLevelId)
                .orElseThrow(() -> new NotFoundException("Job experience level with id: "
                        + jobExperienceLevelId + " is not found.")));
    }
}
