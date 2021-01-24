package com.company.jobs.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class JobTypeDTO extends BaseDTO{

    private static final long serialVersionUID = -1070282293030530467L;

    @NotBlank
    @Size(max = 20)
    private String name;

    public JobTypeDTO() {
    }

    public JobTypeDTO(@NotBlank @Size(max = 20) String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
