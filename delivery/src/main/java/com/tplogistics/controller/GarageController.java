package com.tplogistics.controller;

import com.tplogistics.controller.dto.request.create.GarageCreateRequest;
import com.tplogistics.controller.dto.response.LocationResponse;
import com.tplogistics.core.service.GarageService;
import controller.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/garage")
public class GarageController extends BaseController {

    private final GarageService garageService;
    private final ModelMapper modelMapper;

    @PostMapping("v1/create")
    ResponseEntity<Object> createGarage(@RequestBody GarageCreateRequest request) {
        return successResponse(garageService.createGarage(request));
    }

    @GetMapping("v1/get/{id}")
    ResponseEntity<Object> findGarageById(@PathVariable String id) {
        UUID uuid = UUID.fromString(id);
        var result = garageService.findGarage(uuid);
        return successResponse(modelMapper.map(result, LocationResponse.class));
    }

    @GetMapping("v1/list/{keyword}")
    ResponseEntity<Object> findGarageByName(@PathVariable String keyword) {
        var locations = garageService.findGarageByName(keyword);
        var result = locations.stream().map(
                e -> modelMapper.map(e, LocationResponse.class)
        ).toList();

        return successResponse(result);
    }

}
