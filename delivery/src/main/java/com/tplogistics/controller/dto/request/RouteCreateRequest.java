package com.tplogistics.controller.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
public class RouteCreateRequest {
    @NotNull(message = "Invalid location id")
    String fromLocationId;

    @NotNull(message = "Invalid location id")
    String toLocationId;

    @NotNull(message = "Length cannot be null")
    @Positive(message = "Invalid length")
    Double length;

    @NotNull(message = "Cost cannot be null")
    @Positive(message = "Invalid cost")
    Double tripBasedCost;

    @NotNull(message = "Cost cannot be null")
    @Positive(message = "Invalid cost")
    Double tonBasedCostPerKm;

    @NotNull(message = "Limit cannot be null")
    @Positive(message = "Invalid limit")
    Double tonBasedLimit;

    Boolean isEnabled;
}
