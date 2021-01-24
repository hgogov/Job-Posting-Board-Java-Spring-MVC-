package com.company.jobs.mapper;

import com.company.jobs.dto.LocationDTO;
import com.company.jobs.entity.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    Location locationDTOToLocation(LocationDTO locationDTO);

    LocationDTO locationToLocationDTO(Location location);
}
