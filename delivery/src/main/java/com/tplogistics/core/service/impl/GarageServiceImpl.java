package com.tplogistics.core.service.impl;

import com.tplogistics.controller.dto.request.create.GarageCreateRequest;
import com.tplogistics.core.domain.entity.Garage;
import com.tplogistics.core.error_handling.custom_error.InvalidRequest;
import com.tplogistics.core.error_handling.custom_error.NotFoundException;
import com.tplogistics.core.service.GarageService;
import com.tplogistics.repository.GarageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    @Override
    public UUID createGarage(GarageCreateRequest request) {
        Garage garage = Garage.builder()
                .name(request.getName())
                .address(request.getAddress())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .build();

        var result = garageRepository.save(garage);
        return result.getGarageId();
    }

    @Override
    public Garage findGarage(UUID id) {
        var location = garageRepository.findById(id);

        if (location.isEmpty()) {
            throw new NotFoundException("Location not found");
        }

        return location.get();
    }

    @Override
    public List<Garage> findGarageByName(String keyword) {
        if (keyword.isBlank()) {
            throw new InvalidRequest("Invalid keyword");
        }

        return garageRepository.findByNameIgnoreCaseContaining(keyword.toLowerCase());
    }
}
