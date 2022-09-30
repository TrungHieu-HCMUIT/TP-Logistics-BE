package com.tplogistics.core.service;

import com.tplogistics.controller.dto.request.LocationCreateRequest;
import com.tplogistics.controller.dto.response.LocationResponse;
import com.tplogistics.core.domain.entity.Location;

import java.util.List;
import java.util.UUID;

public interface LocationService {
    UUID createLocation(LocationCreateRequest request);
    LocationResponse findLocation(UUID id);
    List<LocationResponse> findLocationByName(String keyword);
}
