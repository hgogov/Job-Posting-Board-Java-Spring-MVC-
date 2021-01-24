package com.company.jobs.controller;

import com.company.jobs.dto.LocationDTO;
import com.company.jobs.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<LocationDTO>> findAll() {

        List<LocationDTO> locationDTOS = locationService.findAll();
        return ResponseEntity.ok(locationDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> findById(@PathVariable Long id) {
        
        LocationDTO foundLocation = locationService.findById(id);
        return ResponseEntity.ok(foundLocation);
    }
}
