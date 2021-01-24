package com.company.jobs.service;

import com.company.jobs.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> findAll();

    RoleDTO findById(Long roleId);
}
