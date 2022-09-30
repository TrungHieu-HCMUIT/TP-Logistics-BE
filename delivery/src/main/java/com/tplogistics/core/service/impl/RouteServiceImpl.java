package com.tplogistics.core.service.impl;

import com.tplogistics.controller.dto.request.RouteCreateRequest;
import com.tplogistics.core.domain.entity.Route;
import com.tplogistics.core.error_handling.custom_error.InvalidRequest;
import com.tplogistics.core.error_handling.custom_error.RouteNotFound;
import com.tplogistics.core.service.LocationService;
import com.tplogistics.core.service.RouteService;
import com.tplogistics.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    private final LocationService locationService;

    @Override
    public UUID createRoute(RouteCreateRequest request) {
        UUID fromLocationUUID = UUID.fromString(request.getFromLocationId());
        UUID toLocationUUID = UUID.fromString(request.getToLocationId());

        var fromLocation = locationService.findLocation(fromLocationUUID);
        var toLocation = locationService.findLocation(toLocationUUID);

        Route route = Route.builder()
                .fromLocation(fromLocation)
                .toLocation(toLocation)
                .length(request.getLength())
                .tripBasedCost(request.getTripBasedCost())
                .tonBasedCostPerKm(request.getTonBasedPerKmCost())
                .tonBasedLimit(request.getTonBasedLimit())
                .isEnabled(true)
                .build();
        Route result = routeRepository.save(route);
        return result.getRouteId();
    }

    @Override
    public Route findRoute(UUID id) {
        var result = routeRepository.findById(id);
        if (result.isEmpty()) {
            throw new RouteNotFound("Route not found");
        }
        return result.get();
    }

    @Override
    public List<Route> findRouteByLocationName(String fromLocationName, String toLocationName) {
        if (fromLocationName.isBlank() && toLocationName.isBlank()) {
            throw new InvalidRequest("Invalid location name");
        }



        return null;
    }
}
