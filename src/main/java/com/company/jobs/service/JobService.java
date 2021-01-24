package com.company.jobs.service;

import com.company.jobs.dto.JobDTO;
import com.company.jobs.dto.SearchDTO;
import com.company.jobs.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobService {

    List<JobDTO> findAll();

    JobDTO findById(Long jobId);

    Job create(JobDTO jobDTO);

    Job updateById(Long id, JobDTO jobDTO);

    void delete(Long id);

    List<JobDTO> search(SearchDTO searchDTO);

    Page<JobDTO> findAllPaginated(Pageable pageable);

    Page<JobDTO> searchPaginated(Pageable pageable, SearchDTO searchDTO);
}
