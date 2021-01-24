package com.company.jobs.service;

import com.company.jobs.dto.LocationDTO;

import java.util.List;

public interface LocationService {

    List<LocationDTO> findAll();

    LocationDTO findById(Long locationId);
}
