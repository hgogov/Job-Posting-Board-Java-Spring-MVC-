package com.company.jobs.service.impl;

import com.company.jobs.dto.RoleDTO;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.mapper.RoleMapper;
import com.company.jobs.repository.RoleRepository;
import com.company.jobs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper mapper;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper mapper) {
        this.roleRepository = roleRepository;
        this.mapper = mapper;
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleRepository.findAll()
                .stream()
                .map(mapper::mapToRoleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDTO findById(Long roleId) {
        return mapper.mapToRoleDTO(roleRepository.findById(roleId)
                .orElseThrow(() -> new NotFoundException("Role with id: "
                        + roleId + " is not found.")));
    }
}