package com.company.jobs.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {

    private static final long serialVersionUID = 3892834339579248850L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
