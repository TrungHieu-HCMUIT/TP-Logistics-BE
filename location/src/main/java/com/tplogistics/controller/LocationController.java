package com.tplogistics.controller;

import com.tplogistics.controller.dto.request.LocationCreateRequest;
import com.tplogistics.controller.dto.response.LocationResponse;
import com.tplogistics.core.service.LocationService;
import controller.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/location")
public class LocationController extends BaseController {

    private final LocationService locationService;
    private final ModelMapper modelMapper;

    @PostMapping("v1/create")
    ResponseEntity<Object> createLocation(@RequestBody LocationCreateRequest request) {
        return successResponse(locationService.createLocation(request));
    }

    @GetMapping("v1/get/{id}")
    ResponseEntity<Object> findLocationById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        var result = locationService.findLocation(uuid);
        return successResponse(modelMapper.map(result, LocationResponse.class));
    }

    @GetMapping("v1/list/{keyword}")
    ResponseEntity<Object> findLocationByName(@PathVariable String keyword) {
        var locations = locationService.findLocationByName(keyword);
        var result = locations.stream().map(
                e -> modelMapper.map(e, LocationResponse.class)
        ).toList();

        return successResponse(result);
    }

}
