package com.tplogistics.core.service.impl;

import com.tplogistics.controller.dto.request.create.LocationCreateRequest;
import com.tplogistics.core.domain.entity.Location;
import com.tplogistics.core.error_handling.custom_error.InvalidRequest;
import com.tplogistics.core.error_handling.custom_error.NotFoundException;
import com.tplogistics.core.service.LocationService;
import com.tplogistics.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;

    @Override
    public UUID createLocation(LocationCreateRequest request) {
        Location location = Location.builder()
                .name(request.getName())
                .address(request.getAddress())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .build();

        var result = locationRepository.save(location);
        return result.getLocationId();
    }

    @Override
    public Location findLocation(UUID id) {
        var location = locationRepository.findById(id);

        if (location.isEmpty()) {
            throw new NotFoundException("Location not found");
        }

        return location.get();
    }

    @Override
    public List<Location> findLocationByName(String keyword) {
        if (keyword.isBlank()) {
            throw new InvalidRequest("Invalid keyword");
        }

        return locationRepository.findByNameIgnoreCaseContaining(keyword.toLowerCase());
    }


}
