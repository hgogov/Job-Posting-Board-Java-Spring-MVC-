package com.company.jobs.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class JobExperienceLevelDTO extends BaseDTO{

    private static final long serialVersionUID = -222529451270954562L;

    @NotBlank
    @Size(max = 30)
    private String name;

    public JobExperienceLevelDTO() {
    }

    public JobExperienceLevelDTO(@NotBlank @Size(max = 30) String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
