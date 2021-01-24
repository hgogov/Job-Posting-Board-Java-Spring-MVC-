package com.company.jobs.mapper;

import com.company.jobs.dto.JobTypeDTO;
import com.company.jobs.entity.JobType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobTypeMapper {

    JobType jobTypeDTOToJobType(JobTypeDTO jobTypeDTO);

    JobTypeDTO jobTypeToJobTypeDTO(JobType jobType);
}
