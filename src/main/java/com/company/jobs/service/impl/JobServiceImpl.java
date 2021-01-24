package com.company.jobs.service.impl;

import com.company.jobs.dto.JobDTO;
import com.company.jobs.dto.SearchDTO;
import com.company.jobs.entity.Job;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.mapper.JobMapper;
import com.company.jobs.repository.JobRepository;
import com.company.jobs.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobMapper mapper;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository, JobMapper mapper) {
        this.jobRepository = jobRepository;
        this.mapper = mapper;
    }

    @Override
    public List<JobDTO> findAll() {
        return jobRepository.findAll()
                .stream()
                .map(mapper::mapToJobDTO)
                .collect(Collectors.toList());
    }

    @Override
    public JobDTO findById(Long jobId) {
        return mapper.mapToJobDTO(jobRepository.findById(jobId)
                .orElseThrow(() -> new NotFoundException("Job with id: "
                        + jobId + " is not found.")));
    }

    @Override
    public Job create(JobDTO jobDTO) {

        return jobRepository.saveAndFlush(mapper.mapToJob(jobDTO));
    }

    @Override
    public Job updateById(Long id, JobDTO jobDTO) {
        Job jobToUpdate = jobRepository.findById(id).orElseThrow(() -> new NotFoundException("Job with id: "
                + id + " is not found."));
        jobToUpdate.setName(jobDTO.getName());
        jobToUpdate.setDescription(jobDTO.getDescription());
        jobToUpdate.setCategory(jobDTO.getCategory());
        jobToUpdate.setLocation(jobDTO.getLocation());
        jobToUpdate.setExperienceLevel(jobDTO.getExperienceLevel());
        jobToUpdate.setType(jobDTO.getType());
        jobToUpdate.setCompany(jobDTO.getCompany());
        return jobRepository.saveAndFlush(jobToUpdate);
    }


    @Override
    public void delete(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new NotFoundException("Job with id: "
                + id + " is not found."));
        jobRepository.delete(job);
    }

    public List<JobDTO> search(SearchDTO searchDTO) {
        List<Job> foundJobs = jobRepository.findByCriteria(searchDTO);

        return foundJobs.stream()
                .map(mapper::mapToJobDTO)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Page<JobDTO> findAllPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int start = currentPage * pageSize;
        List<JobDTO> foundJobs = findAll();

        if (foundJobs.size() < start) {
            foundJobs = Collections.emptyList();
        } else {
            int toIndex = Math.min(start + pageSize, foundJobs.size());
            foundJobs = foundJobs.subList(start, toIndex);
        }

        Page<JobDTO> jobsPaginated = new PageImpl<>(foundJobs, PageRequest.of(currentPage, pageSize), foundJobs.size());
        return jobsPaginated;
    }

    public Page<JobDTO> searchPaginated(Pageable pageable, SearchDTO searchDTO){
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int start = currentPage * pageSize;
        List<JobDTO> foundJobs = search(searchDTO);

        if (foundJobs.size() < start) {
            foundJobs = Collections.emptyList();
        } else {
            int toIndex = Math.min(start + pageSize, foundJobs.size());
            foundJobs = foundJobs.subList(start, toIndex);
        }

        Page<JobDTO> jobsPaginated = new PageImpl<>(foundJobs, PageRequest.of(currentPage, pageSize), foundJobs.size());
        return jobsPaginated;
    }
}
