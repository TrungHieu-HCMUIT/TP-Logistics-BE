package com.tplogistics.controller;

import com.tplogistics.controller.dto.request.RouteCreateRequest;
import com.tplogistics.controller.dto.response.RouteResponse;
import com.tplogistics.core.domain.entity.Route;
import com.tplogistics.core.service.RouteService;
import controller.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/route")
public class RouteController extends BaseController {

    private final ModelMapper modelMapper;
    private final RouteService routeService;

    @PostMapping("v1/create")
    ResponseEntity<Object> createRoute(@RequestBody RouteCreateRequest request) {
        return successResponse(routeService.createRoute(request));
    }

    @GetMapping("v1/get/{id}")
    ResponseEntity<Object> findRouteById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        Route route = routeService.findRoute(uuid);

        RouteResponse response = modelMapper.map(route, RouteResponse.class);
        return successResponse(response);
    }

    @GetMapping("v1/list")
    ResponseEntity<Object> findRouteByLocationName(@RequestParam String fromLocationName, @RequestParam String toLocationName) {
        List<Route> routes = routeService.findRouteByLocationName(fromLocationName, toLocationName);
        List<RouteResponse> response = routes.stream()
                .map( route ->
                        modelMapper.map(route, RouteResponse.class)
                ).toList();
        return successResponse(response);
    }

}
