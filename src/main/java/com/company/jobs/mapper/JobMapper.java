package com.company.jobs.mapper;

import com.company.jobs.dto.JobDTO;
import com.company.jobs.entity.*;
import com.company.jobs.service.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class JobMapper {

    public JobMapper() {
    }

    @Mappings({
            @Mapping(target = "category", source = "jobDTO.categoryId"),
            @Mapping(target = "location", source = "jobDTO.locationId"),
            @Mapping(target = "type", source = "jobDTO.typeId"),
            @Mapping(target = "experienceLevel", source = "jobDTO.experienceLevelId"),
            @Mapping(target = "company", source = "jobDTO.companyId"),
    })
    public Job mapToJob(JobDTO jobDTO) {
        if (jobDTO == null) {
            return null;
        }

        Job job = new Job();
        job.setName(jobDTO.getName());
        job.setDescription(jobDTO.getDescription());
        job.setCategory(jobDTO.getCategory());
        job.setCompany(jobDTO.getCompany());
        job.setType(jobDTO.getType());
        job.setExperienceLevel(jobDTO.getExperienceLevel());
        job.setLocation(jobDTO.getLocation());

        return job;
    }

    @Mappings({
            @Mapping(target = "categoryId", source = "job.category"),
            @Mapping(target = "locationId", source = "job.location"),
            @Mapping(target = "typeId", source = "job.type"),
            @Mapping(target = "experienceLevelId", source = "job.experienceLevel"),
            @Mapping(target = "companyId", source = "job.company"),
    })
    public JobDTO mapToJobDTO(Job job) {
        if (job == null) {
            return null;
        }

        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setName(job.getName());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setCategory(job.getCategory());
        jobDTO.setCompany(job.getCompany());
        jobDTO.setExperienceLevel(job.getExperienceLevel());
        jobDTO.setType(job.getType());
        jobDTO.setLocation(job.getLocation());

        return jobDTO;
    }
}
