package com.company.jobs.service.impl;

import com.company.jobs.dto.JobTypeDTO;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.mapper.JobTypeMapper;
import com.company.jobs.repository.JobTypeRepository;
import com.company.jobs.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobTypeServiceImpl implements JobTypeService {

    private final JobTypeRepository jobTypeRepository;
    private final JobTypeMapper mapper;

    @Autowired
    public JobTypeServiceImpl(JobTypeRepository jobTypeRepository, JobTypeMapper mapper) {
        this.jobTypeRepository = jobTypeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<JobTypeDTO> findAll() {
        return jobTypeRepository.findAll()
                .stream()
                .map(mapper::jobTypeToJobTypeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JobTypeDTO findById(Long jobTypeId) {
        return mapper.jobTypeToJobTypeDTO(jobTypeRepository.findById(jobTypeId)
                .orElseThrow(() -> new NotFoundException("Job type with id: "
                        + jobTypeId + " is not found.")));
    }
}
