package com.company.jobs.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RoleDTO extends BaseDTO {

    private static final long serialVersionUID = -328724336239253385L;

    @NotBlank
    @Size(max = 20)
    private String name;

    public RoleDTO() {
    }

    public RoleDTO(@NotBlank @Size(max = 20) String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
