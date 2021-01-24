package com.company.jobs.converter;

import com.company.jobs.entity.Location;
import com.company.jobs.exception.NotFoundException;
import com.company.jobs.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToLocation implements Converter<String, Location> {

    private final LocationRepository locationRepository;

    @Autowired
    public StringToLocation(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location convert(String source) {
        Long id = Long.valueOf(source);
        return locationRepository.findById(id).orElseThrow(() -> new NotFoundException("Location with id: "
                + id + " is not found."));
    }
}