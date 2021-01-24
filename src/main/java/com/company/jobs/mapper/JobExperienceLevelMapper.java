package com.company.jobs.mapper;

import com.company.jobs.dto.JobExperienceLevelDTO;
import com.company.jobs.entity.JobExperienceLevel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobExperienceLevelMapper {

    JobExperienceLevel mapToJobExperienceLevel(JobExperienceLevelDTO jobExperienceLevelDTO);

    JobExperienceLevelDTO mapToJobExperienceLevelDTO(JobExperienceLevel jobExperienceLevel);
}
