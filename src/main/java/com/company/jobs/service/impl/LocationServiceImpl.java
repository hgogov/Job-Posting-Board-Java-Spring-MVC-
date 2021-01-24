package com.company.jobs.service.impl;

import com.company.jobs.dto.LocationDTO;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.mapper.LocationMapper;
import com.company.jobs.repository.LocationRepository;
import com.company.jobs.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper mapper;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, LocationMapper mapper) {
        this.locationRepository = locationRepository;
        this.mapper = mapper;
    }

    @Override
    public List<LocationDTO> findAll() {
        return locationRepository.findAll()
                .stream()
                .map(mapper::locationToLocationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDTO findById(Long locationId) {
        return mapper.locationToLocationDTO(locationRepository.findById(locationId)
                .orElseThrow(() -> new NotFoundException("Location with id: "
                        + locationId + " is not found.")));
    }
}
