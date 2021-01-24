package com.company.jobs.repository;

import com.company.jobs.dto.SearchDTO;
import com.company.jobs.entity.Job;

import java.util.List;

public interface JobCustomRepository {

    List<Job> findByCriteria(SearchDTO searchDTO);
}
