package com.company.jobs.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryDTO extends BaseDTO {

    private static final long serialVersionUID = 9140210168528699939L;

    @NotBlank
    @Size(max = 50)
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(@NotBlank @Size(max = 50) String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
