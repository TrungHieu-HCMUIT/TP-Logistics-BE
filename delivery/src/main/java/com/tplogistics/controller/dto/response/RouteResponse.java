package com.tplogistics.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RouteResponse {
    UUID id;
    LocationResponse fromLocation;
    LocationResponse toLocation;
    Double length;
    Double tripBasedCost;
    Double tonBasedCostPerKm;
    Double tonBasedLimit;
    Boolean isEnabled;
}
