package com.company.jobs.converter;

import com.company.jobs.entity.JobExperienceLevel;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.repository.JobExperienceLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;


@Component
public class StringToJobExperienceLevel implements Converter<String, JobExperienceLevel> {

    private final JobExperienceLevelRepository jobExperienceLevelRepository;

    @Autowired
    public StringToJobExperienceLevel(JobExperienceLevelRepository jobExperienceLevelRepository) {
        this.jobExperienceLevelRepository = jobExperienceLevelRepository;
    }

    @Override
    public JobExperienceLevel convert(String source) {
        Long id = Long.valueOf(source);
        return jobExperienceLevelRepository.findById(id).orElseThrow(() -> new NotFoundException("JobExperienceLevel with id: "
                + id + " is not found."));
    }
}
