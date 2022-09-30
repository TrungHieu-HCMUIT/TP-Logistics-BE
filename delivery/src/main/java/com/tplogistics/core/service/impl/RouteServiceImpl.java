package com.tplogistics.core.service.impl;

import com.tplogistics.controller.dto.request.RouteCreateRequest;
import com.tplogistics.core.domain.entity.Route;
import com.tplogistics.core.error_handling.custom_error.RouteNotFound;
import com.tplogistics.core.service.LocationService;
import com.tplogistics.core.service.RouteService;
import com.tplogistics.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    @Resource
    private final RouteRepository routeRepository;

    @Override
    public UUID createRoute(RouteCreateRequest request) {
//        UUID fromLocationUUID = UUID.fromString(request.getFromLocationId());
//        UUID toLocationUUID = UUID.fromString(request.getToLocationId());
//
//        var fromLocation = locationService.findLocation(fromLocationUUID);
//        var toLocation = locationService.findLocation(toLocationUUID);
//
//        Route route = Route.builder()
//                .fromLocation(fromLocation)
//                .toLocation(toLocation)
//                .length(request.getLength())
//                .tripBasedCost(request.getTripBasedCost())
//                .tonBasedCostPerKm(request.getTonBasedPerKmCost())
//                .tonBasedLimit(request.getTonBasedLimit())
//                .isEnabled(true)
//                .build();
//        Route result = routeRepository.save(route);
//        return result.getId();
        return null;
    }

    @Override
    public Route findRoute(UUID id) {
//        var result = routeRepository.findById(id);
//        if (result.isEmpty()) {
//            throw new RouteNotFound("Route not found");
//        }
//        return result.get();
        return null;
    }

    @Override
    public List<Route> findRouteByLocationName(String fromLocationName, String toLocationName) {
//        if (fromLocationName.isBlank() && toLocationName.isBlank()) {
//            throw new InvalidRequest("Invalid location name");
//        }

        var result = routeRepository.findRouteByFromLocationNameAndToLocationName(fromLocationName, toLocationName);
//        if (fromLocationName.isBlank()) { // Find by toLocationName
//            result = routeRepository.findByToLocationNameIgnoreCaseContaining(toLocationName);
//        }
//        else if (toLocationName.isBlank()) { // Find by fromLocationName
//            result = routeRepository.findByFromLocationNameIgnoreCaseContaining(fromLocationName);
//        }
//        else { // Find by both
//            result = routeRepository.findByFromLocationNameAndToLocationName(fromLocationName, toLocationName);
//        }
        return null;
    }

}
