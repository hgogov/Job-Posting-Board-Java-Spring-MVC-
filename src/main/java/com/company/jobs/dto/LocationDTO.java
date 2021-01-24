package com.company.jobs.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LocationDTO extends BaseDTO{

    private static final long serialVersionUID = 385073258478642854L;

    @NotBlank
    @Size(max = 30)
    private String name;

    public LocationDTO() {
    }

    public LocationDTO(@NotBlank @Size(max = 30) String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
