package com.tplogistics.controller;

import com.tplogistics.controller.dto.request.LocationCreateRequest;
import com.tplogistics.core.service.LocationService;
import controller.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class LocationController extends BaseController {

    private final LocationService locationService;

    @PostMapping("v1/create")
    ResponseEntity<Object> createLocation(@RequestBody LocationCreateRequest request) {
        return successResponse(locationService.createLocation(request));
    }

    @GetMapping("v1/get/{id}")
    ResponseEntity<Object> findLocationById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        return successResponse(locationService.findLocation(uuid));
    }

    @GetMapping("v1/list/{keyword}")
    ResponseEntity<Object> findLocationByName(@PathVariable String keyword) {
        return successResponse(locationService.findLocationByName(keyword));
    }

}
