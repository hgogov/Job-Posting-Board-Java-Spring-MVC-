package com.company.jobs.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CompanyDTO extends BaseDTO {

    private static final long serialVersionUID = 9202293681867178458L;

    @NotBlank
    @Size(max = 50)
    private String name;

    public CompanyDTO() {
    }

    public CompanyDTO(@NotBlank @Size(max = 50) String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
