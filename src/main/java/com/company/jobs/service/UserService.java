package com.company.jobs.service;

import com.company.jobs.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO findById(Long userId);
}
