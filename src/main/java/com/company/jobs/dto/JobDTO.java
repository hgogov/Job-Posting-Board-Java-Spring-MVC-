package com.company.jobs.dto;

import com.company.jobs.entity.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class JobDTO extends BaseDTO {

    private static final long serialVersionUID = -1718810569389607756L;

    @NotBlank(message = "Field should not be empty.")
    @Size(min = 3, max = 128, message = "Name should be between 3 and 128 characters long.")
    private String name;

    @NotBlank(message = "Field should not be empty.")
    @Size(min = 4, max = 10240, message = "Description should be between 4 and 10240 characters long.")
    private String description;

    @NotNull(message = "Field should not be empty.")
    private Category category;

    @NotNull(message = "Field should not be empty.")
    private Location location;

    @NotNull(message = "Field should not be empty.")
    private JobType type;

    @NotNull(message = "Field should not be empty.")
    private JobExperienceLevel experienceLevel;

    @NotNull(message = "Field should not be empty.")
    private Company company;

    public JobDTO() {
    }

    public JobDTO(@NotBlank @Size(max = 128) String name, @NotBlank @Size(max = 10240) String description, Category category, Location location, JobType type, JobExperienceLevel experienceLevel, Company company) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.location = location;
        this.type = type;
        this.experienceLevel = experienceLevel;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public JobExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(JobExperienceLevel experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
