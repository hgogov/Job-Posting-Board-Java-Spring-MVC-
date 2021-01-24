package com.company.jobs.repository;

import com.company.jobs.entity.JobExperienceLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobExperienceLevelRepository extends JpaRepository<JobExperienceLevel, Long> {
}
