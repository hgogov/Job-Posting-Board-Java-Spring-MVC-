package com.company.jobs.mapper;

import com.company.jobs.dto.RoleDTO;
import com.company.jobs.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role mapToRole(RoleDTO roleDTO);

    RoleDTO mapToRoleDTO(Role role);
}
