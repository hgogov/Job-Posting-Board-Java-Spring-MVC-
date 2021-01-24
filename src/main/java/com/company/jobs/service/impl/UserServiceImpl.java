package com.company.jobs.service.impl;

import com.company.jobs.dto.UserDTO;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.mapper.UserMapper;
import com.company.jobs.repository.UserRepository;
import com.company.jobs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(mapper::mapToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(Long userId) {
        return mapper.mapToUserDTO(userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User with id: "
                        + userId + " is not found.")));
    }
}
