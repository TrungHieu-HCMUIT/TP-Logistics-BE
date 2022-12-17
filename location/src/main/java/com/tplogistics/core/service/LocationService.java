package com.tplogistics.core.service;

import com.tplogistics.controller.dto.request.LocationCreateRequest;
import com.tplogistics.core.domain.entity.Location;

import java.util.List;
import java.util.UUID;

public interface LocationService {
    UUID createLocation(LocationCreateRequest request);

    Location findLocation(UUID id);

    List<Location> findLocationByName(String keyword);
}
