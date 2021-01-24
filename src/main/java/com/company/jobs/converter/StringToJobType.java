package com.company.jobs.converter;

import com.company.jobs.entity.JobType;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.repository.JobTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
public class StringToJobType implements Converter<String, JobType> {

    private final JobTypeRepository jobTypeRepository;

    @Autowired
    public StringToJobType(JobTypeRepository jobTypeRepository) {
        this.jobTypeRepository = jobTypeRepository;
    }

    @Override
    public JobType convert(String source) {
        Long id = Long.valueOf(source);
        return jobTypeRepository.findById(id).orElseThrow(() -> new NotFoundException("Job type with id: "
                + id + " is not found."));
    }
}
