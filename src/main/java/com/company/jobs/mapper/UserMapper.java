package com.company.jobs.mapper;

import com.company.jobs.dto.UserDTO;
import com.company.jobs.entity.Role;
import com.company.jobs.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    private final ReferenceMapper referenceMapper = new ReferenceMapper();

    public UserMapper() {
    }

    @Mapping(target = "roles", source = "userDTO.roleIds")
    public User mapToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        if (userDTO.getRoleIds() != null) {
            user.setRoles(findRoles(userDTO.getRoleIds()));
        }

        return user;
    }

    @Mapping(target = "roleIds", source = "user.roles")
    @Mapping(target = "matchingPassword", source = "user.password")
    public UserDTO mapToUserDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setMatchingPassword(user.getPassword());
        userDTO.setRoleIds(findRoleIds(user.getRoles()));

        return userDTO;
    }

    private List<Role> findRoles(List<Long> roleIds) {
        List<Role> roles = new ArrayList<>();
        for (Long id : roleIds) {
            roles.add(referenceMapper.toEntity(id, Role.class));
        }
        return roles;
    }

    private List<Long> findRoleIds(List<Role> roles) {
        List<Long> roleIds = new ArrayList<>();
        for (Role role : roles) {
            roleIds.add(role.getId());
        }
        return roleIds;
    }
}
