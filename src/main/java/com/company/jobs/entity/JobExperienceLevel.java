package com.company.jobs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "job_experience_levels")
public class JobExperienceLevel extends BaseEntity {

    private static final long serialVersionUID = -8187042129923187608L;

    @NotNull
    @Size(max = 30)
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JobExperienceLevel that = (JobExperienceLevel) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "JobExperienceLevel{" +
                "name='" + name + '\'' +
                '}';
    }
}
