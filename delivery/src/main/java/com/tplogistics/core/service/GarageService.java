package com.tplogistics.core.service;

import com.tplogistics.controller.dto.request.GarageCreateRequest;
import com.tplogistics.controller.dto.request.LocationCreateRequest;
import com.tplogistics.core.domain.entity.Garage;
import com.tplogistics.core.domain.entity.Location;

import java.util.List;
import java.util.UUID;

public interface GarageService {
    UUID createGarage(GarageCreateRequest request);
    Garage findGarage(UUID id);
    List<Garage> findGarageByName(String keyword);
}
