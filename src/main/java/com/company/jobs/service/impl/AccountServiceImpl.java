package com.company.jobs.service.impl;

import com.company.jobs.dto.UserDTO;
import com.company.jobs.entity.Role;
import com.company.jobs.entity.User;
import com.company.jobs.enumeration.RoleEnum;
import com.company.jobs.exception.UserAlreadyExistsException;
import com.company.jobs.mapper.UserMapper;
import com.company.jobs.repository.RoleRepository;
import com.company.jobs.repository.UserRepository;
import com.company.jobs.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class AccountServiceImpl implements AccountService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper mapper, UserDetailsServiceImpl userDetailsService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        if (emailExists(userDTO.getEmail())) {
            throw new UserAlreadyExistsException("There is an account with that email address: "
                    + userDTO.getEmail());
        }

        List<Role> roles = new ArrayList<>();
        Role userRole = roleRepository.findByName(RoleEnum.USER.toString());
        roles.add(userRole);
        User user = mapper.mapToUser(userDTO);
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(user);

        UserDTO newUser = mapper.mapToUserDTO(user);
        return newUser;
    }

    private boolean emailExists(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return false;
        }
        return true;
    }
}
