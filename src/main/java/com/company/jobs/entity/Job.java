package com.company.jobs.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "jobs")
public class Job extends BaseEntity {

    private static final long serialVersionUID = -1976747309682609377L;

    @NotNull
    @Size(max = 128)
    @Column(name = "name")
    private String name;

    @NotNull
    @Size(max = 10240)
    @Column(name = "description")
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "type_id")
    private JobType type;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "experience_level_id")
    private JobExperienceLevel experienceLevel;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Job job = (Job) o;
        return Objects.equals(name, job.name) &&
                Objects.equals(description, job.description) &&
                Objects.equals(category, job.category) &&
                Objects.equals(location, job.location) &&
                Objects.equals(type, job.type) &&
                Objects.equals(experienceLevel, job.experienceLevel) &&
                Objects.equals(company, job.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, category, location, type, experienceLevel, company);
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", location=" + location +
                ", type=" + type +
                ", experienceLevel=" + experienceLevel +
                ", company=" + company +
                '}';
    }
}
